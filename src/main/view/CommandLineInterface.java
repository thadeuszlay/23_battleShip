package main.view;

import main.model.Ocean;
import main.model.StuffOnWater;

import java.util.Scanner;

/**
 * Created by think on 18.05.17.
 */
public class CommandLineInterface implements UserInterface{
    public void showOceanOpen(Ocean ocean) {
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
                StuffOnWater element = ocean.getLocationStatusAt(x,y);
                if(element == StuffOnWater.WATER) {
                    System.out.print("~\t");
                } else if (element == StuffOnWater.DESTROYER) {
                    showDestroyer();
                } else if (element == StuffOnWater.CRUISER) {
                    showCruiser();
                } else if (element == StuffOnWater.AIRCRAFT_CARRIER) {
                    showAircraftCarrier();
                }

            }
            System.out.println();
        }
    }
    @Override
    public void showOcean(Ocean ocean) {
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
                StuffOnWater element = ocean.getLocationStatusAt(x,y);
                StuffOnWater checkForShotsMade = ocean.getShotMade(x,y);
                if (checkForShotsMade == null) {
                    System.out.print("~\t");
                } else {
                    if(element == StuffOnWater.WATER) {
                        System.out.print("X\t");
                    } else if (element == StuffOnWater.DESTROYER) {
                        showDestroyer();
                    } else if (element == StuffOnWater.CRUISER) {
                        showCruiser();
                    } else if (element == StuffOnWater.AIRCRAFT_CARRIER) {
                        showAircraftCarrier();
                    }
                }
            }
            System.out.println();
        }
    }

    public void showOceanHidden(Ocean ocean) {
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
            }
            System.out.println();
        }
    }

    private void showShip(char c) {
        System.out.print(c + "" + c + "" + c + "" + c);
    }

    private void showDestroyer() {
        showShip((char)9617);
    }
    private void showCruiser() {
        showShip((char) 9618);
    }

    private void showAircraftCarrier() {
        showShip((char)9619);
    }

    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public int[] getValidUserInput() {
        do {

        } while(false);
        return new int[]{1, 2};
    }
}
