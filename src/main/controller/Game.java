package main.controller;

import main.controller.utils.Helper;
import main.model.Ocean;
import main.model.OceanImpl;
import main.model.StuffOnWater;
import main.view.CommandLineInterface;
import main.view.UserInterface;

/**
 * Created by think on 18.05.17.
 */
public class Game {
    Ocean ocean;
    UserInterface ui = new CommandLineInterface();
    public Game(OceanImpl ocean) {
        this.ocean = ocean;
    }

    public void start() throws Exception {
        do {
            ui.showOceanHidden(ocean);
            int[] userInput = Helper.getValidUserInput(ocean.getXLength(), ocean.getYLength());
            StuffOnWater shotAtElement = ocean.shootAt(userInput[0], userInput[1]);
            if (shotAtElement == StuffOnWater.WATER) {
                System.out.println("Missed");
            } else {
                System.out.println("Hit");
            }
        } while(ocean.howManyTargetsHit() != 0);
        System.out.println("You Won!");
        ui.showOcean(ocean);
    }
}
