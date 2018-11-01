package com.playtech;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException {
        List<Train> trains = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        lines = Files.lines(Paths.get("schedule.txt"))
                .collect(Collectors.toList());

        for (String str : lines) {
            String[] chunks = str.split(" ");
            Map<String, LocalTime> schedule = new TreeMap<>();
            Map<String, Integer> stopNrs = new TreeMap<>();
            for (int i = 1; i < chunks.length; i++) {
                String[] entry = chunks[i].split("=");
                schedule.put(entry[0], LocalTime.parse(entry[1]));
                stopNrs.put(entry[0], i);
            }
            trains.add(new Train(chunks[0], schedule, stopNrs));
        }
        trains.forEach(System.out::println);
        isDirectConnection(trains, "CLU", "ADC");
        isShortTrip(trains, "CLU", "DED");
    }

    public static void isDirectConnection(List<Train> trains, String station1, String station2) {
        trains
                .stream()
                .filter(s -> s.getSchedule().containsKey(station1) && s.getSchedule().containsKey(station2))
                .filter(s -> s.getSchedule().get(station1).isBefore(s.getSchedule().get(station2)))
                .forEach(s -> System.out.println(s.getId()));
    }

    public static void isShortTrip(List<Train> trains, String station1, String station2) {
        trains
                .stream()
                .filter(s -> s.getSchedule().containsKey(station1) && s.getSchedule().containsKey(station2))
                .filter(s -> s.getSchedule().get(station1).isBefore(s.getSchedule().get(station2)))
                .filter(s -> (s.getStopNrs().get(station2) - s.getStopNrs().get(station1)) <= 2)
                .forEach(s -> System.out.println(s.getId()));

    }
}