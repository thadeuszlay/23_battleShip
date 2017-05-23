package main.view;

import main.controller.DrawMaritime;
import main.controller.DrawMaritimeImpl;
import main.model.MaritimeElement;
import main.model.Ocean;

/**
 * Created by think on 18.05.17.
 */
public class CommandLineInterface implements UserInterface{

    DrawMaritime drawMaritime = new DrawMaritimeImpl();
    @Override
    public void display(String message) {
        System.out.println(message);
    }
    @Override
    public void displayFeedbackWin() {
        display("You won!");
    }
    @Override
    public void displayFeedbackShotMissed() {
        display("Missed");
    }
    @Override
    public void displayFeedbackShotHit() {
        display("Hit");
    }
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
        MaritimeElement element = ocean.getLocationStatusAt(x,y);
        if(element == MaritimeElement.WATER) {
            drawMaritime.water();
        } else if (element == MaritimeElement.DESTROYER) {
            drawMaritime.destroyer();
        } else if (element == MaritimeElement.CRUISER) {
            drawMaritime.cruiser();
        } else if (element == MaritimeElement.AIRCRAFT_CARRIER) {
            drawMaritime.aircraftCarrier();
        }
    };

    DrawStuffOnOcean drawAllShips = (Ocean ocean, int y, int x) -> {
        MaritimeElement element = ocean.getLocationStatusAt(x,y);
        MaritimeElement checkForShotsMade = ocean.getShotMade(x,y);
        if (checkForShotsMade == null) {
            drawMaritime.water();
        } else {
            if(element == MaritimeElement.WATER) {
                drawMaritime.missShip();
            } else if (element == MaritimeElement.DESTROYER) {
                drawMaritime.destroyer();
            } else if (element == MaritimeElement.CRUISER) {
                drawMaritime.cruiser();
            } else if (element == MaritimeElement.AIRCRAFT_CARRIER) {
                drawMaritime.aircraftCarrier();
            }
        }
    };

    DrawStuffOnOcean drawShotsMade = (Ocean ocean, int y, int x) -> {
        MaritimeElement element;
        if (ocean.getShotMade(x,y) == null) {
            drawMaritime.water();
        } else {
            element = ocean.getShotMade(x,y);
            if(element == MaritimeElement.WATER) {
                drawMaritime.missShip();
            } else {
                drawMaritime.hitShip();
            }
        }
    };
}