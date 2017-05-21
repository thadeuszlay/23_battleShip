package main.model;

import main.controller.FindFreePosition;
import main.controller.RandomCoordinate;
import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by think on 17.05.17.
 */
public class OceanImpl implements Ocean{
    StuffOnWater[][] ocean;
    Map<Point, StuffOnWater> shotsMade = new HashMap<>();
    Set<Point> shipsPlaced = new HashSet<>();
    RandomCoordinate randomCoordinate;
    FindFreePosition findFreePosition;

    public OceanImpl(int xLength, int yLength) throws Exception {
        if (xLength < 5) throw new Exception("X length must be larger than or equal to 6");
        if (yLength < 5) throw new Exception("Y length must be larger than or equal to 6");

        ocean = new StuffOnWater[yLength][xLength];
        for (int y = 0; y < ocean.length; y++) {
            for (int x = 0; x < ocean[0].length; x++) {
                ocean[y][x] = StuffOnWater.WATER;
            }
        }
        randomCoordinate = new RandomCoordinate(ocean[0].length, ocean.length);
        findFreePosition = new FindFreePosition(this);
    }

    @Override
    public int getXLength() {return ocean[0].length;}
    @Override
    public int getYLength() {return ocean.length;}
    @Override
    public StuffOnWater getLocationStatusAt(int x, int y) {return ocean[y][x];}

    @Override
    public StuffOnWater shootAt(int x, int y) throws Exception {
        if (x > getXLength()) throw new Exception("X is out of scope");
        if (x > getYLength()) throw new Exception("Y is out of scope");
        shotsMade.put(new Point(x,y), getLocationStatusAt(x,y));
        shipsPlaced.remove(new Point(x,y));
        return getLocationStatusAt(x,y);
    }
    @Override
    public int howManyTargetsHit() {return shipsPlaced.size();}
    @Override
    public StuffOnWater getShotMade(int x, int y) {return shotsMade.get(new Point(x,y));}
    @Override
    public Result setShipWhereThereIsPlace(StuffOnWater ship) throws Exception {
        int[] position = findFreePosition.getPosition(ship);
        Orientation orientation = position[2] == 0 ? Orientation.HORIZONTAL : Orientation.VERTICAL;
        if (position[0] != -1){
            setOnOceanAt(position[0], position[1], orientation, ship);
            return Result.SUCCESS;
        }
        System.out.println("Failed! " + position[0] + " " + position[1] + " " + position[2] + " " + ship);
        return Result.FAILED;
    }

    private void setOnOceanAt(int x, int y, Orientation orientation, StuffOnWater ship) {
        if (orientation == Orientation.HORIZONTAL){
            setOnOceanHorizontally(x,y,ship);
        } else {
            setOnOceanVertically(x,y,ship);
        }
    }

    private void setOnOceanHorizontally(int x, int y, StuffOnWater ship) {
        for (int i = 0; i < ship.getShipLength(); i++) {
            int xCoordinate = x + i, yCoordinate = y;
            try {
                ocean[yCoordinate][xCoordinate] = ship;
            } catch(Exception e) {
                e.getCause();
            }
            shipsPlaced.add(new Point(xCoordinate,yCoordinate));
        }
    }

    private void setOnOceanVertically(int x, int y, StuffOnWater ship) {
        for (int i = 0; i < ship.getShipLength(); i++) {
            int xCoordinate = x, yCoordinate = y + i;

            try {
                ocean[yCoordinate][xCoordinate] = ship;
            } catch(Exception e) {
                e.getCause();
            }
            shipsPlaced.add(new Point(xCoordinate, yCoordinate));
        }
    }
}