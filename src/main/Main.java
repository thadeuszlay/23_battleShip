package main;

import main.controller.Game;
import main.model.MaritimeElement;
import main.model.OceanImpl;

/**
 * Created by think on 17.05.17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        OceanImpl ocean = new OceanImpl(6, 7);

        ocean.setShipWhereThereIsPlace(MaritimeElement.AIRCRAFT_CARRIER);
        ocean.setShipWhereThereIsPlace(MaritimeElement.AIRCRAFT_CARRIER);
        ocean.setShipWhereThereIsPlace(MaritimeElement.CRUISER);
        ocean.setShipWhereThereIsPlace(MaritimeElement.CRUISER);
        ocean.setShipWhereThereIsPlace(MaritimeElement.DESTROYER);
        ocean.setShipWhereThereIsPlace(MaritimeElement.DESTROYER);

        Game game = new Game(ocean);
        game.start();
    }
}
