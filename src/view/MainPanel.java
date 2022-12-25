package view;

import javax.swing.JPanel;

public class MainPanel extends JPanel{
    private GameBoard gameBoard;
    private ScoreBoard scoreBoard;

    public MainPanel(int width, int height, MainFrame mainFrame) {
        super(null);
        this.setSize(width, height);

        gameBoard = new GameBoard(width / 2 +60, height, mainFrame);
        add(gameBoard);

        scoreBoard = new ScoreBoard(width / 2 +70, height, mainFrame);
        add(scoreBoard);
    }

    protected GameBoard getGameBoard() {
        return gameBoard;
    }

    protected ScoreBoard getScoreBoard() {
        return scoreBoard;
    }
}
