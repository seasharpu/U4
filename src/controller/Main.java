package controller;

import javax.swing.JOptionPane;

import model.Cruiser;
import model.ShipType;

/**
 * Class that starts the program.
 * 
 * @author Mehmet, Alexander
 */
public class Main {
    private Controller theController;
    private String nameOfThePlayer;
    private int chosenGameBoard;
    private String gameBoard;

    public static void main(String[] args) {
        String nameOfThePlayer = JOptionPane.showInputDialog("Player name?");
        String gameBoard = JOptionPane.showInputDialog("Choose a gameboard - 1 or 2");
        int chosenGameBoard = Integer.parseInt(gameBoard);
        while ((chosenGameBoard != 1) && (chosenGameBoard != 2)) {
            gameBoard = JOptionPane.showInputDialog("Choose a gameboard - 1 or 2");
            chosenGameBoard = Integer.parseInt(gameBoard);
        }

        Controller theController = new Controller(nameOfThePlayer, chosenGameBoard);
    }

    /**
     * Method that creates a new controller for a new round of the game
     * @author Mehmet, Alexander
     */
    public void createNewController() {
        String nameOfThePlayer = JOptionPane.showInputDialog("Player name?");
        gameBoard = JOptionPane.showInputDialog("Choose a gameboard - 1 or 2");
        chosenGameBoard = Integer.parseInt(gameBoard);
        while ((chosenGameBoard != 1) && (chosenGameBoard != 2)) {
            gameBoard = JOptionPane.showInputDialog("Choose a gameboard - 1 or 2");
            chosenGameBoard = Integer.parseInt(gameBoard);
        }
        theController = new Controller(nameOfThePlayer, chosenGameBoard);
    }
}