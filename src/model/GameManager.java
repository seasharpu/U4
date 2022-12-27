package model;

public class GameManager {
    private Ships[] ships = new Ships[10];

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

    public boolean checkIfButtonNumberIsInArrayBoard(int btnNumber){
        boolean btnNumberisInArray = false;

        for (int i = 0; i < ships.length; i++) {

            if(ships[i] != null){

                int[] cordinates = ships[i].getShipCoordinates();
                
                for (int j = 0; j < cordinates.length; j++) {
                    if(cordinates[i] == btnNumber){
                        btnNumberisInArray = true;
                    }
                }
            }
            
        }

        return btnNumberisInArray;
    }

}
