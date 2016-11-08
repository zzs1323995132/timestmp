package com.example.zzs.timestamp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.zzs.timestamp.activity.CompareCurActivity;
import com.example.zzs.timestamp.activity.ComparetimeActivity;
import com.example.zzs.timestamp.activity.CurtimestampActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text3 = (TextView) findViewById(R.id.tv_activity_main_txt);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stringTime1 = "2016-07-10 10:21:12";
        String stringTime2 = "2014-07-10 10:21:12";
        try {
            Date d1 = df.parse(stringTime1);
            Date d2 = df.parse(stringTime2);
            long diff = d1.getTime() - d2.getTime();// 这样得到的差值是微秒级别


            long days = diff / (1000 * 60 * 60 * 24);
            long hours = (diff - days * (1000 * 60 * 60 * 24))
                    / (1000 * 60 * 60);
            long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours
                    * (1000 * 60 * 60))
                    / (1000 * 60);

            Log.i("22222", "" + days + "天" + hours + "小时" + minutes + "分");
            text3.setText("" + days + "天" + hours + "小时" + minutes + "分");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_activity_main_ctimestamp:
                intent.setClass(this, CurtimestampActivity.class);
                break;
            case R.id.btn_activity_main_comeparetime:
                intent.setClass(this, ComparetimeActivity.class);
                break;
            case R.id.btn_activity_main_comeparecur:
                intent.setClass(this, CompareCurActivity.class);
                break;
        }
        startActivity(intent);

    }
}
