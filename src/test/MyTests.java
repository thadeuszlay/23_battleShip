package test;

/**
 * Created by think on 17.05.17.
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import main.model.Ocean;
import main.model.Result;
import main.model.StuffOnWater;
import org.junit.jupiter.api.Test;

public class MyTests {

    @Test
    public void setOnOcean() {
        Ocean ocean = new Ocean(7);
        assertEquals(StuffOnWater.WATER, ocean.shootAt(3), "Water");
        ocean.setOnOceanAt(2, StuffOnWater.AIRCRAFT_CARRIER);
        assertEquals(StuffOnWater.WATER, ocean.shootAt(0), "Water");
        assertEquals(StuffOnWater.WATER, ocean.shootAt(1), "Water");
        assertEquals(StuffOnWater.AIRCRAFT_CARRIER, ocean.shootAt(2), "Air craft");
        assertEquals(StuffOnWater.AIRCRAFT_CARRIER, ocean.shootAt(3), "Air craft");
        assertEquals(StuffOnWater.AIRCRAFT_CARRIER, ocean.shootAt(4), "Air craft");
        assertEquals(StuffOnWater.AIRCRAFT_CARRIER, ocean.shootAt(5), "Air craft");
        assertEquals(StuffOnWater.WATER, ocean.shootAt(6), "Water");
    }

    @Test
    public void findFreePosition() {
        Ocean ocean = new Ocean(8);
        ocean.setOnOceanAt(0, StuffOnWater.AIRCRAFT_CARRIER);
        assertEquals(4, ocean.findFreePosition(StuffOnWater.CRUISER), "found place for ship");
        ocean.setOnOceanAt(4, StuffOnWater.CRUISER);
        assertEquals(StuffOnWater.CRUISER, ocean.shootAt(4), "Found cruser");
        assertEquals(StuffOnWater.CRUISER, ocean.shootAt(5), "Found cruser");
        assertEquals(StuffOnWater.CRUISER, ocean.shootAt(6), "Found cruser");
        assertEquals(StuffOnWater.WATER, ocean.shootAt(7), "Water");

    }

    @Test
    public void findSpaceForShip() {
        Ocean ocean = new Ocean(5);
        ocean.setOnOceanAt(0, StuffOnWater.DESTROYER);
        assertEquals(Result.SUCCESS, ocean.setShipWhereThereIsPlace(StuffOnWater.CRUISER), "success");
        assertEquals(StuffOnWater.CRUISER, ocean.shootAt(2), "Found cuiser");
    }


}