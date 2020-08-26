package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class RankActivity extends AppCompatActivity {
    int rank = 2156;
    private BackPressCloseHandler backPressCloseHandler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        TextView nowDon = (TextView) findViewById(R.id.kg);
        nowDon.setText(new MyActivity().total + "");
        TextView tUserRank = (TextView) findViewById(R.id.userRank);
        tUserRank.setText(rank + "");

        //뒤로가기 2번 종료
        backPressCloseHandler = new BackPressCloseHandler(this);


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

        //활동 버튼 이벤트
        Button heartB = (Button)findViewById(R.id.heart);
        heartB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DonationActivity.class);
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

        //마이페이지 버튼 이벤트
        Button myB = (Button) findViewById(R.id.mypage);
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

