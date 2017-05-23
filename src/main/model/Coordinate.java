package main.model;

/**
 * Created by think on 23.05.17.
 */
public enum Coordinate {
    X(0), Y(1), ORIENTATION(2);
    private int value;
    Coordinate(int value) {
        this.value = value;
    }
    public int val() {
        return this.value;
    }
}
