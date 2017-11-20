package com.example.rongyundemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class MainActivity extends AppCompatActivity {
    //token1 id=789  name=小王
    private String token1="0cNLFii+wtCxmfzAITzU6LCxUJsYzisU2qMq83buJaXckwRNs2I9XhIqMg1X+/GnZPuZQsW1f1m2JH3kl49c5Q==";
    //token2 id=678  name=小李
    private String token2="BhMdlk7sG1thJTLzYbAVC7CxUJsYzisU2qMq83buJaXckwRNs2I9Xmlu/1b0hp5jEUsLbdrZb9y2JH3kl49c5Q==";
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        connect(token2);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //服务器连接成功，跳转消息列表
                startActivity(new Intent(MainActivity.this, ConversationListActivity.class));
            }
        });


    }


    private void connect(String token) {
        RongIM.connect(token, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                Log.e("LoginActivity", "--onTokenIncorrect");
            }
            @Override
            public void onSuccess(String userid) {
                Log.e("LoginActivity", "--onSuccess--" + userid);
                Toast.makeText(MainActivity.this, "登录成功,用户：" + userid, Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.e("LoginActivity", "--onError");
            }
        });
    }

}
