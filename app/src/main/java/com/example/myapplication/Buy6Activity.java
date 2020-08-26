package com.example.myapplication;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.viewpager.widget.ViewPager;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class Buy6Activity extends AppCompatActivity {
    Activity act = this;
    ViewPager pager6;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy6);

        //ViewFlipper 객체참조
        pager6 = (ViewPager) findViewById(R.id.pager6);
        CustomAdapter6 adapter = new CustomAdapter6(getLayoutInflater());
        pager6.setAdapter(adapter);

        Button button = findViewById(R.id.order);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), billActivity6.class);//주문확인화면전환
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
