package model;

public class GameManager {
    private Ships[] arrayBoard = new Ships[10];

    public GameManager(){

    }

    public GameManager(Ships newShip) {
        for (int i = 0; i < arrayBoard.length; i++) {
            if(arrayBoard[i] == null){
                arrayBoard[i] = newShip;
                System.out.println(arrayBoard[i]);
                break;
            }
        }
    }

    public Ships[] getArrayBoard() {
        return arrayBoard;
    }

    public void setArrayBoard(Ships[] arrayBoard) {
        this.arrayBoard = arrayBoard;
    }

/* 
    public void addToShipsArray(Ships shipp){
        for (Ships ship : arrayBoard) {
            if(ship == null){
                ship = shipp;
                break;
            }
        }        
    }
*/
    public boolean checkIfButtonNumberIsInArrayBoard(int btnNumber){
        boolean btnNumberisInArray = false;

        for (int i = 0; i < arrayBoard.length; i++) {

            System.out.println(arrayBoard[i]);
            
        }

        for (Ships ship : arrayBoard) {
     
/* 
            for (int cordinates : ship.getShipCoordinates()) {
                if(cordinates == btnNumber){
                    btnNumberisInArray = true;
                }
            }
*/

        }

        return btnNumberisInArray;
    }

}
