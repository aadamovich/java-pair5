package com.playtech;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Train {
    private String id;
    //private List<ScheduleEntry> schedule;
    private Map<String, LocalTime> schedule;

    public Train(String id, Map<String, LocalTime> schedule) {
        this.id = id;
        this.schedule = schedule;
    }

    public String getId() {
        return id;
    }

    public Map<String, LocalTime> getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id='" + id + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}
