package main.controller.utils;

import main.model.MaritimeElement;

import java.util.Scanner;

/**
 * Created by think on 21.05.17.
 */
public class Helper {
    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static int[] getIntegerUserInputInRange(int maxX, int maxY) {
        int x = -1, y = -1;
        do {
            String userInput = getUserInput();
            String[] userInputString = userInput.split(" ");
            try {
                x = Integer.parseInt(userInputString[0]);
                y = Integer.parseInt(userInputString[1]);
                if (x < 0 || x >= maxX || y < 0 || y >= maxY) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Please type in correct coordinates");
            }
        } while(true);
        return new int[]{x, y};
    }
    public static MaritimeElement[][] initOcean(int xLength, int yLength) {
        MaritimeElement[][] ocean = new MaritimeElement[yLength][xLength];
        for (int y = 0; y < yLength; y++) {
            for (int x = 0; x < xLength; x++) {
                ocean[y][x] = MaritimeElement.WATER;
            }
        }
        return ocean;
    }
}
