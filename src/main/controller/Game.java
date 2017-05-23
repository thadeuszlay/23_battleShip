package main.controller;

import main.controller.assertion.AssertionMaritime;
import main.controller.assertion.AssertionMaritimeImpl;
import main.controller.utils.Helper;
import main.model.Ocean;
import main.model.OceanImpl;
import main.model.MaritimeElement;
import main.view.CommandLineInterface;
import main.view.UserInterface;

/**
 * Created by think on 18.05.17.
 */
public class Game {
    Ocean ocean;
    UserInterface ui = new CommandLineInterface();
    AssertionMaritime assertUser = new AssertionMaritimeImpl();
    public Game(OceanImpl ocean) {
        this.ocean = ocean;
    }

    public void start() throws Exception {
        do {
            ui.showOceanHidden(ocean);
            int[] userInput = Helper.getIntegerUserInputInRange(ocean.getXLength(), ocean.getYLength());
            MaritimeElement shotAtElement = ocean.shootAt(userInput);
            displayResult(shotAtElement);
        } while(ocean.howManyTargetsHit() != 0);
        ui.displayFeedbackWin();
        ui.showOcean(ocean);
    }

    private void displayResult(MaritimeElement shotAtElement) {
        if (assertUser.isWater(shotAtElement)) {
            ui.displayFeedbackShotMissed();
        } else {
            ui.displayFeedbackShotHit();
        }
    }
}