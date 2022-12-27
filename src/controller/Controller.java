package controller;
import java.awt.Color;

import javax.swing.JButton;

import model.Cruiser;
import model.ShipType;
import model.Submarine;
import view.GameBoard;
import view.MainFrame;
import view.MainPanel;


public class Controller {
    private MainFrame view;
    private int clicks;
    
      public Controller(String nameOfThePlayer, int chosenGameBoard) {
        view = new MainFrame(1200, 500, this);
        view.setPlayerName(nameOfThePlayer);
        setUpShips(chosenGameBoard);
    }

    private void setUpShips(int chosenGameBoard) {
      if(chosenGameBoard == 1){
        int submarineCordinates[]  = {1, 11, 21};
        
        Submarine submarine = new Submarine("Shark", ShipType.Submarine, submarineCordinates);
        
      }

      if(chosenGameBoard == 2){

      }
    }

    public void buttonPressed(JButton btn) {
        System.out.println(btn.getActionCommand());
        btn.setEnabled(false);

        //For testing the buttons        
        if(clicks%2 == 0){
          //If a ship-part missed
          btn.setText("X");
        }
        else{
          //If a ship-part located
          btn.setVisible(false);
        }

    
        //Updates the clicks variable and mainFrame
        clicks++;
        view.setClicks("Clicks: " + String.valueOf(clicks));

        //view.setSunkShips("Ship sunk: " + String.valueOf(clicks));
    }
}
