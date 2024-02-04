package com.example.metric_time_app_android;

import android.util.Log;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.metric_time_app_android.CalendarActivity.dayOfWeekShort;

public class CalendarUtils {

    public static FrenchRepublicanDate selectedDate;

    public static String formattedDate(FrenchRepublicanDate date)
    {
        return date.getFormattedDate();
    }

    public static String formattedTime(MetricTime time)
    {
        return time.getFormattedTime();
    }

    public static String monthYearFromDate(FrenchRepublicanDate date)
    {
        return FrenchRepublicanDate.getMonthName(date.getMonth()) + " " + date.getYear();
    }

    public static ArrayList<FrenchRepublicanDate> daysInMonthArray(FrenchRepublicanDate date)
    {
        ArrayList<FrenchRepublicanDate> daysInMonthArray = new ArrayList<>();
        int daysInMonth = CalendarUtils.selectedDate.getDaysInMonth();
        Log.d("Tag", String.valueOf(CalendarUtils.selectedDate.getDaysInMonth()));
        for(int i = 1; i <= 30; i++) {
                if (i > daysInMonth) {
                    daysInMonthArray.add(null);
                } else {
                    daysInMonthArray.add(FrenchRepublicanDate.of(selectedDate.getYear(), selectedDate.getMonth(), i));
                }

        }
        return  daysInMonthArray;
    }

    public static ArrayList<FrenchRepublicanDate> daysInWeekArray(FrenchRepublicanDate selectedDate)
    {
        ArrayList<FrenchRepublicanDate> days = new ArrayList<>();
        FrenchRepublicanDate current = sundayForDate(selectedDate);
        if (current != null) {
            FrenchRepublicanDate endDate = current.plusDays(10);
            Log.d("TAG", endDate.getFormattedDate());
            Log.d("TAG", current.getFormattedDate());
            //Log.d("TAG", String.valueOf(endDate.getDayInYear()));

            while (current.isBefore(endDate))
            {
                days.add(current);
                //Log.d("TAG", current.getFormattedDate());
                current = current.plusDays(1);
            }
        }

        return days;
    }

    private static FrenchRepublicanDate sundayForDate(FrenchRepublicanDate current)
    {
        FrenchRepublicanDate oneWeekAgo = current.minusDays(10);

        while (current.isAfter(oneWeekAgo))
        {
            if(current.getDay() % 10 == 1) {
                return current;
            } else{
                current = current.minusDays(1);
        }

        }

        return null;
    }

}
