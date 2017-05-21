package main.controller;

/**
 * Created by think on 21.05.17.
 */
public class DrawShipImpl implements DrawShip{
    private void showShip(char c) {
        System.out.print(c + "" + c + "" + c + "" + c);
    }

    @Override
    public void destroyer() {
        showShip((char)9617);
    }
    @Override
    public void cruiser() {showShip((char) 9618);}
    @Override
    public void showAircraftCarrier() {
        showShip((char)9619);
    }
}
