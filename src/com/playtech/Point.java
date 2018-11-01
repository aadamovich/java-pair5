package com.playtech;

public class Point {
    private double X;
    private double Y;

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public Point(double x, double y) {
        X = x;
        Y = y;
    }
    public double distance(Point b) {
        return Math.sqrt(Math.pow(X - b.X, 2) + Math.pow(Y - b.Y, 2));
    }

    @Override
    public String toString() {
        return "Point{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}
