package com.example.metric_time_app_android;

import android.annotation.SuppressLint;
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
        FrenchRepublicanDate currentDate = new FrenchRepublicanDate();

        TextView timeView = findViewById(R.id.currentTimeTextView);
        TextView dateView = findViewById(R.id.currentDateTextView);
        dateView.setText(String.valueOf(currentDate.getFormattedDate()));

        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(864);
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                displayTime(timeView);
                                Log.d("tag","Updated");
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
    private double calculateTime() {
        LocalTime time = LocalTime.now();

        double metricHours = (((time.getHour()*60*60)/0.864)/10000);
        double metricMinutes = (((time.getMinute()*60)/0.864)/10000);
        double metricSeconds = (time.getSecond()/0.864/10000);

        return metricHours + metricMinutes + metricSeconds;
    }
    private void displayTime(TextView timeView) {

        @SuppressLint("DefaultLocale")
        String metricTime = String.format("%.4f", calculateTime());

        timeView.setText(metricTime);
    }
}