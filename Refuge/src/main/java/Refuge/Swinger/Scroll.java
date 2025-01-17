package Refuge.Swinger;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class Scroll extends JScrollPane {
  JTextArea text = new JTextArea(20, 30);

  public Scroll(String string, double x, double y, double width, double height) {
    setBounds(new Frame(x, y, width, height).toRectangle());
    setBorder(BorderFactory.createLineBorder(Palette.GREEN, 4));

    text.setFont(Text.MEDIUM_TEXT);
    text.setBackground(Palette.DARK3);
    text.setForeground(Palette.LIGHT0);
    text.setLineWrap(true);
    text.setWrapStyleWord(true);
    text.setText(string);

    setViewportView(text);

    JComponent view = (JComponent) getViewport().getView();

    view.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

    JScrollBar verticalBar = getVerticalScrollBar();

    verticalBar.setPreferredSize(new Size(0.01, 0.0).toDimension()); // Set scrollbar width
    verticalBar.setUI(new BasicScrollBarUI() {
      @Override
      protected void configureScrollBarColors() {
        this.thumbColor = Palette.BRIGHT_GREEN;
        this.trackColor = Palette.GREEN;
      }

      @Override
      protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
      }

      @Override
      protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
      }

      private JButton createZeroButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0));
        button.setMinimumSize(new Dimension(0, 0));
        button.setMaximumSize(new Dimension(0, 0));
        return button;
      }

      @Override
      protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        if (isDragging) {
          g.setColor(Palette.YELLOW);
        } else if (isThumbRollover()) {
          g.setColor(Palette.BLUE);
        } else {
          g.setColor(thumbColor);
        }

        g.fillRect(thumbBounds.x, thumbBounds.y,
            thumbBounds.width, thumbBounds.height);
      }

      @Override
      protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(trackColor);
        g.fillRect(trackBounds.x, trackBounds.y,
            trackBounds.width, trackBounds.height);
      }
    });
  }

  public Scroll(JPanel panel, double x, double y, double width, double height) {
    setBounds(new Frame(x, y, width, height).toRectangle());
    setBorder(BorderFactory.createEmptyBorder());
    setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    setViewportView(panel);

    JScrollBar verticalBar = getVerticalScrollBar();
    verticalBar.setUnitIncrement(16); // Default is usually 1
    verticalBar.setPreferredSize(new Size(0.01, 0.0).toDimension()); // Set scrollbar width
    verticalBar.setUI(new BasicScrollBarUI() {
      @Override
      protected void configureScrollBarColors() {
        this.thumbColor = Palette.GREEN;
        this.trackColor = Palette.DARK3;
      }

      @Override
      protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
      }

      @Override
      protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
      }

      private JButton createZeroButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0));
        button.setMinimumSize(new Dimension(0, 0));
        button.setMaximumSize(new Dimension(0, 0));
        return button;
      }

      @Override
      protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        if (isDragging) {
          g.setColor(Palette.BRIGHT_GREEN);
        } else if (isThumbRollover()) {
          g.setColor(Palette.BRIGHT_GREEN);
        } else {
          g.setColor(thumbColor);
        }

        g.fillRect(thumbBounds.x, thumbBounds.y,
            thumbBounds.width, thumbBounds.height);
      }

      @Override
      protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(trackColor);
        g.fillRect(trackBounds.x, trackBounds.y,
            trackBounds.width, trackBounds.height);
      }
    });
  }

  public void setFinal() {
    text.setEditable(false);
    setBorder(BorderFactory.createLineBorder(Palette.DARK2, 4));
  }
}
