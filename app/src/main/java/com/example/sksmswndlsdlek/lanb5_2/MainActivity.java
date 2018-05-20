package com.example.sksmswndlsdlek.lanb5_2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number;
    Button cal;
    TextView tvresult;
    TextView listnum;
    String numberString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number=(EditText)findViewById(R.id.number);
        cal=(Button)findViewById(R.id.calculate);
        tvresult=(TextView)findViewById(R.id.result);
        listnum=(TextView)findViewById(R.id.listnum);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Factorial().execute(Long.parseLong(number.getText().toString()));
            }
        });
    }

    class Factorial extends AsyncTask<Long, Long, Long> {

        protected void onPreExecute(){
            super.onPreExecute();
        }

        protected Long doInBackground(Long... params){
            long result=1;
            long num=params[0];


            for(long i=num;i>=1;i--){
                try {
                    Thread.sleep(500);
                    publishProgress(i);

                }catch(Exception e){}
                result=result*i;
                numberString+=Long.toString(i)+"   ";
            }

            Log.d("test","result:"+result);
            return result;
        }

        protected void onProgressUpdate(Long... values){
            super.onProgressUpdate(values);
            listnum.setText(numberString);
        }

        protected void onPostExecute(Long result){
         //  super.onPostExecute(result);


            tvresult.setText("="+result);
        }
    }
}

