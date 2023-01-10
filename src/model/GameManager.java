package model;

public class GameManager {
    private Ships[] ships = new Ships[10];
    private Ships[] shipsDestroyed = new Ships[10];
    boolean sunkOrNot = false;
    private String hitShip; 

    public GameManager(){

    }

    public Ships[] getArrayBoard() {
        return ships;
    }

    public void setArrayBoard(Ships[] arrayBoard) {
        this.ships = arrayBoard;
    }


    public void addDestroyer(String shipName, ShipType shipType, int[] shipCoordinates){
        for (int i = 0; i < ships.length; i++) {
            if(ships[i] == null){
                ships[i] = new Destroyer(shipName, shipType, shipCoordinates);
                break;
            }
        }
    }

    public void addBattleShip(String shipName, ShipType shipType, int[] shipCoordinates){
        for (int i = 0; i < ships.length; i++) {
            if(ships[i] == null){
                ships[i] = new Battleship(shipName, shipType, shipCoordinates);
                break;
            }
        }
    }

    public void addCruiser(String shipName, ShipType shipType, int[] shipCoordinates){
        for (int i = 0; i < ships.length; i++) {
            if(ships[i] == null){
                ships[i] = new Cruiser(shipName, shipType, shipCoordinates);
                break;
            }
        }
    }

    public void addSubmarine(String shipName, ShipType shipType, int[] shipCoordinates){
        for (int i = 0; i < ships.length; i++) {
            if(ships[i] == null){
                ships[i] = new Submarine(shipName, shipType, shipCoordinates);
                break;
            }
        }
    }

    public void addTorpedoBoat(String shipName, ShipType shipType, int[] shipCoordinates){
        for (int i = 0; i < ships.length; i++) {
            if(ships[i] == null){
                ships[i] = new TorpedoBoat(shipName, shipType, shipCoordinates);
                break;
            }
        }
    }

    public boolean checkIfButtonNumberIsInShipsArray(int btnNumber){
        boolean btnNumberisInArray = false;
       

        for (Ships ship : ships) {
            if(ship != null){
                int [] coordinates = ship.getShipCoordinates();

                for (int i = 0; i < coordinates.length; i++) {
                    if(coordinates[i] == btnNumber){
                        btnNumberisInArray = true;
                        coordinates[i] = 0;
                        
                        ship.setShipCoordinates(coordinates);
                        hitShip = ship.getShipName();

                        if(ship.isShipCoordinatesEmpty() == true){
                            ship.setShipDestroyed(true);
                            sunkOrNot = true;
                        }
                        
                        //Checks if all part of the ship is destroyed
                        if(ship.getShipDestroyed() == true){
                            for (int j = 0; j < shipsDestroyed.length; j++) {
                                if(shipsDestroyed[j] == null){
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

    public Ships[] getShipsDestroyed() {
        return shipsDestroyed;
    }

    public boolean getSunkOrNot(){
        return sunkOrNot;
    }

    public void setSunkOrNot(){
        sunkOrNot = false;
    }

    public String getHitShipName(){
        return hitShip;
    }
}
