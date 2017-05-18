package main.model;

/**
 * Created by think on 17.05.17.
 */
public class Ocean {
    int length;
    StuffOnWater[] ocean;
    public Ocean(int length) {
        ocean = new StuffOnWater[length];
        for (int i = 0; i < ocean.length; i++) {
            ocean[i] = StuffOnWater.WATER;
        }
    }
    public StuffOnWater shootAt(int x) {
        return ocean[x];
    }

    public Result setShipWhereThereIsPlace(StuffOnWater ship) {
        int position = findFreePosition(ship);
        if (position != -1){
            setOnOceanAt(position, ship);
            return Result.SUCCESS;
        }
        return Result.FAILED;
    }

    public void setOnOceanAt(int x, StuffOnWater ship) {
        for (int i = 0; i < ship.getShipLength(); i++) {
            ocean[x + i] = ship;
        }
    }

    public int findFreePosition(StuffOnWater shipType) {
        int start = 0, i = 0, k = 0;

        while (i < ocean.length) {
            if (k == 0) start = i;
            if (ocean[i] == StuffOnWater.WATER) k++;
            if (k == shipType.getShipLength()) return start;
            if (ocean[i] != StuffOnWater.WATER && k < shipType.getShipLength()) {
                k = 0;
                start = -1;
            }
            if (i == ocean.length -1 && k < shipType.getShipLength()) start = -1;
            i++;
        }
        return start;
    }

    public void putDestroyer(int x) {
        putShipAt(x, StuffOnWater.DESTROYER);
    }
    public void putCruiser(int x) {
        putShipAt(x, StuffOnWater.CRUISER);
    }
    public void putAircraftCarrier(int x) {
        putShipAt(x, StuffOnWater.AIRCRAFT_CARRIER);
    }

    private void putShipAt(int x, StuffOnWater shipType) {
        for (int i = 0; i < shipType.getShipLength(); i++) {
            ocean[x + i] = shipType;
        }
    }
}
