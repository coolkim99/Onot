package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.*;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;





public class JoinActivity extends AppCompatActivity {
    EditText password, password2;
    EditText [] id=new EditText[5];
    CheckBox c1, c2;
    ImageView setImage;
    final Context context = this;
    boolean fill=true, correct=false, check=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
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
        //중복확인 메세지창
        Button button = findViewById(R.id.checkbtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                check=true;
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                alertDialogBuilder
                        .setTitle("중복확인")
                        .setMessage("사용가능한 아이디입니다.")
                        .setCancelable(true)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                AlertDialog dialog = alertDialogBuilder.create();
                dialog.show();

            }

        });

        c1=findViewById(R.id.checkBox1);
        c2=findViewById(R.id.checkBox2);
        id[0] = findViewById(R.id.name);
        id[1]= findViewById(R.id.id);
        id[2]= findViewById(R.id.phone);
        id[3]= findViewById(R.id.addr);
        id[4]=findViewById(R.id.detail);
        Button join = findViewById(R.id.join);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //모든항목이 채워졌는지 확인
                for(int i=0;i<5;i++){
                    String get=id[i].getText().toString();

                    if(get.getBytes().length<=0)
                        fill=false;
                }
                //채워졌다면 회원가입완료 화면전환
                if(fill==true&&correct==true&&check==true&&c1.isChecked()&&c2.isChecked()){
                    Intent intent = new Intent(getApplicationContext(), joinSubActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                    alertDialogBuilder
                            .setTitle("알림")
                            .setMessage("모든 항목을 확인해주십시오.")
                            .setCancelable(true)
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });
                    AlertDialog dialog = alertDialogBuilder.create();
                    dialog.show();
                }

            }
        });


    }
}
