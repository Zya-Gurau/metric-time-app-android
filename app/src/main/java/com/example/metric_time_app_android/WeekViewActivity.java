package com.example.metric_time_app_android;

import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

import static com.example.metric_time_app_android.CalendarActivity.redirectActivity;
import static com.example.metric_time_app_android.CalendarUtils.daysInWeekArray;
import static com.example.metric_time_app_android.CalendarUtils.monthYearFromDate;
import static com.example.metric_time_app_android.MainActivity.openDrawer;

public class WeekViewActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener
{
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private ListView eventListView;

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);
        initWidgets();
        setWeekView();
    }

    private void initWidgets()
    {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearText);
        eventListView = findViewById(R.id.eventListView);
    }

    private void setWeekView()
    {
        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<FrenchRepublicanDate> days = daysInWeekArray(CalendarUtils.selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 10);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
        setEventAdpater();

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
                redirectActivity(WeekViewActivity.this, MainActivity.class);
            }
        });

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(WeekViewActivity.this, CalendarActivity.class);
            }
        });



    }


    public void previousWeekAction(View view)
    {
        if(CalendarUtils.selectedDate.getMonth() != 12) {
            if (CalendarUtils.selectedDate.getMonth() == 0 & CalendarUtils.selectedDate.getDay() <= 10) {
                CalendarUtils.selectedDate = FrenchRepublicanDate.of(CalendarUtils.selectedDate.getYear()-1, 12, 5);

            } else {
                CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusDays(10);
            }

        } else {
            CalendarUtils.selectedDate = FrenchRepublicanDate.of(CalendarUtils.selectedDate.getYear(), 11, 25);
        }

        setWeekView();
    }

    public void nextWeekAction(View view)
    {
        if(CalendarUtils.selectedDate.getMonth() != 12) {
            CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusDays(10);
        } else {
            CalendarUtils.selectedDate = FrenchRepublicanDate.of(CalendarUtils.selectedDate.getYear()+1, 0, 1);
        }

        setWeekView();
    }

    @Override
    public void onItemClick(int position, FrenchRepublicanDate date)
    {
        Log.d("tag", "CLICKED");
        CalendarUtils.selectedDate = date;
        setWeekView();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setEventAdpater();
    }

    private void setEventAdpater()
    {
        ArrayList<Event> dailyEvents = Event.eventsForDate(CalendarUtils.selectedDate);
        EventAdapter eventAdapter = new EventAdapter(getApplicationContext(), dailyEvents);
        eventListView.setAdapter(eventAdapter);
    }

    public void newEventAction(View view)
    {
        startActivity(new Intent(this, EventEditActivity.class));
    }
}