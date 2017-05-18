package main.controller;

import main.model.Ocean;

/**
 * Created by think on 18.05.17.
 */
public class Game {
    Ocean ocean;
    public Game(Ocean ocean) {
        this.ocean = ocean;
    }

    public void start() {
        System.out.println("start game");

    }
}
