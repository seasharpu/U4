package model;

public abstract class Ships extends GameManager{
    private String shipName;
    private ShipType shipType;
    private int[] shipCoordinates;
    private boolean shipDestroyed = false;

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

    public void removeFromShipCoordinates(int btnNumber){
        int[] copyArray = new int[shipCoordinates.length-1];

        if(copyArray.length == 0){
            setShipDestroyed(true);
        }
        else{
            for (int i = 0; i<copyArray.length; i++){
                if(shipCoordinates[i] != btnNumber){
                    copyArray[i] = shipCoordinates[i];
                }
            }
        }

        shipCoordinates = copyArray;
    }

    public Boolean getShipDestroyed() {
        return shipDestroyed;
    }

    public void setShipDestroyed(boolean shipDestroyed) {
        this.shipDestroyed = shipDestroyed;
    }

    @Override
    public String toString() {
        return "Ship: " + shipName + " ShipType: " + shipType;
    }
}
