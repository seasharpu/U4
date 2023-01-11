package controller;

import javax.sound.midi.MidiEvent;
import javax.swing.JButton;

import view.MainFrame;
import model.GameManager;
import view.GameBoard;
import view.GameFinishedBoard;
import view.ScoreBoard;
import model.ShipType;
import model.Ships;
import model.Highscore;

/**
 * Mediator for view and model classes. Handles logic.
 * 
 * @author Mehmet, Alexander
 */

public class Controller {
  private MainFrame view;
  private int shotsRequired = 15;
  private int clicks = 0;
  private int amountDestroyedShips = 0;
  private String nameOfThePlayer;
  private GameManager gameManager = new GameManager();
  private Highscore highscore = new Highscore();
  private String[] gameInformationArray;

  public Controller(String nameOfThePlayer, int chosenGameBoard) {
    view = new MainFrame(1200, 500, this);
    view.setPlayerName(nameOfThePlayer);
    setUpShips(chosenGameBoard);
    setupHighscore();
    this.nameOfThePlayer = nameOfThePlayer;
    this.gameInformationArray = new String[100];
  }

  /**
   * Sets up the highscore, for example calling methods to read the highscore file
   * 
   * @author Mehmet
   */
  public void setupHighscore() {
    highscore.countAmountPlayersOnList();
    highscore.readNames();
    highscore.readScores();
    highscore.sortTheArrays();
    highscore.writeToArrayScores();

    view.updateScoreboard(highscore.getArrayScores());
  }

  /**
   * Sets up the the ships by creating new instances of them
   * 
   * @author Mehmet
   */
  private void setUpShips(int chosenGameBoard) {
    if (chosenGameBoard == 1) {
      int battleShipCordinates[] = { 92 };
      int torpedoCordinates[] = { 77, 78 };
      int submarineCordinates[] = { 1, 11, 21 };
      int cruiserCordinates[] = { 7, 8, 9, 10 };
      int destroyerCordinates[] = { 54, 55, 56, 57, 58 };

      gameManager.addBattleShip("Battleship", ShipType.Battleship, battleShipCordinates);
      gameManager.addTorpedoBoat("TorpedoBoat", ShipType.TorpedoBoat, torpedoCordinates);
      gameManager.addSubmarine("Submarine", ShipType.Submarine, submarineCordinates);
      gameManager.addCruiser("Cruiser", ShipType.Cruiser, cruiserCordinates);
      gameManager.addDestroyer("Destroyer", ShipType.Destroyer, destroyerCordinates);
    }

    if (chosenGameBoard == 2) {
      int battleShipCordinates[] = { 70 };
      int destroyerCordinates[] = { 28, 29 };
      int submarineCordinates[] = { 34, 44, 54 };
      int torpedoCordinates[] = { 87, 88, 89, 90 };
      int cruiserCordinates[] = { 21, 31, 41, 51, 61 };

      gameManager.addBattleShip("Battleship", ShipType.Battleship, battleShipCordinates);
      gameManager.addTorpedoBoat("TorpedoBoat", ShipType.TorpedoBoat, torpedoCordinates);
      gameManager.addSubmarine("Submarine", ShipType.Submarine, submarineCordinates);
      gameManager.addCruiser("Cruiser", ShipType.Cruiser, cruiserCordinates);
      gameManager.addDestroyer("Destroyer", ShipType.Destroyer, destroyerCordinates);
    }

  }

  /**
   * Restarts the game by first printing the scoreboard to textfiles and then
   * creating a new main and controller
   * 
   * @author Mehmet
   */
  public void restartGame() {
    highscore.printScoreboard(nameOfThePlayer, clicks);
    view.setVisible(false);
    Main main = new Main();
    main.createNewController();
  }

  /**
   * This method is called by class MinFrame when a button in the GUI is pressed
   * 
   * @param button - A button of the JButton
   */
  public void buttonPressed(JButton btn) {
    btn.setEnabled(false);
    int btnNumber = Integer.parseInt(btn.getActionCommand());

    // Checks if the clicked buttons number is in ships array
    if (gameManager.checkIfButtonNumberIsInShipsArray(btnNumber) == true) {
      // If a ship-part got hit
      btn.setVisible(false);
      shotsRequired--;

      int amountDestroyed = 0;
      // Gets ships destroyed
      Ships[] shipsDestroyed = gameManager.getShipsDestroyed();
      for (int i = 0; i < shipsDestroyed.length; i++) {
        if (shipsDestroyed[i] != null) {
          amountDestroyed++;
        }
      }

      amountDestroyedShips = amountDestroyed;

      for (int i = 0; i < gameInformationArray.length; i++) {
        if (gameInformationArray[i] == null) {

          gameInformationArray[i] = "          You hit a " + gameManager.getHitShipName() + "!";

          if (gameManager.getSunkOrNot() == true) {
            gameInformationArray[i + 1] = "          You sunk the " + gameManager.getHitShipName() + "!";
            gameManager.setSunkOrNot();
          }

          view.updateGameInformation(gameInformationArray);
          break;
        }
      }
    } else {
      // If a ship-part missed
      btn.setText("X");
      for (int i = 0; i < gameInformationArray.length; i++) {
        if (gameInformationArray[i] == null) {
          gameInformationArray[i] = "          You missed!";
          view.updateGameInformation(gameInformationArray);
          break;
        }
      }
    }

    // Updates the clicks variable and mainFrame
    clicks++;
    view.setClicks("Clicks: " + String.valueOf(clicks));
    view.setShotsLeft("Shots left: " + String.valueOf(shotsRequired));
    view.setSunkShips("Ship sunk: " + String.valueOf(amountDestroyedShips));
    if (amountDestroyedShips == 5) {
      gameFinished();
    }
  }

  /**
   * Creates a new GUI element that displays a game finished screen
   */
  public void gameFinished() {
    view.updateGameBoard(false);
    GameFinishedBoard gameFinishedBoard = new GameFinishedBoard(1200, 500, clicks, nameOfThePlayer, view);
  }

  /**
   * Gets the players name
   */
  public String getNameOfThePlayer() {
    return nameOfThePlayer;
  }

  /**
   * Gets the amount of clicks a player has done
   */
  public int getClicks() {
    return clicks;
  }

}
