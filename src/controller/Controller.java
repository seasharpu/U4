package controller;
import java.awt.Color;

import javax.swing.JButton;

import model.Submarine;
import model.Cruiser;
import model.TorpedoBoat;
import model.Destroyer;
import model.ShipType;
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
        int torpedoCordinates[]  = {77, 78};
        int submarineCordinates[]  = {1, 11, 21};
        int cruiserCordinates[]  = {7, 8, 9, 10};
        int destroyerCordinates[]  = {54, 55, 56,57,58};

        TorpedoBoat TorpedoBoat = new TorpedoBoat("Eagle", ShipType.TorpedoBoat, torpedoCordinates);
        Submarine submarine = new Submarine("Shark", ShipType.Submarine, submarineCordinates);
        Cruiser cruiser = new Cruiser("Black Pearl", ShipType.Cruiser, cruiserCordinates);
        Destroyer destroyer = new Destroyer("Titanic", ShipType.Destroyer, destroyerCordinates);
      }

      if(chosenGameBoard == 2){
        int torpedoCordinates[]  = {88, 89, 90, 91};
        int submarineCordinates[]  = {34, 44, 54};
        int cruiserCordinates[]  = {21,31,41,51,61};
        int destroyerCordinates[]  = {28, 29};

        TorpedoBoat TorpedoBoat = new TorpedoBoat("Eagle", ShipType.TorpedoBoat, torpedoCordinates);
        Submarine submarine = new Submarine("Shark", ShipType.Submarine, submarineCordinates);
        Cruiser cruiser = new Cruiser("Black Pearl", ShipType.Cruiser, cruiserCordinates);
        Destroyer destroyer = new Destroyer("Titanic", ShipType.Destroyer, destroyerCordinates);
      }

    }

    public void buttonPressed(JButton btn) {
        btn.setEnabled(false);
        int btnNumber = Integer.parseInt(btn.getActionCommand());
        System.out.println(btnNumber);

        //For testing the buttons        
        if(isShipGetHit(btnNumber) == false){
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

    private Boolean isShipGetHit(int actionCommand) {
      boolean gotHit = false;

      return gotHit;
    }
}
