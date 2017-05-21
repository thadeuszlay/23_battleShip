package main.model;

/**
 * Created by think on 21.05.17.
 */
public interface Ocean {
    int getXLength();
    int getYLength();
    StuffOnWater getLocationStatusAt(int x, int y);
    StuffOnWater shootAt(int x, int y) throws Exception;
    int howManyTargetsHit();
    StuffOnWater getShotMade(int x, int y);
    Result setShipWhereThereIsPlace(StuffOnWater ship) throws Exception;
}
