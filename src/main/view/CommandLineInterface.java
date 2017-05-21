package main.view;

import main.controller.DrawShip;
import main.controller.DrawShipImpl;
import main.model.Ocean;
import main.model.StuffOnWater;

/**
 * Created by think on 18.05.17.
 */
public class CommandLineInterface implements UserInterface{
    DrawShip drawShip = new DrawShipImpl();

    @Override
    public void showOceanOpen(Ocean ocean) {
        genericDrawOcean(ocean, drawShipsOpenly);
    }

    @Override
    public void showOcean(Ocean ocean) {
        genericDrawOcean(ocean, drawAllShips);
    }

    @Override
    public void showOceanHidden(Ocean ocean) {
        genericDrawOcean(ocean, drawShotsMade);
    }

    private void genericDrawOcean(Ocean ocean, DrawStuffOnOcean drawStuffOnOcean) {
        for (int y = 0; y < ocean.getYLength(); y++) {
            for (int x = 0; x < ocean.getXLength(); x++) {
                if (y == 0 && x == 0) {
                    System.out.print("\t");
                    for (int i = 0; i < ocean.getXLength(); i++) {
                        System.out.print(i + "\t");
                    }
                    System.out.println();
                }
                if (x == 0) System.out.print(y + "\t");
                drawStuffOnOcean.draw(ocean, y, x);
            }
            System.out.println();
        }
    }

    interface DrawStuffOnOcean{
        void draw(Ocean ocean, int y, int x);
    }

    DrawStuffOnOcean drawShipsOpenly = (Ocean ocean, int y, int x) -> {
        StuffOnWater element = ocean.getLocationStatusAt(x,y);
        if(element == StuffOnWater.WATER) {
            System.out.print("~\t");
        } else if (element == StuffOnWater.DESTROYER) {
            drawShip.destroyer();
        } else if (element == StuffOnWater.CRUISER) {
            drawShip.cruiser();
        } else if (element == StuffOnWater.AIRCRAFT_CARRIER) {
            drawShip.showAircraftCarrier();
        }
    };

    DrawStuffOnOcean drawAllShips = (Ocean ocean, int y, int x) -> {
        StuffOnWater element = ocean.getLocationStatusAt(x,y);
        StuffOnWater checkForShotsMade = ocean.getShotMade(x,y);
        if (checkForShotsMade == null) {
            System.out.print("~\t");
        } else {
            if(element == StuffOnWater.WATER) {
                System.out.print("X\t");
            } else if (element == StuffOnWater.DESTROYER) {
                drawShip.destroyer();
            } else if (element == StuffOnWater.CRUISER) {
                drawShip.cruiser();
            } else if (element == StuffOnWater.AIRCRAFT_CARRIER) {
                drawShip.showAircraftCarrier();
            }
        }
    };

    DrawStuffOnOcean drawShotsMade = (Ocean ocean, int y, int x) -> {
        StuffOnWater element;
        if (ocean.getShotMade(x,y) == null) {
            System.out.print("~\t");
        } else {
            element = ocean.getShotMade(x,y);
            if(element == StuffOnWater.WATER) {
                System.out.print("X\t");
            } else {
                System.out.print("O\t");
            }
        }
    };
}