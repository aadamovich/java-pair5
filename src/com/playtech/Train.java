package com.playtech;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private String id;
    private List<ScheduleEntry> schedule;

    public Train(String id, List<ScheduleEntry> schedule) {
        this.id = id;
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id='" + id + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}
