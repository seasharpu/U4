package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JPanel{
    private int width;
    private int height;

    private MainFrame mainFrame;
    private JPanel btnsPanel;

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

        //creates the label of amount clicks
        titleTotalClicks = new JLabel("Clicks: ");
        titleTotalClicks.setLocation(20, 435);
        titleTotalClicks.setSize(width/2, 20);
        this.add(titleTotalClicks);

        titleShipSunk = new JLabel("Ships sunk: ");
        titleShipSunk.setLocation(140, 435);
        titleShipSunk.setSize(width/2, 20);
        this.add(titleShipSunk);

 
        //Creates the panel for the shipsButtons
        btnsPanel = new JPanel();
        //Creates the 10x10 gridlayout for buttons
        btnsPanel.setLayout(new GridLayout(10,10));

        btnsPanel.setSize(width-100, height-100);
        btnsPanel.setLocation(20, 23);
        this.add(btnsPanel);


        for (int i = 1; i <= 100; i++) {
            JButton btn;
        
            btn = new JButton();
            btn.setEnabled(true);
            btn.setSize(0, 0);
            //btn.setLocation(20, 23);
            //btn.addActionListener(l -> mainFrame.buttonPressed(i));
            //this.add(btn);
            btnsPanel.add(btn);
        }
    }


    protected void setAmountClicks(String labelText){
        titleTotalClicks.setText(labelText);
    }

    protected void setAmountShipSunk(String labelText){
        titleShipSunk.setText(labelText);
    }
}
