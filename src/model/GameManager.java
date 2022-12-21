package model;

public class GameManager {
    private Ships[] arrayBoard;

    public GameManager(Ships[] arrayBoard) {
        this.arrayBoard = arrayBoard;
    }

    public Ships[] getArrayBoard() {
        return arrayBoard;
    }

    public void setArrayBoard(Ships[] arrayBoard) {
        this.arrayBoard = arrayBoard;
    }



}
