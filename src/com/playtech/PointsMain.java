package com.playtech;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PointsMain {
    final static Point CENTER = new Point(0, 0);

    public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(1, 1), new Point(1, 2), new Point(1, 3), new Point(1, 4), new Point(1, 5), new Point(2, 1), new Point(2, 2), new Point(2, 3), new Point(2, 4), new Point(2, 5),
                new Point(0, 0), new Point(3, 3), new Point(5, 11));

        inGivenRectangle(points, new Point(1, 1), new Point(2, 3));
        System.out.println("-------------------------");
        inGivenCircle(points, new Point(1, 1), 1.5);
        System.out.println("-------------------------");
        sortByDistance(points, new Point(0, 0)).forEach(System.out::println);
        System.out.println("-------------------------");
        printK(points, new Point(0, 0), 3);
    }

    public static void inGivenRectangle(List<Point> points, Point point1, Point point2) {
        double maxX = point1.getX() > point2.getX() ? point1.getX() : point2.getX();
        double minX = point1.getX() < point2.getX() ? point1.getX() : point2.getX();
        double maxY = point1.getY() > point2.getY() ? point1.getY() : point2.getY();
        double minY = point1.getY() < point2.getY() ? point1.getY() : point2.getY();
        //System.out.println("maxX:"+maxX+"\nminX:"+minX+"\nmaxY:"+maxY+"\nminY:"+minY);
        points
                .stream()
                .filter(s -> s.getX() >= minX && s.getX() <= maxX)
                .filter(s -> s.getY() >= minY && s.getY() <= maxY)
                .forEach(System.out::println);
    }

    public static void inGivenCircle(List<Point> points, Point point1, double radius) {
        points
                .stream()
                .filter(s -> s.distance(point1) <= radius)
                .forEach(System.out::println);
    }

    public static List<Point> sortByDistance(List<Point> points, Point point) {
        Comparator<Point> c = (Point a, Point b) ->
                (int) Math.signum(a.distance(CENTER) - b.distance(CENTER));
        points.sort(c);
        return points;

    }

    public static void printK(List<Point> points, Point point, long k) {
        points = sortByDistance(points, point);
        points
                .stream()
                .limit(k)
                .forEach(System.out::println);
    }
}
