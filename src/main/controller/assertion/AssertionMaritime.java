package main.controller.assertion;

import main.model.MaritimeElement;

/**
 * Created by think on 22.05.17.
 */
public interface AssertionMaritime {
    boolean isSpaceAvailable(MaritimeElement maritimeElement, int oceanDimensionLength, int shipLength, int dimension, int k);
    boolean isWater(MaritimeElement maritimeElement);
    void isPointWithinRange(int x, int y, int xMax, int yMax) throws Exception;
    void isLargerThanMinimumDimension(int xLength, int yLength) throws Exception;
}
