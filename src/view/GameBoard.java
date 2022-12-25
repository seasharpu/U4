package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JPanel{
    private int width;
    private int height;

    private MainFrame mainFrame;

    private JLabel titleTotalClicks;
    private JLabel titleShipSunk;

    public GameBoard(int width, int height, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        setLocation(0, 0);
        setUp();
    }

    private void setUp() {
        titleTotalClicks = new JLabel("Clicks: ");
        titleTotalClicks.setLocation(20, 400);
        titleTotalClicks.setSize(width/2, 20);
        this.add(titleTotalClicks);

        titleShipSunk = new JLabel("Ships sunk: ");
        titleShipSunk.setLocation(140, 400);
        titleShipSunk.setSize(width/2, 20);
        this.add(titleShipSunk);
    }
}
