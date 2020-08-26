package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class joinSubActivity extends AppCompatActivity {
    ViewFlipper v_flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_sub);

        int images[] = {
                R.drawable.one,
                R.drawable.two,
                R.drawable.three
        };
        v_flipper = findViewById(R.id.image_slide);
        Animation showIn= AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);

        v_flipper.setInAnimation(showIn);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
        v_flipper.setFlipInterval(1000);//플리핑 간격(1000ms)
        v_flipper.setAutoStart(true);//자동 Flipping 시작

        Button button = findViewById(R.id.market);//화면전환예시
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), billActivity.class);//이전화면
                startActivity(intent);
                finish();
            }
        });
    }
}
