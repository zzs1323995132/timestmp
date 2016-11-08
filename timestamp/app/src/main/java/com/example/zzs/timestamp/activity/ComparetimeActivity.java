package com.example.zzs.timestamp.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.zzs.timestamp.R;

/**
 * 距现在时间差
 */

public class ComparetimeActivity extends AppCompatActivity {
    private TextView tv;
    private SharedPreferences preferences;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparetime);
        tv = (TextView) findViewById(R.id.tv_activity_comparetime_txt1);
        preferences = getSharedPreferences("11", Context.MODE_PRIVATE);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = preferences.getString("111", "失败");
                if (!c.equals("失败")) {
                    String date2 = getStandardDate(c);
                    tv.setText(date2);
                }
                Long tsLong = System.currentTimeMillis() / 1000;//获取时间戳
                String s = tsLong.toString();//获取时间戳
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("111", s);
                editor.commit();
            }
        });
    }

    public static String getStandardDate(String timeStr) {

        StringBuffer sb = new StringBuffer();

        long t = Long.parseLong(timeStr);
        long time = System.currentTimeMillis() - (t * 1000);
        long mill = (long) Math.ceil(time / 1000);//秒前

        long minute = (long) Math.ceil(time / 60 / 1000.0f);// 分钟前

        long hour = (long) Math.ceil(time / 60 / 60 / 1000.0f);// 小时

        long day = (long) Math.ceil(time / 24 / 60 / 60 / 1000.0f);// 天前

        if (day - 1 > 0) {
            sb.append(day + "天");

        } else if (hour - 1 > 0) {
            if (hour >= 24) {
                sb.append("1天");

            } else {
                sb.append(hour + "小时");

            }

        } else if (minute - 1 > 0) {
            if (minute == 60) {
                sb.append("1小时");

            } else {
                sb.append(minute + "分钟");

            }

        } else if (mill - 1 > 0) {
            if (mill == 60) {
                sb.append("1分钟");

            } else {
                sb.append(mill + "秒");

            }

        } else {
            sb.append("刚刚");

        }
        if (!sb.toString().equals("刚刚")) {
            sb.append("前");

        }
        return sb.toString();

    }

}

