package model;

public abstract class Ships extends GameManager {
    private String shipName;
    private ShipType shipType;
    private int[] shipCoordinates;
    private boolean shipDestroyed = false;

    public Ships(String shipName, ShipType shipType, int[] shipCoordinates) {
        this.shipName = shipName;
        this.shipType = shipType;
        this.shipCoordinates = shipCoordinates;
    }

    /**
     * gets the name of a ship
     */
    public String getShipName() {
        return shipName;
    }

    /**
     * sets the name of a ship
     */
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    /**
     * gets the type of a ship
     */
    public ShipType getShipType() {
        return shipType;
    }

    /**
     * gets the type of a ship
     */
    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    /**
     * gets the coordinates of a ship
     */
    public int[] getShipCoordinates() {
        return shipCoordinates;
    }

    /**
     * sets the coordinates of a ship
     */
    public void setShipCoordinates(int[] shipCoordinates) {
        this.shipCoordinates = shipCoordinates;
    }

    /**
     * Checks if ship coordinates are empty or not
     */
    public boolean isShipCoordinatesEmpty() {
        boolean empty = true;

        for (int i = 0; i < shipCoordinates.length; i++) {
            if (shipCoordinates[i] != 0) {
                empty = false;
                break;
            }
        }

        return empty;
    }

    /**
     * gets a boolean about whether a ship has been destroyed or not
     */
    public Boolean getShipDestroyed() {
        return shipDestroyed;
    }

    /**
     * sets a boolean about whether a ship has been destroyed or not
     */
    public void setShipDestroyed(boolean shipDestroyed) {
        this.shipDestroyed = shipDestroyed;
    }

    /**
     * returns name and type of a ship in string format
     */
    @Override
    public String toString() {
        return "Ship: " + shipName + " ShipType: " + shipType;
    }
}
