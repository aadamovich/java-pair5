package com.playtech;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Train {
    private String id;
    //private List<ScheduleEntry> schedule;
    private Map<String, LocalTime> schedule;
    private Map<String, Integer> stopNrs;

    public Train(String id, Map<String, LocalTime> schedule, Map<String, Integer> stopNrs) {
        this.id = id;
        this.schedule = schedule;
        this.stopNrs = stopNrs;

    }

    public Map<String, Integer> getStopNrs() {
        return stopNrs;
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
