package com.example.metric_time_app_android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerLayout);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.home);
        calendar = findViewById(R.id.calendar);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(MainActivity.this, CalendarActivity.class);
            }
        });

        CalendarUtils.selectedDate = new FrenchRepublicanDate(LocalDateTime.of(2026, Month.SEPTEMBER, 22, 0, 0));

        Log.d("Tag",String.valueOf(CalendarUtils.selectedDate.leapYears));
        Log.d("Tag",String.valueOf(CalendarUtils.selectedDate.isLeapYear));
        Log.d("Tag",String.valueOf(CalendarUtils.selectedDate.yesterdayLeapYears));
        Log.d("Tag",String.valueOf(CalendarUtils.selectedDate.unadjustedYears));

        TextView timeView = findViewById(R.id.currentTimeTextView);
        TextView dateView = findViewById(R.id.currentDateTextView);
        dateView.setText(String.valueOf(CalendarUtils.selectedDate.getFormattedDate()));
        displayTime(timeView);

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
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void redirectActivity(Activity activity, Class secondActivity) {
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
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