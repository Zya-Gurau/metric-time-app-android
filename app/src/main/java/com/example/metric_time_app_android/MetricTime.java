package com.example.metric_time_app_android;

import java.time.LocalTime;

public class MetricTime {

    double hours;
    double minutes;
    double seconds;

    public MetricTime() {
        LocalTime time = LocalTime.now();
        hours = (((time.getHour()*60*60)/0.864)/10000);
        minutes = (((time.getMinute()*60)/0.864)/10000);
        seconds = (time.getSecond()/0.864/10000);
    }

    public MetricTime(int hour, int minute, int second) {
        hours = (((hour*60*60)/0.864)/10000);
        minutes = (((minute*60)/0.864)/10000);
        seconds = (second/0.864/10000);
    }

    public double getHours() {
        return hours;
    }

    public double getMinutes() {
        return minutes;
    }

    public double getSeconds() {
        return seconds;
    }

    public MetricTime toMetricTime(LocalTime time) {
        return new MetricTime(time.getHour(), time.getMinute(), time.getSecond());
    }

    public String getFormattedTime() {
        return String.valueOf(getHours()+getMinutes()+getSeconds());
    }







}
