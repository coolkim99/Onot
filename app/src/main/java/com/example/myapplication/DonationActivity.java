package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DonationActivity extends AppCompatActivity {
    private BackPressCloseHandler backPressCloseHandler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        //뒤로가기 2번 종료
        backPressCloseHandler = new BackPressCloseHandler(this);

        //활동 페이지
        Button dB1 = (Button)findViewById(R.id.gibu1);
        dB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Donation_SubActivity.class);
                startActivity(intent);
            }
        });
        Button dB2 = (Button)findViewById(R.id.gibu2);
        dB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Donation_Sub2Activity.class);
                startActivity(intent);
            }
        });
        Button dB3 = (Button)findViewById(R.id.gibu3);
        dB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Donation_Sub3Activity.class);
                startActivity(intent);
            }
        });

        //마켓 버튼 이벤트
        Button marketB = (Button)findViewById(R.id.cloth);
        marketB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //글쓰기 버튼 이벤트
        Button writeB = (Button)findViewById(R.id.plus);
        writeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Write.class);
                startActivity(intent);
                finish();
            }
        });
        //랭킹 버튼 이벤트
        Button rankB = (Button)findViewById(R.id.ranking);
        rankB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RankActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //마이페이지 버튼 이벤트
        Button myB = (Button)findViewById(R.id.mypage);
        myB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    public void onBackPressed(){
        backPressCloseHandler.onBackPressed();
    }
}
