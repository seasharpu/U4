package controller;
import javax.swing.JOptionPane;

import model.Cruiser;
import model.ShipType;


public class Main {
    public static void main(String[] args) {
        String nameOfThePlayer = JOptionPane.showInputDialog( "Your name?" );
        Controller theController = new Controller(nameOfThePlayer);
    }


}