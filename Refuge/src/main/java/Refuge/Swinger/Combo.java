package Refuge.Swinger;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

import java.awt.*;

public class Combo extends JComboBox<String> {

  public Combo(String[] options, double x, double y, double width, double height) {
    for (String option : options) {
      addItem(option);
    }
    customize(new Frame(x, y, width, height));
  }

  private void customize(Frame frame) {
    setBounds(frame.toRectangle());
    setFont(Text.MEDIUM_TEXT);
    setUI(new BasicComboBoxUI() {
      @Override
      protected JButton createArrowButton() {
        JButton button = new JButton() {
          @Override
          public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

            // Background
            g2.setColor(Palette.DARK3);
            g2.fillRect(0, 0, getWidth(), getHeight());

            // Arrow
            g2.setColor(Palette.DARK2);
            int w = getWidth();
            int h = getHeight();
            int size = h / 2; // arrow size
            int x = (w - size) / 2;
            int y = (h - size / 2) / 2;

            int[] xPoints = { x, x + size / 2, x + size };
            int[] yPoints = { y, y + size / 2, y };
            g2.fillPolygon(xPoints, yPoints, 3);
          }
        };
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        return button;
      }

      @Override
      public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
        // This changes the background when no option is selected
        g.setColor(getSelectedItem() == null ? Palette.DARK2 : Palette.DARK3);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        super.paintCurrentValue(g, bounds, hasFocus);
      }
    });
    setRenderer(new DefaultListCellRenderer() {
      @Override
      public Component getListCellRendererComponent(JList<?> list, Object value,
          int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value == null || value.toString().isEmpty()) {
          setBackground(Palette.RED); // Color for empty state
          setForeground(Palette.LIGHT0);
        } else if (isSelected) {
          setBackground(Palette.ORANGE);
          setForeground(Palette.LIGHT0);
        } else {
          setBackground(Palette.DARK2);
          setForeground(Palette.LIGHT0);
        }
        return this;
      }
    });
    setEditable(false);
    setBackground(Palette.DARK3);
    setForeground(Palette.LIGHT0);
    setBorder(BorderFactory.createEmptyBorder());
    setFocusable(false);
  }
}
