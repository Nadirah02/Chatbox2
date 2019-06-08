package com.nadirah.andoid.chatbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.applozic.mobicommons.commons.core.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import io.kommunicate.KmChatBuilder;
import io.kommunicate.Kommunicate;
import io.kommunicate.callbacks.KmCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Kommunicate.init(this, "2e8e2fcf6b4bbc05aea21cb18486d8571");

        List<String> agentList = new ArrayList();
        agentList.add("nadirahp@csedge.com"); // Add the agentID. The agent ID would be the email ID of your team member which they used to register on Kommunicate.

        List<String> botList = new ArrayList();
        botList.add("chatbot-wvobj"); // Go to Bots section(https://dashboard.kommunicate.io/bot) -> Integrated bots -> Copy botID

        new KmChatBuilder(this).setAgentIds(agentList).setBotIds(botList).launchChat(new KmCallback() {
            @Override
            public void onSuccess(Object message) {
                Utils.printLog(MainActivity.this, "ChatTest", "Success : " + message);
            }

            @Override
            public void onFailure(Object error) {
                Utils.printLog(MainActivity.this, "ChatTest", "Failure : " + error);
            }
        });


        Kommunicate.openConversation(this, null, new KmCallback() {
            @Override
            public void onSuccess(Object message) {
                Utils.printLog(MainActivity.this, "ChatTest", "Launch Success : " + message);
            }

            @Override
            public void onFailure(Object error) {
                Utils.printLog(MainActivity.this, "ChatTest", "Launch Failure : " + error);
            }
        });

        new KmChatBuilder(MainActivity.this)
                .setSingleChat(false) // Pass false if you would like to create new conversation every time user starts a chat. This is true by default which means only one conversation will open for the user every time the user starts a chat.
                .createChat(new KmCallback() {
                    @Override
                    public void onSuccess(Object message) {
                        Integer chatId = (Integer) message;
                    }

                    @Override
                    public void onFailure(Object error) {
                        Log.d("ChatTest", "Error : " + error);
                    }
                });

        List<String> agentIds = new ArrayList<>();
        agentIds.add("nadirahp@csedge.com"); // Add AGENT_ID(s) to this list. The AGENT_ID is the email ID your human agent used to singup on Kommunicate dashboard.
        List<String> botIds = new ArrayList<>();
        botIds.add("chatbot-wvobj"); // Add BOT_ID(s) to this list. Go to the Bots section (https://dashboard.kommunicate.io/bot) -> Integrated bots -> Copy botID

        new KmChatBuilder(MainActivity.this)
                .setSingleChat(true) // Pass false if you would like to create new conversation every time user starts a chat. This is true by default which means only one conversation will open for the user every time the user starts a chat.
                .setAgentIds(agentIds) // The conversation will be created with these human agent(s)
                .setBotIds(botIds) // The conversation will be created with these bot(s)
                .createChat(new KmCallback() {
                    @Override
                    public void onSuccess(Object message) {

                    }

                    @Override
                    public void onFailure(Object error) {

                    }
                });





    }
}
