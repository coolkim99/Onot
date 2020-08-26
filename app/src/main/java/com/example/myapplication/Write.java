package com.example.myapplication;

import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;


import androidx.appcompat.app.AppCompatActivity;

import static androidx.appcompat.widget.AppCompatDrawableManager.get;

public class Write extends AppCompatActivity {
    private BackPressCloseHandler backPressCloseHandler;
    //UI
    ImageView image1, image2, image3, image4;

    //constant
    final int PICTURE_REQUEST_CODE = 100;
    Button writebtn, heart, write;
    private EditText title, price, product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write);
        ImageView btnImage;
        //UI
        image1 = (ImageView)findViewById(R.id.imageView2);
        image2 = (ImageView)findViewById(R.id.imageView3);
        image3 = (ImageView)findViewById(R.id.imageView4);
        image4 = (ImageView) findViewById(R.id.imageView5);
        heart = (Button) findViewById(R.id.heart);

        writebtn = findViewById(R.id.write);
        btnImage = findViewById(R.id.imageView);
        btnImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                //사진을 여러개 선택할수 있도록 한다
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),  PICTURE_REQUEST_CODE);
            }
        });

        //취소 버튼
        Button cancelB = (Button)findViewById(R.id.writingCancel);
        cancelB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
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

        // 위젯에 대한 참조.

        // URL 설정.
        String url = "http://jokj624.dothome.co.kr/getjson.php";

        // AsyncTask를 통해 HttpURLConnection 수행.
        NetworkUtil.setNetworkPolicy();
        title = (EditText)findViewById(R.id.title);
        price = (EditText)findViewById(R.id.price);
        product = (EditText)findViewById(R.id.product);

        //작성하기 버튼
        write = (Button)findViewById(R.id.write);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PHPRequest request = new PHPRequest("http://jokj624.dothome.co.kr/Data_insert.php");
                    String result = request.PhPtest(String.valueOf(title.getText()),String.valueOf(price.getText()),String.valueOf(product.getText()));
                    if(result.equals("1")){
                        Toast.makeText(getApplication(),"작성완료",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplication(),"작성실패",Toast.LENGTH_SHORT).show();
                    }
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }

                Intent i = new Intent(getApplicationContext(), writeBuyActivity.class);
                startActivity(i);
                finish();
            }

        });

    }
    public void onBackPressed(){
        backPressCloseHandler.onBackPressed();
    }

    //@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == PICTURE_REQUEST_CODE)
        {
            if (resultCode == RESULT_OK)
            {

                //기존 이미지 지우기
                image1.setImageResource(0);
                image2.setImageResource(0);
                image3.setImageResource(0);
                image4.setImageResource(0);

                //ClipData 또는 Uri를 가져온다
                Uri uri = data.getData();
                ClipData clipData = data.getClipData();

                //이미지 URI 를 이용하여 이미지뷰에 순서대로 세팅한다.
                if(clipData!=null)
                {

                    for(int i = 0; i < 4; i++)
                    {
                        if(i<clipData.getItemCount()){
                            Uri urione =  clipData.getItemAt(i).getUri();

                            switch (i){
                                case 0:
                                    image1.setImageURI(urione);
                                    break;
                                case 1:
                                    image2.setImageURI(urione);

                                    break;
                                case 2:
                                    image3.setImageURI(urione);

                                    break;
                                case 3:
                                    image4.setImageURI(urione);

                                    break;
                            }

                        }
                    }

                }
                else if(uri != null)
                {
                    image1.setImageURI(uri);
                }
            }
        }
    }
}






