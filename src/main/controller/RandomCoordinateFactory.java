package main.controller;

import java.awt.*;

/**
 * Created by think on 21.05.17.
 */
public class RandomCoordinateFactory {
    private int xLength;
    private int yLength;

    public RandomCoordinateFactory(int xLength, int yLength) {
        this.xLength = xLength;
        this.yLength = yLength;
    }
    private int getRandomHorizontalXPosition(int shipLength) { return (int)Math.floor(Math.random() * (xLength - shipLength));}
    private int getRandomHorizontalYPosition() {
        return (int)Math.floor(Math.random() * yLength);
    }
    private int getRandomVerticalXPosition() {
        return (int)Math.floor(Math.random() * xLength);
    }
    private int getRandomVerticalYPosition(int shipLength) {return (int)Math.floor(Math.random() * (yLength - shipLength));}
    public Point getStartPointForHorizontalShip(int shipLength) {
        return new Point(getRandomHorizontalXPosition(shipLength), getRandomHorizontalYPosition());
    }
    public Point getStartPointForVerticalShip(int shipLength) {
        return new Point(getRandomVerticalXPosition(), getRandomVerticalYPosition(shipLength));
    }
}