package view;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.Color;

public class GameInformation extends JPanel{
    private MainFrame mainFrame;
    private int width;
    private int height;
    private JLabel lblTitle;

    private JList<Object> gameInformationList;
    
    public GameInformation(int width, int height, MainFrame mainFrame){
        this.mainFrame = mainFrame;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        setLocation(width, 220);
        setUp();
    }
    private void setUp() {
        lblTitle = new JLabel("Game Information");
        lblTitle.setLocation(210, 0);
        lblTitle.setSize((width / 2)-100, 20);
        this.add(lblTitle);

        gameInformationList = new JList<>();
        gameInformationList.setBackground(Color.DARK_GRAY);
        gameInformationList.setLocation(-40, 23);
        gameInformationList.setSize(width - 100, height);
        this.add(gameInformationList);
    }

    protected void populateGameInformationList(String[] gameInformationArray){
        gameInformationList.setListData(gameInformationArray);
    }

}
