package main.controller;

import main.model.MaritimeElement;
import main.model.Ocean;

/**
 * Created by think on 23.05.17.
 */
public class SetOnOceanVertically implements SetOnOcean {
    Ocean ocean;
    public SetOnOceanVertically(Ocean ocean) {
        this.ocean = ocean;
    }
    @Override
    public void setShip(int x, int y, MaritimeElement ship) {
        for (int i = 0; i < ship.val(); i++) {
            int xCoordinate = x, yCoordinate = y + i;
            try {
                ocean.setMaritime(xCoordinate,yCoordinate, ship);
            } catch(Exception e) {
                e.getCause();
            }
            ocean.setShipsPlaced(xCoordinate,yCoordinate);
        }

    }
}
