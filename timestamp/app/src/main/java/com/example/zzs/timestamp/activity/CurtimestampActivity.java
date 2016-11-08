package com.example.zzs.timestamp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.zzs.timestamp.R;

import java.util.Date;

public class CurtimestampActivity extends AppCompatActivity {
    private TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curtimestamp);
        tv1 = (TextView) findViewById(R.id.tv_activity_curtimestamp_txt1);
        tv2 = (TextView) findViewById(R.id.tv_activity_curtimestamp_txt2);
        tv3 = (TextView) findViewById(R.id.tv_activity_curtimestamp_txt3);
        // 获取当前时间戳
        getCurTimeStamp();
    }

    // 获取当前时间戳
    private void getCurTimeStamp() {
        long timestamp = Date.parse(String.valueOf(new Date()));
        //1、当前时间戳为：1478326262000(以ms为单位)
        Log.i("1111111111111", "当前时间戳为：" + timestamp);
        tv1.setText("当前时间戳为：" + timestamp);
        timestamp = timestamp / 1000;
        //2、当前时间戳为：1478326262(以s为单位)
        Log.i("1111111111111", "当前时间戳为：" + timestamp);
        tv2.setText("当前时间戳为：" + timestamp);
        int time = (int) (System.currentTimeMillis());
        //3、当前时间戳为：1478326262(以s为单位
        Long tsLong = System.currentTimeMillis() / 1000;//获取时间戳
        String s = tsLong.toString();//获取时间戳
        Log.i("1111111111111", "当前时间戳为：" + s);
        tv3.setText("当前时间戳为：" + s);
    }
}
