package main.controller;

import main.model.Ocean;
import main.model.OceanImpl;
import main.model.StuffOnWater;

import java.awt.*;

/**
 * Created by think on 21.05.17.
 */
public class FindFreePosition {
    Ocean ocean;
    RandomCoordinate randomCoordinate;

    public FindFreePosition(Ocean ocean) {
        this.ocean = ocean;
        randomCoordinate = new RandomCoordinate(ocean.getXLength(), ocean.getYLength());
    }

    public int[] getPosition(StuffOnWater shipType) throws Exception {
        Point randomPointHorizontal = randomCoordinate.getRandomHorizontalCoordinate(shipType.getShipLength());
        Point randomPointVertical = randomCoordinate.getRandomVerticalCoordinate(shipType.getShipLength());

        if((int)(Math.random() * 2) == 1) {
            int[] coord = findFreePositionHorizontally(shipType.getShipLength(), randomPointHorizontal.x, randomPointHorizontal.y);
            if (coord[0] != -1) return coord;
            coord = findFreePositionVertically(shipType.getShipLength(), randomPointVertical.x, randomPointVertical.y);
            if (coord[0] != -1) return coord;
            throw new Exception("1 No space for ships found");
        } else {
            int[] coord = findFreePositionVertically(shipType.getShipLength(), randomPointVertical.x, randomPointVertical.y);
            if (coord[0] != -1) return coord;
            coord = findFreePositionHorizontally(shipType.getShipLength(), randomPointHorizontal.x, randomPointHorizontal.y);
            if (coord[0] != -1) return coord;
            throw new Exception("2 No space for ships found");
        }
    }

    private int[] findFreePositionVertically(int shipLength, int xOffset, int yOffset) throws Exception {
        int x = xOffset,y = yOffset, k = 0, xIteration = 0;
        int[] start = {0,0,1};

        while (x < ocean.getXLength() && xIteration < 2) {
            while (y < ocean.getYLength()) {
                if (k == 0) start = new int[]{x, y, 1};
                if (ocean.getLocationStatusAt(x,y) == StuffOnWater.WATER) k++;
                if (k == shipLength) return start;
                if ((ocean.getLocationStatusAt(x,y) != StuffOnWater.WATER && k < shipLength) ||
                    (y == ocean.getYLength() - 1 && k < shipLength)) {
                    k = 0;
                    start = new int[]{-1, -1, 1};
                }
                y++;
            }
            y = 0;
            k = 0;
            x++;
            if (x >= ocean.getXLength()) xIteration++;
            x = x % ocean.getXLength();
        }
        return start;
    }

    private int[] findFreePositionHorizontally(int shipLength, int xOffset, int yOffset) throws Exception {
        int x = xOffset, y = yOffset, k = 0, yIteration = 0;;
        int[] start = {0,0, 0};

        while (y < ocean.getYLength() && yIteration < 2) {
            while (x < ocean.getXLength()) {
                if (k == 0) start = new int[]{x, y, 0};
                if (ocean.getLocationStatusAt(x,y) == StuffOnWater.WATER) k++;
                if (k == shipLength) return start;
                if ((ocean.getLocationStatusAt(x,y) != StuffOnWater.WATER && k < shipLength) ||
                    (x == ocean.getXLength() - 1 && k < shipLength)) {
                    k = 0;
                    start = new int[]{-1, -1, 0};
                }
                x++;
            }
            x = 0;
            k = 0;
            y++;
            if (y >= ocean.getYLength()) yIteration++;
            y = y % ocean.getYLength();
        }
        return start;
    }
}