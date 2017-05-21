package main;

import main.controller.Game;
import main.model.OceanImpl;
import main.model.StuffOnWater;

/**
 * Created by think on 17.05.17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        OceanImpl ocean = new OceanImpl(5, 5);

        ocean.setShipWhereThereIsPlace(StuffOnWater.AIRCRAFT_CARRIER);
        ocean.setShipWhereThereIsPlace(StuffOnWater.AIRCRAFT_CARRIER);
        ocean.setShipWhereThereIsPlace(StuffOnWater.CRUISER);
        ocean.setShipWhereThereIsPlace(StuffOnWater.CRUISER);
        ocean.setShipWhereThereIsPlace(StuffOnWater.DESTROYER);
        ocean.setShipWhereThereIsPlace(StuffOnWater.DESTROYER);

        Game game = new Game(ocean);
        game.start();
    }
}
