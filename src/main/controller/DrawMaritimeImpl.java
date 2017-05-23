package main.controller;

/**
 * Created by think on 21.05.17.
 */
public class DrawMaritimeImpl implements DrawMaritime {
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
    public void aircraftCarrier() {
        showShip((char)9619);
    }
    @Override
    public void water() {System.out.print("~\t");}
    @Override
    public void hitShip() {System.out.print((char)188419 + "\t");}
    @Override
    public void missShip() {System.out.print(" " + (char)1161 + "\t");}
}
