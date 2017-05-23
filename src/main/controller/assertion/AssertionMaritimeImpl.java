package main.controller.assertion;

import main.model.MaritimeElement;

/**
 * Created by think on 22.05.17.
 */
public class AssertionMaritimeImpl implements AssertionMaritime {
    @Override
    public boolean isSpaceAvailable(MaritimeElement maritimeElement, int oceanDimensionLength, int shipLength, int dimension, int k) {
        return (maritimeElement != MaritimeElement.WATER && k < shipLength) ||
                (dimension == oceanDimensionLength - 1 && k < shipLength);
    }
    @Override
    public boolean isWater(MaritimeElement maritimeElement) {
        return maritimeElement == MaritimeElement.WATER;
    }

    @Override
    public void isPointWithinRange(int x, int y, int xMax, int yMax) throws Exception {
        if (x > xMax) throw new Exception("X is out of scope");
        if (y > yMax) throw new Exception("Y is out of scope");
    }

    @Override
    public void isLargerThanMinimumDimension(int xLength, int yLength) throws Exception {
        if (xLength < 5) throw new Exception("X length must be larger than or equal to 6");
        if (yLength < 5) throw new Exception("Y length must be larger than or equal to 6");

    }
}
