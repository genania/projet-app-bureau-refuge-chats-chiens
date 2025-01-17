package Refuge.View.Page;

import Refuge.Swinger.*;
import Refuge.View.Bar.BarEmployer;

public class PageEmployee extends PageBase {

    public static void open(Window window) {
        window.setBar(new BarEmployer());
        window.showBar();

        showAnimal(window, () -> loadAnimals());

        window.revalidate();
        window.repaint();
    }
}
