package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;


/**
 * Class for mainpanel where all panels are placed on.
 * @author Mehmet, Alexander
 */
public class MainPanel extends JPanel {
    private GameBoard gameBoard;
    private ScoreBoard scoreBoard;
    private GameInformation gameInformation;

    public MainPanel(int width, int height, MainFrame mainFrame) {
        super(null);
        this.setSize(width, height);

        gameBoard = new GameBoard(width / 2 + 60, height, mainFrame);
        add(gameBoard);

        scoreBoard = new ScoreBoard(width / 2 + 60, height / 2 - 50, mainFrame);
        add(scoreBoard);

        gameInformation = new GameInformation(width / 2 + 60, height / 2 - 45, mainFrame);
        add(gameInformation);
    }

    /**
     * returns the gameboard object
     */
    protected GameBoard getGameBoard() {
        return gameBoard;
    }

    /**
     * returns the scoreboard object
     */
    protected ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    /**
     * returns the gameinformation object
     */
    protected GameInformation getGameInformation() {
        return gameInformation;
    }

    /**
     * calls the setamountclicks method in gameboard
     * @param newText - amount of clicks
     */
    public void setClicks(String newText) {
        gameBoard.setAmountClicks(newText);
    }

    /**
     * sets the visibility of the gameboard
     * @param ok - boolean to enable visibility of the gameboard
     */
    public void setGameBoardVisible(boolean ok) {
        gameBoard.setVisible(ok);
    }

}
