package main.controller;

import main.controller.assertion.AssertionMaritime;
import main.model.MaritimeElement;
import main.model.Ocean;
import main.model.Orientation;

import java.awt.*;

/**
 * Created by think on 21.05.17.
 */
public class FindFreePosition {
    Ocean ocean;
    RandomCoordinateFactory randomPoint;
    AssertionMaritime assertShip;
    public FindFreePosition(Ocean ocean, AssertionMaritime assertShip) {
        this.ocean = ocean;
        this.assertShip = assertShip;
        randomPoint = new RandomCoordinateFactory(ocean.getXLength(), ocean.getYLength());
    }

    public int[] getPosition(int shipLength) throws Exception {
        int[][] startingPoints = findFreePositionsHorizontallyAndVertically(shipLength);
        int selectRandomly = (int)(Math.random() * startingPoints.length);
        if (startingPoints[selectRandomly][0] != -1) return startingPoints[selectRandomly];

        throw new Exception("No space for ships found");
    }
    private int[][] findFreePositionsHorizontallyAndVertically(int shipLength) throws Exception {
        Point startPointHorizontalShip = randomPoint.getStartPointForHorizontalShip(shipLength);
        Point startPointVerticalShip = randomPoint.getStartPointForVerticalShip(shipLength);
        int[] coordHorizontal = findFreePositionHorizontally(shipLength, startPointHorizontalShip.x, startPointHorizontalShip.y);
        int[] coordVertical = findFreePositionVertically(shipLength, startPointVerticalShip.x, startPointVerticalShip.y);

        return new int[][]{coordHorizontal, coordVertical};
    }

    private int[] findFreePositionVertically(int shipLength, int xOffset, int yOffset) throws Exception {
        int x = xOffset,y = yOffset, k = 0, xIteration = 0;
        int[] start = {-1,-1,Orientation.VERTICAL.getValue()};

        while (x < ocean.getXLength() && xIteration < 2) {
            while (y < ocean.getYLength()) {
                MaritimeElement currentMaritimeElement = ocean.getLocationStatusAt(x,y);
                if (k == 0) start = new int[]{x, y, Orientation.VERTICAL.getValue()};
                if (assertShip.isWater(currentMaritimeElement)) k++;
                if (k == shipLength) return start;
                if (assertShip.isSpaceAvailable(currentMaritimeElement, ocean.getYLength(), shipLength, y, k)) {
                    k = 0;
                    start = new int[]{-1, -1, Orientation.VERTICAL.getValue()};
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
        int[] start = {-1,-1, Orientation.HORIZONTAL.getValue()};

        while (y < ocean.getYLength() && yIteration < 2) {
            while (x < ocean.getXLength()) {
                MaritimeElement currentMaritimeElement = ocean.getLocationStatusAt(x,y);
                if (k == 0) start = new int[]{x, y, Orientation.HORIZONTAL.getValue()};
                if (assertShip.isWater(currentMaritimeElement)) k++;
                if (k == shipLength) return start;
                if (assertShip.isSpaceAvailable(currentMaritimeElement, ocean.getXLength(), shipLength, x, k)) {
                    k = 0;
                    start = new int[]{-1, -1, Orientation.HORIZONTAL.getValue()};
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