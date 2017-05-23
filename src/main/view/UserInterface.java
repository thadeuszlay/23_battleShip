package main.view;

import main.model.Ocean;

/**
 * Created by think on 18.05.17.
 */
public interface UserInterface {
    void display(String message);
    void displayFeedbackWin();
    void displayFeedbackShotMissed();
    void displayFeedbackShotHit();
    void showOceanOpen(Ocean ocean);
    void showOcean(Ocean ocean);
    void showOceanHidden(Ocean ocean);
}
