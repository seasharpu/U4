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
        this.setLocation(100,100);
        this.mainPanel = new MainPanel(width, height, this);
        this.setContentPane(mainPanel);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void buttonPressed(JButton btn) {
        controller.buttonPressed(btn);
    }

    public void restartButtonPressed(){
        controller.restartGame();
    }

    public void setPlayerName(String playerName){
        mainPanel.getGameBoard().setPlayerName(playerName);
    }

    public void setClicks(String newText){
        mainPanel.getGameBoard().setAmountClicks(newText);
    }

    public void setSunkShips(String newText){
        mainPanel.getGameBoard().setAmountShipSunk(newText);
    }

    public void updateGameBoard(boolean ok){
        mainPanel.setGameBoardVisible(ok);
    }

    public void updateScoreboard(String[] scoreboard){
        mainPanel.getScoreBoard().populateScoreBoardList(scoreboard);
    }
}
