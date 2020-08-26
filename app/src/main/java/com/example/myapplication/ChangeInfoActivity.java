package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.*;

public class ChangeInfoActivity extends AppCompatActivity {
    EditText password, password2;
    ImageView setImage;
    boolean correct=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeinfo);
        //비밀번호확인
        password = findViewById(R.id.password);
        password2 = findViewById(R.id.password2);
        setImage = findViewById(R.id.setImage);

        password2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (password.getText().toString().equals(password2.getText().toString())) {
                    setImage.setImageResource(R.drawable.o);
                    correct=true;
                } else{
                    setImage.setImageResource(R.drawable.x);
                    correct=false;
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        Button mdB = (Button)findViewById(R.id.modify);
        mdB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModifyActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}