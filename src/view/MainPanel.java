package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

public class MainPanel extends JPanel{
    private GameBoard gameBoard;
    private ScoreBoard scoreBoard;
    private GameInformation gameInformation;
    private GameFinishedBoard gameFinishedBoard;

    public MainPanel(int width, int height, MainFrame mainFrame) {
        super(null);
        this.setSize(width, height);

        gameBoard = new GameBoard(width / 2 +60, height, mainFrame);
        add(gameBoard);

        scoreBoard = new ScoreBoard(width / 2 +60, height/2-50, mainFrame);
        add(scoreBoard);

        gameInformation = new GameInformation(width / 2 +60, height/2-45, mainFrame);
        add(gameInformation);
    }

    protected GameBoard getGameBoard() {
        return gameBoard;
    }

    protected ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    protected GameInformation getGameInformation() {
        return gameInformation;
    }

    public void setClicks(String newText){
        gameBoard.setAmountClicks(newText);
    }

    public void setGameBoardVisible(boolean ok){
        gameBoard.setVisible(ok);
    }

}
