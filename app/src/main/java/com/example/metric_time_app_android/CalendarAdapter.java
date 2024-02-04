package com.example.metric_time_app_android;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

import static com.example.metric_time_app_android.CalendarActivity.dayOfWeekShort;

class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder>
{
    private final ArrayList<FrenchRepublicanDate> days;
    private final OnItemListener onItemListener;

    public CalendarAdapter(ArrayList<FrenchRepublicanDate> days, OnItemListener onItemListener)
    {
        this.days = days;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calendar_cell, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if(days.size() > 15) //month view
            layoutParams.height = (int) (parent.getHeight() * 0.166666666);
        else // week view
            layoutParams.height = (int) parent.getHeight();

        return new CalendarViewHolder(view, onItemListener, days);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position)
    {
        final FrenchRepublicanDate date = days.get(position);
        if(date == null){
            holder.dayOfMonth.setText("");
            holder.dayOfWeek.setText("");
        } else {
            holder.dayOfMonth.setText(String.valueOf(date.getDay()));
            holder.dayOfWeek.setText(dayOfWeekShort[(date.getDay()-1) % 10]);
            Log.d("tag", String.valueOf(date.equals(CalendarUtils.selectedDate)));
            if(date.approxEquals(CalendarUtils.selectedDate)) {

                holder.parentView.setBackgroundColor(Color.LTGRAY);
                Log.d("tag", "COLOR CHANGED");
            }


        }
    }

    @Override
    public int getItemCount()
    {
        return days.size();
    }

    public interface  OnItemListener
    {
        void onItemClick(int position, FrenchRepublicanDate date);
    }
}