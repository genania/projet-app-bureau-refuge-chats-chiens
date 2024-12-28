package Refuge.View.Page;

import Refuge.Swinger.*;
import Refuge.View.Bar.BarVisitor;

public class PageDog extends PageBase {

    public static void open(Window window) {
        window.setBar(new BarVisitor());
        window.showBar(); // Afficher la barre
        showAnimal(window, () -> loadDog());
        window.revalidate();
        window.repaint();
    }

}
