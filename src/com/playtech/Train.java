package com.playtech;

import javax.util.streamex.StreamEx;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class Train {

    private String id;
    private Map<String, LocalTime> schedule = new LinkedHashMap<>();

    public Train(String id) {
        this.id = id;
    }

    public Train addStation(String stationName, LocalTime time) {
        schedule.put(stationName, time);
        return this;
    }

    public String getId() {
        return id;
    }

    public Map<String, LocalTime> getSchedule() {
        return schedule;
    }

    public boolean isShortTrip(String station1, String station2) {
        long count = StreamEx.of(schedule.keySet())
                .dropWhile(station -> !station.equals(station1))
                .takeWhile(station -> !station.equals(station2))
                .count();
        return schedule.containsKey(station1) && schedule.containsKey(station2) &&
                (count == 1 || count == 2);
    }

    @Override
    public String toString() {
        return "Train{" +
                "id='" + id + '\'' +
                ", schedule=" + schedule + '}';
    }

    public boolean hasNextStations(String station1) {
        return StreamEx.of(schedule.keySet())
                .dropWhile(station -> !station.equals(station1))
                .count() >= 1;
    }
}
