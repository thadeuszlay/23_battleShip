package main.model;

/**
 * Created by think on 18.05.17.
 */
public enum Orientation {
    HORIZONTAL(0), VERTICAL(1);
    private int value;
    Orientation(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
