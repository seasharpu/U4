package view;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.Controller;

public class MainFrame extends JFrame {

    private MainPanel mainPanel;
    private Controller controller;

    public MainFrame(int width, int height, Controller controller) {
        super("The Battleship");
        this.controller = controller;
        this.setResizable(false);
        this.setSize(width, height);
        this.setLocation(100, 100);
        this.mainPanel = new MainPanel(width, height, this);
        this.setContentPane(mainPanel);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Calls the buttonpressed method in controller
     */
    public void buttonPressed(JButton btn) {
        controller.buttonPressed(btn);
    }

    /**
     * Calls the restart game method in controller
     */
    public void restartButtonPressed() {
        controller.restartGame();
    }

    /**
     * calls the set player name in gameboard
     * @param playerName - Name of the player
     */
    public void setPlayerName(String playerName) {
        mainPanel.getGameBoard().setPlayerName(playerName);
    }

    /**
     * calls the setamountclicks method in gameboard
     * @param newText - amount of clicks
     */
    public void setClicks(String newText) {
        mainPanel.getGameBoard().setAmountClicks(newText);
    }

    /**
     * calls the setamountshots in gameboard
     * @param newText - amount of shots
     */
    public void setShotsLeft(String newText) {
        mainPanel.getGameBoard().setAmountShots(newText);
    }

    /**
     * calls the setamountshipsunk in gameboard
     * @param newText - amount of ships sunk
     */
    public void setSunkShips(String newText) {
        mainPanel.getGameBoard().setAmountShipSunk(newText);
    }

    /**
     * calls the updategameboard method in mainpanel
     * @param ok - boolean to enable the visibility of the gameboard panel
     */
    public void updateGameBoard(boolean ok) {
        mainPanel.setGameBoardVisible(ok);
    }

    /**
     * calls the populatescoreboardlist method in scoreboard
     * @param scoreboard - array with scores to update the scoreboard list with
     */
    public void updateScoreboard(String[] scoreboard) {
        mainPanel.getScoreBoard().populateScoreBoardList(scoreboard);
    }

    /**
     * calls the populategameinformation method in gameinformation
     * 
     * @param gameInformationArray - array with gameinformation to update the
     *                             gameinformation list with
     */
    public void updateGameInformation(String[] gameInformationArray) {
        mainPanel.getGameInformation().populateGameInformationList(gameInformationArray);
    }
}
