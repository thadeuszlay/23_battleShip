package main.view;

import main.model.Ocean;
import main.model.OceanImpl;

/**
 * Created by think on 18.05.17.
 */
public interface UserInterface {
    void showOceanOpen(Ocean ocean);
    void showOcean(Ocean ocean);
    void showOceanHidden(Ocean ocean);
}
