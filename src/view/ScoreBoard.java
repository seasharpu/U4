package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class ScoreBoard extends JPanel {
    private MainFrame mainFrame;
    private int width;
    private int height;
    private JLabel lblTitle;

    private JList<Object> scoreBoardList;

    public ScoreBoard(int width, int height, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        setLocation(width, 15);
        setUp();
    }

    /**
     * Sets up the scoreboard GUI panel
     */
    private void setUp() {
        lblTitle = new JLabel("Scoreboard");
        lblTitle.setLocation(230, 0);
        lblTitle.setSize((width / 2) - 100, 20);
        this.add(lblTitle);

        scoreBoardList = new JList<>();
        scoreBoardList.setBackground(Color.DARK_GRAY);
        scoreBoardList.setForeground(Color.white);
        scoreBoardList.setLocation(0, 23);
        scoreBoardList.setSize(width - 140, height);
        this.add(scoreBoardList);
    }

    protected void populateScoreBoardList(String[] scoreBoardArray) {
        scoreBoardList.setListData(scoreBoardArray);
    }
}
