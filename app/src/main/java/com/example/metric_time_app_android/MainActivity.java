package com.example.metric_time_app_android;

import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.time.LocalTime;
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewOne = findViewById(R.id.textView1);

        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(864);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                LocalTime time = LocalTime.now();

                                double metric_hours = (((time.getHour()*60*60)/0.864)/10000);
                                double metric_minutes = (((time.getMinute()*60)/0.864)/10000);
                                double metric_seconds = (time.getSecond()/0.864/10000);

                                String debug_string = String.valueOf(metric_seconds);

                                String metric_time = String.valueOf( metric_hours+ metric_minutes + metric_seconds);

                                textViewOne.setText(metric_time);
                                Log.d("tag",metric_time);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    Log.d("tag","stopped");
                }
            }
        };

        t.start();


    }

}