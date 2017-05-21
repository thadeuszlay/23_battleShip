package test;

/**
 * Created by think on 17.05.17.
 */

import main.model.OceanImpl;
import main.model.Orientation;
import main.model.StuffOnWater;

import org.junit.*;

public class MyTests {

    private static OceanImpl ocean;
    @BeforeClass
    public static void onceExecutedBeforeAll() throws Exception {
        ocean = new OceanImpl(5,5 );
    }

    @Ignore
    @Test
    public void acceptOnlyValidFieldsForOcean() throws Exception {
        OceanImpl ocean = new OceanImpl(6,6);
    }
    @Ignore
    @Test
    public void setDestroyer() {

        //ocean.setOnOceanAt(0,0, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
    }
    @Test
    public void displayOceanField() throws Exception {

//        Ocean ocean = new Ocean(10, 12);
//        ocean.setOnOceanAt(0,0, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setOnOceanAt(0,4, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setOnOceanAt(0,8, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//
//        ocean.setOnOceanAt(2,0, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setOnOceanAt(2,4, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setOnOceanAt(2,8, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//
//        ocean.setOnOceanAt(4,0, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setOnOceanAt(4,4, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setOnOceanAt(4,8, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//
//        ocean.setOnOceanAt(6,0, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setOnOceanAt(6,4, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setOnOceanAt(6,8, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//
//        ocean.setOnOceanAt(8,0, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setOnOceanAt(8,4, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setOnOceanAt(8,8, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//
//        ocean.setOnOceanAt(1,0, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setOnOceanAt(1,4, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setOnOceanAt(1,8, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//
//        ocean.setOnOceanAt(3,0, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setOnOceanAt(3,4, Orientation.VERTICAL, StuffOnWater.CRUISER);
//        ocean.setOnOceanAt(3,7, Orientation.VERTICAL, StuffOnWater.AIRCRAFT_CARRIER);
//
//        ocean.setShipWhereThereIsPlace(StuffOnWater.DESTROYER);
    }

    @Test
    public void setShipsAtRadomPlace() throws Exception {
//        Ocean ocean = new Ocean(10, 13);
//        ocean.setShipWhereThereIsPlace(StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setShipWhereThereIsPlace(StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setShipWhereThereIsPlace(StuffOnWater.CRUISER);
//        ocean.setShipWhereThereIsPlace(StuffOnWater.CRUISER);
//        ocean.setShipWhereThereIsPlace(StuffOnWater.DESTROYER);
//        ocean.setShipWhereThereIsPlace(StuffOnWater.DESTROYER);

        //CommandLineInterface ui = new CommandLineInterface();
        //ui.showOcean(ocean);
    }

    @Test
    public void setShipsAtRandomPlaceUntilFindAPlaceOtherwiseThrowAnException() throws Exception {
//        Ocean ocean = new Ocean(5, 5);
//        ocean.setShipWhereThereIsPlace(StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setShipWhereThereIsPlace(StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setShipWhereThereIsPlace(StuffOnWater.CRUISER);
//        ocean.setShipWhereThereIsPlace(StuffOnWater.CRUISER);
//        ocean.setShipWhereThereIsPlace(StuffOnWater.DESTROYER);
//        ocean.setShipWhereThereIsPlace(StuffOnWater.DESTROYER);
//
//        CommandLineInterface ui = new CommandLineInterface();
//        ui.showOceanOpen(ocean);
    }

    @Test
    public void shootAtPoint() throws Exception {
//        Ocean ocean = new Ocean(14, 20);
//
//        ocean.setShipWhereThereIsPlace(StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setShipWhereThereIsPlace(StuffOnWater.AIRCRAFT_CARRIER);
//        ocean.setShipWhereThereIsPlace(StuffOnWater.CRUISER);
//        ocean.setShipWhereThereIsPlace(StuffOnWater.CRUISER);
//        ocean.setShipWhereThereIsPlace(StuffOnWater.DESTROYER);
//        ocean.setShipWhereThereIsPlace(StuffOnWater.DESTROYER);
//
//        System.out.println(ocean.shootAt(3, 4));
//        System.out.println(ocean.showShotsMade());
//
//        System.out.println(ocean.shootAt(1, 1));
//        System.out.println(ocean.showShotsMade());
//
//        System.out.println(ocean.shootAt(2, 1));
//
//        System.out.println(ocean.shootAt(4, 3));
//
//        System.out.println(ocean.shootAt(4, 5));
//        System.out.println(ocean.shootAt(4, 3));
//        System.out.println(ocean.shootAt(5, 11));
//
//        System.out.println(ocean.shootAt(9, 19));
//        System.out.println(ocean.shootAt(13, 16));
//        System.out.println(ocean.shootAt(13, 17));
//
//        System.out.println(ocean.shootAt(12, 16));
//
//        System.out.println(ocean.shootAt(3, 16));

        //System.out.println(ocean.getShotMade(1,1));
        //CommandLineInterface ui = new CommandLineInterface();
        //ui.showOcean(ocean);
        //ui.showOceanHidden(ocean);
    }

    @Test
    public void shotAllShipsDown() throws Exception {
//        Ocean ocean = new Ocean(10, 10);
//        ocean.setOnOceanAt(0,0, Orientation.HORIZONTAL, StuffOnWater.AIRCRAFT_CARRIER);
//
//        System.out.println(ocean.howManyTargetsHit());
//
//        System.out.println(ocean.shootAt(0,0));
//        System.out.println(ocean.howManyTargetsHit());
//
//        System.out.println(ocean.shootAt(1,0));
//        System.out.println(ocean.howManyTargetsHit());
//
//        System.out.println(ocean.shootAt(9,9));
//        System.out.println(ocean.howManyTargetsHit());
//
//        System.out.println(ocean.shootAt(2,0));
//        System.out.println(ocean.howManyTargetsHit());
//
//        System.out.println(ocean.shootAt(3,0));
//        System.out.println(ocean.howManyTargetsHit());
//        System.out.println(ocean.shootAt(4,0));
//        System.out.println(ocean.howManyTargetsHit());
//        CommandLineInterface ui = new CommandLineInterface();
//        ui.showOcean(ocean);
    }
}