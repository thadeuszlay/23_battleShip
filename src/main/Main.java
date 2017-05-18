package main;

import main.controller.Game;
import main.model.Ocean;

/**
 * Created by think on 17.05.17.
 */
public class Main {
    public static void main(String[] args) {
        //6x6 grid
        // 6 ships:
        // 2 destroyers= 2
        // 2 cruisers = 3
        // 2 aircraft carrier = 4
        Ocean ocean = new Ocean(10);
        Game game = new Game(ocean);
        game.start();
    }
}
