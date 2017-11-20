package com.example.rongyundemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ConversationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversation);

        String sName = getIntent().getData().getQueryParameter("title");//获取昵称
        setTitle("与" + "小王" + "聊天中");
    }
}
