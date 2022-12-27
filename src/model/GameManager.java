package model;

public class GameManager {
    private Ships[] arrayBoard = new Ships[4];

    public GameManager(){

    }

    public GameManager(Ships[] arrayBoard) {
        this.arrayBoard = arrayBoard;
    }

    public Ships[] getArrayBoard() {
        return arrayBoard;
    }

    public void setArrayBoard(Ships[] arrayBoard) {
        this.arrayBoard = arrayBoard;
    }

    public void addToShipsArray(Ships shipInfo){
        for (Ships ship : arrayBoard) {
            if(ship == null){
                ship = shipInfo;
                break;
            }
        }
    }

}
