package com.example.ssforward.janken;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class result_Activity extends AppCompatActivity {
    final int GU = 0;
    final int CHOKI = 1;
    final int PA = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_);

        int myHand = 0;
        Intent intent = getIntent();
        int id = intent.getIntExtra("MY_HAND", 0);

        switch (id) {
            case R.id.gu:
                ((TextView) findViewById(R.id.my_hand)).setText("グー！");
                myHand = GU;
                break;

            case R.id.choki:
                ((TextView) findViewById(R.id.my_hand)).setText("チョキ！");
                myHand = CHOKI;
                break;

            case R.id.pa:
                ((TextView) findViewById(R.id.my_hand)).setText("パー！");
                myHand = PA;
                break;
        }

        int comHand = (int)(Math.random() * 3);

        switch (comHand) {
            case GU:
                ((TextView) findViewById(R.id.com_hand)).setText("グー！");
                break;

            case CHOKI:
                ((TextView) findViewById(R.id.com_hand)).setText("チョキ！");
                break;

            case PA:
                ((TextView) findViewById(R.id.com_hand)).setText("パー！");
                break;
        }

        TextView resultLavel = (TextView) findViewById(R.id.result_label);
        int gameResult = (comHand - myHand + 3) % 3;

        switch (gameResult) {
            case 0:
                ((TextView) findViewById(R.id.result_label)).setText("あいこです");
                break;

            case 1:
                ((TextView) findViewById(R.id.result_label)).setText("あなたの勝ちです");
                break;

            case 2:
                ((TextView) findViewById(R.id.result_label)).setText("あなたの負けです");
                break;
        }
    }

    public void onBackButtonTapped(View view) {
        finish();
    }
}
