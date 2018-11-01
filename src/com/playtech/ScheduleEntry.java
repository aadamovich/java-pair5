package com.playtech;

import java.time.LocalTime;

public class ScheduleEntry {
    private String station;
    private LocalTime time;

    public ScheduleEntry(String station, LocalTime time) {
        this.station = station;
        this.time = time;
    }

    public String getStation() {
        return station;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "ScheduleEntry{" +
                "station='" + station + '\'' +
                ", time=" + time +
                '}';
    }
}
