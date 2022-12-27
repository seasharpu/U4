package controller;
import javax.swing.JOptionPane;

import model.Cruiser;
import model.ShipType;


public class Main {
    public static void main(String[] args) {
        String nameOfThePlayer = JOptionPane.showInputDialog( "Player name?");
        String gameBoard = JOptionPane.showInputDialog( "Choose a gameboard - 1 or 2");
        int chosenGameBoard = Integer.parseInt(gameBoard);
        while((chosenGameBoard != 1) && (chosenGameBoard != 2)){
            gameBoard = JOptionPane.showInputDialog( "Choose a gameboard - 1 or 2");
            chosenGameBoard = Integer.parseInt(gameBoard);
        }
        
        Controller theController = new Controller(nameOfThePlayer, chosenGameBoard);
    }

}