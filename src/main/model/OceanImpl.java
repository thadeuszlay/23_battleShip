package main.model;

import main.controller.*;
import main.controller.assertion.AssertionMaritime;
import main.controller.assertion.AssertionMaritimeImpl;
import main.controller.utils.Helper;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by think on 17.05.17.
 */
public class OceanImpl implements Ocean{
    MaritimeElement[][] ocean;
    Map<Point, MaritimeElement> shotsMade = new HashMap<>();
    Set<Point> shipsPlaced = new HashSet<>();
    RandomCoordinateFactory randomCoordinateFactory;
    FindFreePosition findFreePosition;
    AssertionMaritime assertShip = new AssertionMaritimeImpl();
    SetOnOcean setOnOceanHorizontally;
    SetOnOcean setOnOceanVertically;
    SetOnOcean[] setOnOcean;

    public OceanImpl(int xLength, int yLength) throws Exception {
        assertShip.isLargerThanMinimumDimension(xLength, yLength);
        ocean = Helper.initOcean(yLength, xLength);

        randomCoordinateFactory = new RandomCoordinateFactory(ocean[0].length, ocean.length);
        findFreePosition = new FindFreePosition(this, assertShip);
        setOnOceanHorizontally = new SetOnOceanHorizontally(this);
        setOnOceanVertically = new SetOnOceanVertically(this);
        setOnOcean = new SetOnOcean[]{setOnOceanHorizontally, setOnOceanVertically};
    }
    @Override
    public int getXLength() {return ocean[0].length;}
    @Override
    public int getYLength() {return ocean.length;}
    @Override
    public MaritimeElement getLocationStatusAt(int x, int y) {return ocean[y][x];}
    @Override
    public MaritimeElement shootAt(int[] userInput) throws Exception {
        int x = userInput[0], y = userInput[1];
        assertShip.isPointWithinRange(x,y, this.getXLength(), this.getYLength());
        shotsMade.put(new Point(x,y), getLocationStatusAt(x,y));
        shipsPlaced.remove(new Point(x,y));
        return getLocationStatusAt(x,y);
    }
    @Override
    public int howManyTargetsHit() {return shipsPlaced.size();}
    @Override
    public MaritimeElement getShotMade(int x, int y) {return shotsMade.get(new Point(x,y));}
    @Override
    public Result setShipWhereThereIsPlace(MaritimeElement ship) throws Exception {
        int[] position = findFreePosition.getPosition(ship.val());
        if (position[Coordinate.X.val()] != -1){
            setOnOcean[position[Coordinate.ORIENTATION.val()]]
                .setShip(position[Coordinate.X.val()],position[Coordinate.Y.val()],ship);
            return Result.SUCCESS;
        }
        return Result.FAILED;
    }
    @Override
    public void setMaritime(int x, int y, MaritimeElement ship) {
        try {
            ocean[y][x] = ship;
        } catch(Exception e) {
            e.getCause();
        }
    }
    @Override
    public void setShipsPlaced(int x, int y) {
        shipsPlaced.add(new Point(x, y));
    }
}