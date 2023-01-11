package model;

/**
 * Class that handles the placing of ships on the board, button logic and the array for the ships. 
 * @author Mehmet, Alexander
 */
public class GameManager {
    private Ships[] ships = new Ships[10];
    private Ships[] shipsDestroyed = new Ships[10];
    boolean sunkOrNot = false;
    private String hitShip;

    public GameManager() {

    }

    public Ships[] getArrayBoard() {
        return ships;
    }

    public void setArrayBoard(Ships[] arrayBoard) {
        this.ships = arrayBoard;
    }

    /**
     * Adds an object of the Destroyer class
     */
    public void addDestroyer(String shipName, ShipType shipType, int[] shipCoordinates) {
        for (int i = 0; i < ships.length; i++) {
            if (ships[i] == null) {
                ships[i] = new Destroyer(shipName, shipType, shipCoordinates);
                break;
            }
        }
    }

    /**
     * Adds an object of the Battleship class
     */
    public void addBattleShip(String shipName, ShipType shipType, int[] shipCoordinates) {
        for (int i = 0; i < ships.length; i++) {
            if (ships[i] == null) {
                ships[i] = new Battleship(shipName, shipType, shipCoordinates);
                break;
            }
        }
    }

    /**
     * Adds an object of the Cruiser class
     */
    public void addCruiser(String shipName, ShipType shipType, int[] shipCoordinates) {
        for (int i = 0; i < ships.length; i++) {
            if (ships[i] == null) {
                ships[i] = new Cruiser(shipName, shipType, shipCoordinates);
                break;
            }
        }
    }

    /**
     * Adds an object of the Submarine class
     */
    public void addSubmarine(String shipName, ShipType shipType, int[] shipCoordinates) {
        for (int i = 0; i < ships.length; i++) {
            if (ships[i] == null) {
                ships[i] = new Submarine(shipName, shipType, shipCoordinates);
                break;
            }
        }
    }

    /**
     * Adds an object of the Torpedo class
     */
    public void addTorpedoBoat(String shipName, ShipType shipType, int[] shipCoordinates) {
        for (int i = 0; i < ships.length; i++) {
            if (ships[i] == null) {
                ships[i] = new TorpedoBoat(shipName, shipType, shipCoordinates);
                break;
            }
        }
    }

    /**
     * Checks if the button clicked is in the coordinates of the ships object
     * 
     * @author Mehmet
     * @param btnNumber - The number value of a button
     */
    public boolean checkIfButtonNumberIsInShipsArray(int btnNumber) {
        boolean btnNumberisInArray = false;

        for (Ships ship : ships) {
            if (ship != null) {
                int[] coordinates = ship.getShipCoordinates();

                for (int i = 0; i < coordinates.length; i++) {
                    if (coordinates[i] == btnNumber) {
                        btnNumberisInArray = true;
                        coordinates[i] = 0;

                        ship.setShipCoordinates(coordinates);
                        hitShip = ship.getShipName();

                        if (ship.isShipCoordinatesEmpty() == true) {
                            ship.setShipDestroyed(true);
                            sunkOrNot = true;
                        }

                        // Checks if all part of the ship is destroyed
                        if (ship.getShipDestroyed() == true) {
                            for (int j = 0; j < shipsDestroyed.length; j++) {
                                if (shipsDestroyed[j] == null) {
                                    shipsDestroyed[j] = ship;
                                    break;
                                }
                            }
                        }

                        break;
                    }
                }

            }
        }

        return btnNumberisInArray;
    }

    /**
     * returns array of ships that have been destroyed
     */
    public Ships[] getShipsDestroyed() {
        return shipsDestroyed;
    }

    /**
     * returns a boolean about if the ship has been destroyed or not
     */
    public boolean getSunkOrNot() {
        return sunkOrNot;
    }

    /**
     * sets a new value to if a ship has been sunk or not
     */
    public void setSunkOrNot() {
        sunkOrNot = false;
    }

    /**
     * gets the name of a ship that has been hit
     */
    public String getHitShipName() {
        return hitShip;
    }
}
