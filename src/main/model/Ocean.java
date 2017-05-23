package main.model;

import java.awt.*;

/**
 * Created by think on 21.05.17.
 */
public interface Ocean {
    int getXLength();
    int getYLength();
    MaritimeElement getLocationStatusAt(int x, int y);
    MaritimeElement shootAt(int[] userInput) throws Exception;
    int howManyTargetsHit();
    MaritimeElement getShotMade(int x, int y);
    Result setShipWhereThereIsPlace(MaritimeElement ship) throws Exception;
    void setMaritime(int x, int y, MaritimeElement ship);
    void setShipsPlaced(int x, int y);
}
