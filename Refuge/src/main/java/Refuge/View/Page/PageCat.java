package Refuge.View.Page;

import java.util.List;
import Refuge.Model.Animal;
import Refuge.Swinger.Window;
import Refuge.View.Bar.BarAdmin;
import Refuge.View.Bar.BarVisitor;
import Refuge.Model.RequeteSql;
import Refuge.Swinger.Label;

public class PageCat extends PageBase {

    public static void open(Window window) {
        window.setBar(new BarVisitor());
        window.showBar(); // Afficher la barre
        showAnimal(window, () -> loadCat());
        window.revalidate();
        window.repaint();
    }
}
