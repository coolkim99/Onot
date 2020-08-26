package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Buy4Activity extends AppCompatActivity {
    Activity act = this;
    ViewPager pager4;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy4);

        //ViewFlipper 객체참조
        pager4 = (ViewPager) findViewById(R.id.pager4);
        CustomAdapter4 adapter = new CustomAdapter4(getLayoutInflater());
        pager4.setAdapter(adapter);

        Button button = findViewById(R.id.order);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), billActivity4.class);//주문확인화면전환
                startActivity(intent);
                finish();
            }
        });

        Button button2 = findViewById(R.id.cancel);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
