package Refuge.View.Modal;

import Refuge.Swinger.*;

public class ModalContact extends Modal {
    private static Field courriel = new Field("", 0.025, 0.1625, 0.15, 0.025);
    private static Scroll message = new Scroll("", 0.025, 0.225, 0.45, 0.15);

    public ModalContact() {
        super();
        setTitle("Nous contacter");

        // Icon icon = new Icon("/icones/placeholder2.png", 0.05, 0.025, 0.025);
        //
        // icon.setBackground(Palette.DARK0_SOFT);
        // icon.setColor(Palette.LIGHT0_SOFT);
        //
        // add(icon);

        Label phone = new Label("Nous appeler :", 0.025, 0.025, 0.3, 0.025);
        phone.setForeground(Palette.LIGHT1);

        add(phone);

        Label number = new Label("514-254-7131", 0.025, 0.0625, 0.3, 0.025);

        add(number);

        Label send = new Label("Nous écrire :", 0.025, 0.1, 0.3, 0.025);
        send.setForeground(Palette.LIGHT1);

        add(send);

        Label mail = new Label("Votre courriel", 0.025, 0.1375, 0.15, 0.025);

        add(mail);
        add(courriel);

        Label post = new Label("Votre message", 0.025, 0.2, 0.1, 0.025);

        add(post);
        add(message);

        Button button = new Button("Envoyer", 0.025, 0.4, 0.1, 0.025);

        add(button);
    }
}
