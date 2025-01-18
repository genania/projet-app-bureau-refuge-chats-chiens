package Refuge.View.Modal;

import Refuge.Swinger.*;

public class ModalHelp extends Modal {
    public ModalHelp() {
        super();

        setTitle("Aide");

        Icon icon = new Icon("/icones/placeholder.png", 0.05, 0.025, 0.025);

        icon.setBackground(Palette.DARK0_SOFT);
        icon.setColor(Palette.LIGHT0_SOFT);

        add(icon);

        Label title = new Label("Besoin d'aide ?", 0.2, 0.025, 0.15, 0.025);

        title.setAlign(1);

        add(title);

        String text = "Voici quelques informations utiles pour vous aider :\n\n"
                + "1. Pour toute question technique, contactez le support.\n"
                + "2. Consultez la documentation pour plus de détails.\n"
                + "3. En cas de problème urgent, appelez le 450-654-6789.\n";
        Scroll scroll = new Scroll(text, 0.05, 0.075, 0.4, 0.35);

        scroll.setFinal();

        add(scroll);
    }
}
