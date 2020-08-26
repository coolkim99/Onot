package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MyActivity extends AppCompatActivity {
    int total = 2000;
    String name = "눈송이";
    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //뒤로가기 2번 종료
        backPressCloseHandler = new BackPressCloseHandler(this);

        //기부 금액
        TextView nowDon = (TextView)findViewById(R.id.donation);
        nowDon.setText(total+"");

        //사용자 이름
        TextView tName = (TextView)findViewById(R.id.textProfile);
        tName.setText(name+" 님");

        //회원정보 수정
        Button chgB = (Button)findViewById(R.id.changeInfo);
       chgB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChangeInfoActivity.class);
                startActivity(intent);
            }
        });

        //구매 내역
        Button buyB = (Button)findViewById(R.id.buyingList);
        buyB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BuyCheckActivity.class);
                startActivity(intent);
            }
        });

        //판매 내역
        Button sellB = (Button)findViewById(R.id.sellingList);
        sellB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SellActivity.class);
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
    }

    public void onBackPressed(){
        backPressCloseHandler.onBackPressed();
    }
}

