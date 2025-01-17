
package Refuge.View.Modal;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Refuge.Model.Animal;
import Refuge.Swinger.*;

public class ModalAnimal extends Modal {
    Animal animal;

    public ModalAnimal(Animal animal) {
        super();

        this.animal = animal;

        setTitle(animal.getNom());
        setBounds(new Frame(0.1, 0.1, 0.8, 0.8).toRectangle());

        JPanel box = new JPanel();

        box.setBounds(new Frame(0.4, 0.2, 0.3, 0.3).toRectangle());
        box.setLayout(null);
        box.setBackground(Palette.ORANGE);

        Photo picture = new Photo("/" + animal.getCheminPhotos().get(0), 0.0, 0.0, 1.0, 1.0);

        int pictureWidth = picture.getWidth();
        int pictureHeight = picture.getHeight();

        Dimension coverDimensions = calculateCoverDimensions(
                box.getWidth(), box.getHeight(),
                pictureWidth, pictureHeight);

        int pictureX = (box.getWidth() - coverDimensions.width) / 2;
        int pictureY = (box.getHeight() - coverDimensions.height) / 2;

        picture.setBounds(pictureX, pictureY, coverDimensions.width, coverDimensions.height);

        // add(picture);
        box.add(picture);

        add(box);

        try {
            BufferedImage preview = ImageIO.read(getClass().getResourceAsStream("/" + animal.getCheminPhotos().get(0)));
            System.out.println(preview);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // int index = 0;
        // List<String> paths = animal.getCheminPhotos();
        //
        // for (String path : paths) {
        // JPanel preview = new JPanel();
        //
        // preview.setBounds(new Frame(0.05 + index * 0.11, 0.4, 0.1,
        // 0.1).toRectangle());
        // preview.setLayout(null);
        // preview.setBackground(Palette.ORANGE);
        //
        // //// Photo miniature = new Photo("/" + animal.getCheminPhotos().get(0), 0.0,
        // //// 0.0,
        // //// 1.0, 1.0);
        // //
        // // miniature.setHoverColor(Palette.ORANGE);
        // //
        // // int miniatureWidth = picture.getWidth();
        // // int miniatureHeight = picture.getHeight();
        // //
        // // Dimension miniatureDimensions = calculateCoverDimensions(
        // // preview.getWidth(), preview.getHeight(),
        // // miniatureWidth, miniatureHeight);
        // //
        // // int miniatureX = (preview.getWidth() - miniatureDimensions.width) / 2;
        // // int miniatureY = (preview.getHeight() - miniatureDimensions.height) / 2;
        // //
        // // picture.setBounds(miniatureX, miniatureY, miniatureDimensions.width,
        // // miniatureDimensions.height);
        // //
        // // preview.add(miniature);
        // //
        // add(preview);
        //
        // index++;
        // }

        // addMiniatures();
    }

    private void addMiniatures() {

        double PHOTO_RATIO_WIDTH = 0.35;
        double PHOTO_RATIO_HEIGHT = 0.45;
        double INFO_RATIO_WIDTH = 0.4;
        double INFO_RATIO_HEIGHT = 0.6;
        double THUMBNAIL_SIZE = 0.07;
        int THUMBNAIL_SPACING = 10;
        // Conteneur pour les miniatures
        Frame thumbnailFrame = new Frame(0.1, 0.4, PHOTO_RATIO_WIDTH, 0.25);
        JPanel thumbnailsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, THUMBNAIL_SPACING, 0)); // Alignement en
                                                                                                    // haut
        thumbnailsPanel.setBounds(thumbnailFrame.toRectangle());
        thumbnailsPanel.setBackground(Palette.DARK1);

        // Création des miniatures
        // List<String> photos = animal.getCheminPhotos();
        //
        // for (String photoPath : photos) {
        // JLabel thumbnail = createScaledImageLabel(
        // photoPath,
        // getSize().width * THUMBNAIL_SIZE,
        // getSize().width * THUMBNAIL_SIZE);
        //
        // if (thumbnail != null) {
        // thumbnail.setBorder(BorderFactory.createLineBorder(Palette.LIGHT0_SOFT, 1));
        // // thumbnail.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //
        // //// Référence finale pour le lambda
        // // final String finalPhotoPath = photoPath;
        // // thumbnail.addMouseListener(new java.awt.event.MouseAdapter() {
        // // @Override
        // // public void mouseClicked(java.awt.event.MouseEvent evt) {
        // // JLabel newMainImage = createScaledImageLabel(
        // // finalPhotoPath,
        // // window.getSize().width * PHOTO_RATIO_WIDTH,
        // // window.getSize().height * PHOTO_RATIO_HEIGHT);
        // // if (newMainImage != null) {
        // // photoContainer.removeAll();
        // // newMainImage.setBounds(0, 0, photoFrame.toRectangle().width,
        // // photoFrame.toRectangle().height);
        // // photoContainer.add(newMainImage);
        // // photoContainer.revalidate();
        // // photoContainer.repaint();
        // // }
        // // }
        // // });
        //
        // thumbnailsPanel.add(thumbnail);
        // }
        // }

        // Ajoutez le panneau au conteneur principal
        add(thumbnailsPanel);

    }

    private Dimension calculateCoverDimensions(int containerWidth, int containerHeight, int imageWidth,
            int imageHeight) {
        double containerRatio = (double) containerWidth / containerHeight;
        double imageRatio = (double) imageWidth / imageHeight;

        int resultWidth, resultHeight;

        if (imageRatio > containerRatio) {
            // Image is wider than container proportionally - scale based on height
            resultHeight = containerHeight;
            resultWidth = (int) (containerHeight * imageRatio);
        } else {
            // Image is taller than container proportionally - scale based on width
            resultWidth = containerWidth;
            resultHeight = (int) (containerWidth / imageRatio);
        }

        return new Dimension(resultWidth, resultHeight);
    }

    private static JLabel createScaledImageLabel(String imagePath, double maxWidth, double maxHeight) {
        try {
            System.out.println("Chargement de l'image : " + imagePath);
            java.net.URL imageUrl = ModalAnimal.class.getClassLoader().getResource(imagePath);
            if (imageUrl == null) {
                System.err.println("Image introuvable dans le classpath : " + imagePath);
                return null;
            }

            ImageIcon originalIcon = new ImageIcon(imageUrl);
            int originalWidth = originalIcon.getIconWidth();
            int originalHeight = originalIcon.getIconHeight();

            // Calculez le ratio tout en respectant les dimensions maximales
            double ratio = Math.min(maxWidth / originalWidth, maxHeight / originalHeight);
            int newWidth = (int) (originalWidth * ratio);
            int newHeight = (int) (originalHeight * ratio);
            System.out.println("Dimensions redimensionnées : " + newWidth + "x" + newHeight);

            // Redimensionnez l'image
            Image scaledImage = originalIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            // Créez le JLabel et centrez-le dans son conteneur
            JLabel label = new JLabel(new ImageIcon(scaledImage));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            return label;
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement de l'image : " + imagePath);
            e.printStackTrace();
            return null;
        }
    }
}
