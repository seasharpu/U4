package view;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

public class GameFinishedBoard extends JPanel{
    private MainFrame mainFrame;
    private int width;
    private int height;
    private JLabel lblTitle;
    private JLabel lblName;
    private JLabel lblRecord;
    private JButton newGameBtn;
    
    public GameFinishedBoard(int width, int height, int clicks, String nameOfThePlayer, MainFrame mainFrame){
        this.mainFrame = mainFrame;
        this.setLayout(null);
        this.width = width / 2 +60;
        this.height = height;
        this.setSize(width / 2 +60, height);
        setLocation(0,0);
        setUp(clicks, nameOfThePlayer);
        mainFrame.add(this);
    }
    
    private void setUp(int clicks, String nameOfThePlayer) {
        lblTitle = new JLabel("Endgame");
        lblTitle.setLocation(75, 23);
        lblTitle.setSize((width / 2)-100, 20);
        this.add(lblTitle);

        lblName = new JLabel("Player: " + nameOfThePlayer );
        lblName.setLocation(50, 200);
        lblName.setSize((width / 2)-100, 20);
        this.add(lblName);

        lblRecord = new JLabel("Record: " + clicks );
        lblRecord.setLocation(150, 200);
        lblRecord.setSize((width / 2)-100, 20);
        this.add(lblRecord);

        newGameBtn = new JButton("Restart");
     //   newGameBtn.setActionCommand(Integer.toString(i));
        newGameBtn.setEnabled(true);
        newGameBtn.setLocation(75, 220);
        //Set JButton font using new created font
     //   Font newButtonFont = new Font(newGameBtn.getFont().getName(),newGameBtn.getFont().getStyle(),27);
       // newGameBtn.setFont(newButtonFont);
       newGameBtn.setSize(100, 60);

        //newGameBtn.setForeground(Color.WHITE);

        //btn.setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.blue));

        newGameBtn.addActionListener(l -> mainFrame.restartButtonPressed());
        this.add(newGameBtn);
    }

}
