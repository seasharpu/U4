package model;

public abstract class Ships{
    private String shipName;
    private ShipType shipType;
    private int[] shipCoordinates;

    public Ships(String shipName, ShipType shipType, int[] shipCoordinates) {
        this.shipName = shipName;
        this.shipType = shipType;
        this.shipCoordinates = shipCoordinates;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public int[] getShipCoordinates() {
        return shipCoordinates;
    }

    public void setShipCoordinates(int[] shipCoordinates) {
        this.shipCoordinates = shipCoordinates;
    }

    @Override
    public String toString() {
        return "Ship: " + shipName + " ShipType: " + shipType;
    }
}
