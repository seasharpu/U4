package model;

public class Cruiser extends Ships{
    private String shipName;
    private ShipType shipType;
    private int cordinates[]; 

    public Cruiser(String shipName, ShipType shipType, int[] shipCoordinates) {
        super(shipName, shipType, shipCoordinates);
        this.shipName = shipName;
        this.shipType = shipType;
        this.cordinates = shipCoordinates;
    }

    @Override
    public String toString() {
        return "Shipname: " + shipName + " Shiptype: " + shipType;
    }
}
