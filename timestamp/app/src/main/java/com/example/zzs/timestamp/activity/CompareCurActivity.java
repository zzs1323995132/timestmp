package com.example.zzs.timestamp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.zzs.timestamp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CompareCurActivity extends AppCompatActivity {
    private TextView time1;
    private TextView time2;
    private TextView time3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_cur);
        time1 = (TextView) findViewById(R.id.tv_activity_comparecur_txt1);
        time2 = (TextView) findViewById(R.id.tv_activity_comparecur_txt2);
        time3 = (TextView) findViewById(R.id.tv_activity_comparecur_txt3);
        // String time="1463126553000";
        // 获取当前时间
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = formatter.format(currentTime);
        time1.setText(date1);
        // 获取服务器返回的时间戳 转换成"yyyy-MM-dd HH:mm:ss"
        String date2 = formatData("yyyy-MM-dd HH:mm:ss", 1463126553);
        time2.setText(date2);


        // 计算的时间差
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        try {
            Date d1 = df.parse(date1);
            Date d2 = df.parse(date2);
            long diff = d1.getTime() - d2.getTime();// 这样得到的差值是微秒级别


            long days = diff / (1000 * 60 * 60 * 24);
            long hours = (diff - days * (1000 * 60 * 60 * 24))
                    / (1000 * 60 * 60);
            long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours
                    * (1000 * 60 * 60))
                    / (1000 * 60);


            time3.setText("" + days + "天" + hours + "小时" + minutes + "分");
        } catch (Exception e) {
        }


    }

    // 获取服务器返回的时间戳 转换成"yyyy-MM-dd HH:mm:ss"
    public static String formatData(String dataFormat, long timeStamp) {
        if (timeStamp == 0) {
            return "";
        }
        timeStamp = timeStamp * 1000;
        String result = "";
        SimpleDateFormat format = new SimpleDateFormat(dataFormat);
        result = format.format(new Date(timeStamp));
        return result;
    }

}

