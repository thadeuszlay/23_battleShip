package main.model;

/**
 * Created by think on 17.05.17.
 */
public enum StuffOnWater {
    ERROR(-1), WATER(0), DESTROYER(2), CRUISER(3), AIRCRAFT_CARRIER(4);
    private int shipLength;
    StuffOnWater(int shipLength) {
        this.shipLength = shipLength;
    }
    public int getShipLength() {
        return shipLength;
    }
}