package view;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class ScoreBoard extends JPanel{
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
        setLocation(width, 0);
        setUp();
    }

    private void setUp() {
        lblTitle = new JLabel("Scoreboard");
        lblTitle.setLocation(240, 0);
        lblTitle.setSize((width / 2)-100, 20);
        this.add(lblTitle);

        scoreBoardList = new JList<>();
        scoreBoardList.setLocation(0, 23);
        scoreBoardList.setSize(width - 100, height -100);
        this.add(scoreBoardList);
    }

    protected void populateScoreBoardList(String[] scoreBoardArray){
        scoreBoardList.setListData(scoreBoardArray);
    }
}
