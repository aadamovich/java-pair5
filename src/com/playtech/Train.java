package com.playtech;

import javax.util.streamex.StreamEx;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

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
    return StreamEx.of(schedule.keySet())
        .takeWhile(station -> station.equals(station1))
        .dropWhile(station -> station.equals(station2))
        .count() <= 2;
  }

  @Override
  public String toString() {
    return "Train{" +
        "id='" + id + '\'' +
        ", schedule=" + schedule
        .entrySet()
        .stream()
        .map(entry -> entry.getKey() + "=" + entry.getValue()).collect(joining()) +
        '}';
  }
}
