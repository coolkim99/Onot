package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.content.Context;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class writeBillActivity extends AppCompatActivity {
    EditText [] id=new EditText[4];
    final Context context = this;
    private TextView price3, price2, title, donate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_bill);

        String url = "http://jokj624.dothome.co.kr/getjson.php";

        price2 = (TextView) findViewById(R.id.price);
        price3= (TextView) findViewById(R.id.price3);
        title = (TextView) findViewById(R.id.pname);
        donate = (TextView)findViewById(R.id.price2);
        writeBillActivity.NetworkTask networkTask = new writeBillActivity.NetworkTask(url, null);
        networkTask.execute();

        Button button = findViewById(R.id.order);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), billSubActivity.class);//주문확인화면전환
                startActivity(intent);
                finish();
            }
        });
        Button button2 = findViewById(R.id.cancle);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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

                String price = "";
                String text="";
                String realtitle="";
                String realdonate="";
                JSONObject order = new JSONObject(str);

                JSONArray index = order.getJSONArray("jokj624");
                for (int i = index.length()-1; i > index.length()-2; i--) {
                    JSONObject tt = index.getJSONObject(i);
                    price += "" + tt.getString("Price") + "\n";
                    realtitle += "" + tt.getString("Title") + "\n";
                    realdonate += ""+tt.getString("Donate")+"\n";
                }
                title.setText(realtitle);
                price2.setText(price);
                price3.setText(price);
                donate.setText(realdonate);
            }
            catch (JSONException e){ ;}
        }
    }
}