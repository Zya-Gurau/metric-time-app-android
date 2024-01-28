package com.example.metric_time_app_android;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CalendarActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener{
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private FrenchRepublicanDate selectedDate;
    String[] dayOfWeekShort = {"PRIM", "DUO", "TRI", "QUAR", "QUIN",
            "SEX", "SEP", "OCT", "NON", "DÉV"};
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, calendar;
    int selectedMonth;
    int selectedYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        drawerLayout = findViewById(R.id.drawerLayout);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.home);
        calendar = findViewById(R.id.calendar);
        initWidgets();
        selectedDate = new FrenchRepublicanDate(LocalDateTime.now());
        selectedMonth = selectedDate.getMonth();
        selectedYear = selectedDate.getYear();
        setMonthView();

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(CalendarActivity.this, MainActivity.class);
            }
        });

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });


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

    private void initWidgets() {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearText);
    }

    private void setMonthView() {
        monthYearText.setText(monthYearFromDate(selectedDate));
        ArrayList<String[]> daysInMonth = daysInMonthArray();

        CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 5);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }

    private ArrayList<String[]> daysInMonthArray() {
        ArrayList<String[]> daysInMonthArray = new ArrayList<>();

        for(int i = 1; i <= 30; i++)
        {

            if(i % 10 == 0) {
                String[] elem = {dayOfWeekShort[9], String.valueOf(i)};
                daysInMonthArray.add(elem);
            }
            else {
                String[] elem = {dayOfWeekShort[(i % 10) - 1], String.valueOf(i)};
                daysInMonthArray.add(elem);
            }

        }
        return  daysInMonthArray;
    }

    private String monthYearFromDate(FrenchRepublicanDate date) {
        return FrenchRepublicanDate.getMonthName(selectedMonth) + " " + selectedYear;
    }

    public void previousMonthAction(View view) {
        if(selectedMonth > 0) {
            selectedMonth--;
        } else {
            selectedMonth = 12;
            selectedYear--;
        }
        setMonthView();
    }

    public void nextMonthAction(View view) {
        if(selectedMonth <12) {
            selectedMonth++;
        } else {
            selectedMonth = 0;
            selectedYear++;
        }
        setMonthView();
    }

    @Override
    public void onItemClick(int position, String dayText, String weekText) {
        if(!dayText.equals(""))
        {
            String message = "Selected Date " +weekText + " " + dayText + " " + monthYearFromDate(selectedDate);
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}