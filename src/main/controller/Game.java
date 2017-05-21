package main.controller;

import main.model.Ocean;
import main.model.StuffOnWater;
import main.view.CommandLineInterface;

/**
 * Created by think on 18.05.17.
 */
public class Game {
    Ocean ocean;
    CommandLineInterface ui = new CommandLineInterface();
    public Game(Ocean ocean) {
        this.ocean = ocean;
    }

    public void start() throws Exception {
        do {
            ui.showOceanHidden(ocean);
            String userInput = ui.getUserInput();
            String[] coordinateUserInput = userInput.split(" ");
            StuffOnWater shotAtElement = ocean.shootAt(Integer.parseInt(coordinateUserInput[0]), Integer.parseInt(coordinateUserInput[1]));
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
