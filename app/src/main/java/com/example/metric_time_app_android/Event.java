package com.example.metric_time_app_android;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Event
{
    public static ArrayList<Event> eventsList = new ArrayList<>();

    public static ArrayList<Event> eventsForDate(FrenchRepublicanDate date)
    {
        ArrayList<Event> events = new ArrayList<>();

        for(Event event : eventsList)
        {
            if(event.getDate().equals(date))
                events.add(event);
        }

        return events;
    }


    private String name;
    private FrenchRepublicanDate date;
    private MetricTime time;

    public Event(String name, FrenchRepublicanDate date, MetricTime time)
    {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public FrenchRepublicanDate getDate()
    {
        return date;
    }

    public void setDate(FrenchRepublicanDate date)
    {
        this.date = date;
    }

    public MetricTime getTime()
    {
        return time;
    }

    public void setTime(MetricTime time)
    {
        this.time = time;
    }
}