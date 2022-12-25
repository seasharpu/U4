package controller;
import model.Cruiser;
import model.ShipType;
import view.MainFrame;


public class Controller {
    private MainFrame view;
    
      public Controller() {
        view = new MainFrame(1200, 500, this);

        //view.enableAllButtons();
        //view.disableAddMenuButton();
        //view.disableViewSelectedOrderButton();
    }
}
