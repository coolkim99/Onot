package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Activity act = this;
    ViewFlipper v_flipper;
    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int images[] = {
                R.drawable.one,
                R.drawable.two,
                R.drawable.three
        };
        //ViewFlipper 객체참조
        v_flipper = findViewById(R.id.image_slide);
        Animation showIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);

        //ViewFlipper에게 등장 애니메이션 적용
        v_flipper.setInAnimation(showIn);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
        v_flipper.setFlipInterval(1000);//플리핑 간격(1000ms)
        v_flipper.setAutoStart(true);//자동 Flipping 시작

        //활동 버튼 이벤트
        Button heartB = (Button) findViewById(R.id.heart);
        heartB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DonationActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //글쓰기 버튼 이벤트
        Button writeB = (Button) findViewById(R.id.plus);
        writeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Write.class);
                startActivity(intent);
                finish();
            }
        });
        //랭킹 버튼 이벤트
        Button rankB = (Button) findViewById(R.id.ranking);
        rankB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RankActivity.class);
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

        //뒤로가기 2번 종료
        backPressCloseHandler = new BackPressCloseHandler(this);

        //글 누르면
        Button b1 = (Button) findViewById(R.id.img1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BuyActivity.class);
                startActivity(intent);
            }
        });
        Button b2 = (Button) findViewById(R.id.img2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Buy2Activity.class);
                startActivity(intent);
            }
        });
        Button b3 = (Button) findViewById(R.id.img3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Buy3Activity.class);
                startActivity(intent);
            }
        });
        Button b4 = (Button) findViewById(R.id.img4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Buy4Activity.class);
                startActivity(intent);
            }
        });
        Button b5 = (Button) findViewById(R.id.img5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Buy5Activity.class);
                startActivity(intent);
            }
        });
        Button b6 = (Button) findViewById(R.id.img6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Buy6Activity.class);
                startActivity(intent);
            }
        });
    }
    public void onBackPressed(){
        backPressCloseHandler.onBackPressed();
    }
}











