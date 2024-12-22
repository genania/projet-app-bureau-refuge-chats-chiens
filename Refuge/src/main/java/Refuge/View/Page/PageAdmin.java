package Refuge.View.Page;

import Refuge.Swinger.*;
import Refuge.View.Bar.BarAdmin;

public class PageAdmin extends PageBase {

    public static void open(Window window) {
        window.setBar(new BarAdmin());
        window.showBar(); // Afficher la barre
        showAnimal(window);
        window.revalidate();
        window.repaint();
    }

}
