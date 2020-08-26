package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class writeBuyActivity extends AppCompatActivity {
    Activity act = this;
    private TextView product2, price2, username, title2, donate, smallprice;
    final Context context = this;
    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writebuy);

        pager = (ViewPager) findViewById(R.id.pager);
        writeCustomAdapter adapter = new writeCustomAdapter(getLayoutInflater());
        pager.setAdapter(adapter);

        Button button = findViewById(R.id.order);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), writeBillActivity.class);//주문확인화면전환
                startActivity(intent);
            }
        });
        Button button2 = findViewById(R.id.cancel);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        String url = "http://jokj624.dothome.co.kr/getjson.php";
        username = (TextView) findViewById(R.id.Pname);
        price2 = (TextView) findViewById(R.id.price);
        product2 = (TextView) findViewById(R.id.exp);
        title2 = (TextView) findViewById(R.id.title);
        donate = (TextView)findViewById(R.id.donate);
        smallprice = (TextView) findViewById(R.id.price2);
        NetworkTask networkTask = new NetworkTask(url, null);
        networkTask.execute();


    }

    public class NetworkTask extends AsyncTask<Void, Void, String> {

    private String url;
    private ContentValues values;

    public NetworkTask(String url, ContentValues values) {

        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
        result = requestHttpURLConnection.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        doJSONParser(s);
        //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.

    }
    void doJSONParser(String str){
        try{
            String realname = "";
            String price = "";
            String text="";
            String realtitle="";
            String realdonate="";
            JSONObject order = new JSONObject(str);

            JSONArray index = order.getJSONArray("jokj624");
            for (int i = index.length()-1; i > index.length()-2; i--) {
                JSONObject tt = index.getJSONObject(i);
                realname += "" + tt.getString("Name") + "\n";
                price += "" + tt.getString("Price") + "\n";
                text += "" + tt.getString("Product2") + "\n";
                realtitle += "" + tt.getString("Title") + "\n";
                realdonate += ""+tt.getString("Donate")+"\n";
            }
            title2.setText(realtitle);
            username.setText(realname);
            price2.setText(price);
            product2.setText(text);
            donate.setText(realdonate);
            smallprice.setText(price);
        }
        catch (JSONException e){ ;}
    }
}
}

