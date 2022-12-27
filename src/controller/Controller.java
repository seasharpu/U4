package controller;
import javax.swing.JButton;

import view.MainFrame;
import view.MainPanel;
import model.GameManager;
import view.GameBoard;
import view.ScoreBoard;
import model.ShipType;
import model.Ships;
import model.Submarine;
import model.Cruiser;
import model.TorpedoBoat;
import model.Destroyer;
import model.Battleship;

public class Controller {
    private MainFrame view;
    private int clicks;
    private GameManager gameManager = new GameManager();
  
    public Controller(String nameOfThePlayer, int chosenGameBoard) {
      view = new MainFrame(1200, 500, this);
      view.setPlayerName(nameOfThePlayer);
      setUpShips(chosenGameBoard);
    }

    private void setUpShips(int chosenGameBoard) {
      if(chosenGameBoard == 1){
        int battleShipCordinates[] = {88}; 
        int torpedoCordinates[]  = {77, 78};
        int submarineCordinates[]  = {1, 11, 21};
        int cruiserCordinates[]  = {7, 8, 9, 10};
        int destroyerCordinates[]  = {54, 55, 56,57,58};

        gameManager.addBattleShip("Leon", ShipType.Battleship, battleShipCordinates);
        gameManager.addTorpedoBoat("Eagle", ShipType.TorpedoBoat, torpedoCordinates);
        gameManager.addSubmarine("Shark", ShipType.Submarine, submarineCordinates);
        gameManager.addCruiser("Black Pearl", ShipType.Cruiser, cruiserCordinates);
        gameManager.addDestroyer("Titanic", ShipType.Destroyer, destroyerCordinates);
      }

      if(chosenGameBoard == 2){
        int battleShipCordinates[] = {70}; 
        int torpedoCordinates[]  = {88, 89, 90, 91};
        int submarineCordinates[]  = {34, 44, 54};
        int cruiserCordinates[]  = {21,31,41,51,61};
        int destroyerCordinates[]  = {28, 29};

        gameManager.addBattleShip("Leon", ShipType.Battleship, battleShipCordinates);
        gameManager.addTorpedoBoat("Eagle", ShipType.TorpedoBoat, torpedoCordinates);
        gameManager.addSubmarine("Shark", ShipType.Submarine, submarineCordinates);
        gameManager.addCruiser("Black Pearl", ShipType.Cruiser, cruiserCordinates);
        gameManager.addDestroyer("Titanic", ShipType.Destroyer, destroyerCordinates);
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
    
      return gameManager.checkIfButtonNumberIsInArrayBoard(actionCommand);
    }
}
