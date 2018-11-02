package com.playtech;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;
import static java.util.stream.Collectors.toList;


public class Main {

    public static void main(String[] args) throws IOException {

        List<Train> trains = lines(get("schedule.txt"))
                .map((String line) -> line.split(" "))
                .map((String[] chunks) -> addTrainSchedule(new Train(chunks[0]), chunks))
                .collect(toList());

        trains.forEach(System.out::println);

        isDirectConnection(trains, "CLU", "ADC");
        isShortTrip(trains, "IAS", "DED");

    }

    private static Train addTrainSchedule(Train newTrain, String[] chunks) {
        Arrays
                .stream(chunks)
                .skip(1)
                .map(chunk -> chunk.split("=", 2))
                .forEach((String[] entry) ->
                        newTrain.addStation(entry[0], LocalTime.parse(entry[1])));
        return newTrain;
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
                .filter(train -> train.isShortTrip(station1, station2))
                .forEach(System.out::println);

    }

}