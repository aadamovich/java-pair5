package com.playtech;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException {
        List<Train> trains = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        lines = Files.lines(Paths.get("schedule.txt"))
                .collect(Collectors.toList());

        for (String str: lines) {
            String[] chunks = str.split(" ");
            List<ScheduleEntry> schedule = new ArrayList<>();
            for (int i = 1; i < chunks.length; i++) {
                String[] entry = chunks[i].split("=");
                schedule.add(new ScheduleEntry(entry[0], LocalTime.parse(entry[1])));
            }
            trains.add(new Train(chunks[0], schedule));
        }
        trains.forEach(System.out::println);

    }
}