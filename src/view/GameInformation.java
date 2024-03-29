package view;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;

/**
 * Class for game information panel where information will be displayed like if you sunk a ship. 
 * @author Mehmet, Alexander
 */
public class GameInformation extends JPanel {
    private MainFrame mainFrame;
    private int width;
    private int height;
    private JLabel lblTitle;

    private JList<Object> gameInformationList;

    public GameInformation(int width, int height, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        setLocation(width, 220);
        setUp();
    }

    /**
     * Sets up the gameinformation GUI panel
     */
    private void setUp() {
        lblTitle = new JLabel("Game Information");
        lblTitle.setLocation(210, 0);
        lblTitle.setSize((width / 2) - 100, 20);
        this.add(lblTitle);

        gameInformationList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(gameInformationList);

        scrollPane.setBackground(Color.DARK_GRAY);
        scrollPane.setForeground(Color.white);
        scrollPane.setLocation(-40, 23);
        scrollPane.setSize(width - 100, height);
        this.add(scrollPane);
    }

    /**
     * Updates the gameinformation panel/jlist with new information
     */
    protected void populateGameInformationList(String[] gameInformationArray) {
        gameInformationList.setListData(gameInformationArray);
    }

}
