package Refuge.Swinger;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.InputStream;

public class Text {
  // Base scale factor (can be adjusted)
  private static final float BASE_SCALE = 1.0f;

  // Get screen resolution factor
  private static final double SCALE_FACTOR = calculateScaleFactor();

  // Dynamic font sizes based on screen resolution
  public static final float SMALL = Math.round(12f * SCALE_FACTOR);
  public static final float MEDIUM = Math.round(14f * SCALE_FACTOR);
  public static final float LARGE = Math.round(16f * SCALE_FACTOR);
  public static final float XLARGE = Math.round(20f * SCALE_FACTOR);

  // Load and create the main font
  public static final Font MAIN = loadFont();

  // Derived fonts with dynamic sizing
  public static final Font SMALL_TEXT = MAIN.deriveFont(SMALL);
  public static final Font MEDIUM_TEXT = MAIN.deriveFont(MEDIUM);
  public static final Font LARGE_TEXT = MAIN.deriveFont(LARGE);
  public static final Font XLARGE_TEXT = MAIN.deriveFont(XLARGE);
  public static final Font BOLD = MAIN.deriveFont(Font.BOLD).deriveFont(MEDIUM);
  public static final Font ITALIC = MAIN.deriveFont(Font.ITALIC).deriveFont(MEDIUM);

  // Private constructor to prevent instantiation
  private Text() {
  }

  // Calculate scale factor based on screen resolution
  private static double calculateScaleFactor() {
    DisplayMode displayMode = GraphicsEnvironment
        .getLocalGraphicsEnvironment()
        .getDefaultScreenDevice()
        .getDisplayMode();

    // Get screen dimensions and resolution
    int width = displayMode.getWidth();
    int height = displayMode.getHeight();
    double diagonal = Math.sqrt(width * width + height * height);

    // Base scale on common resolutions
    // 1920x1080 = 2203 diagonal pixels (common baseline)
    double baselineDiagonal = 2203;
    double scaleFactor = (diagonal / baselineDiagonal) * BASE_SCALE;

    // Clamp the scale factor to reasonable limits
    scaleFactor = Math.max(0.75, Math.min(scaleFactor, 1.5));

    // System.out.println("Screen resolution: " + width + "x" + height);
    // System.out.println("Scale factor: " + scaleFactor);

    return scaleFactor;
  }

  // Load font from resources
  private static Font loadFont() {
    try {
      InputStream is = Text.class.getResourceAsStream("/JetBrainsMono-Medium.ttf");
      if (is == null) {
        System.err.println("Could not load JetBrains Mono font file");
        return new Font("Monospaced", Font.PLAIN, (int) MEDIUM);
      }
      Font baseFont = Font.createFont(Font.TRUETYPE_FONT, is);
      return baseFont.deriveFont(MEDIUM);
    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
      return new Font("Monospaced", Font.PLAIN, (int) MEDIUM);
    }
  }

  // Get a dynamically sized font
  public static Font getScaledFont(float size) {
    return MAIN.deriveFont(Math.round(size * SCALE_FACTOR));
  }

  // Set global font for all components
  public static void setGlobalFont() {
    FontUIResource fontResource = new FontUIResource(MAIN);

    // Set default font for all components
    for (Object key : UIManager.getDefaults().keySet()) {
      Object value = UIManager.get(key);
      if (value instanceof FontUIResource) {
        UIManager.put(key, fontResource);
      }
    }

    // Set specific component fonts with scaled sizes
    UIManager.put("Button.font", new FontUIResource(MEDIUM_TEXT));
    UIManager.put("Label.font", new FontUIResource(MEDIUM_TEXT));
    UIManager.put("TextField.font", new FontUIResource(MEDIUM_TEXT));
    UIManager.put("TextArea.font", new FontUIResource(MEDIUM_TEXT));
    UIManager.put("ComboBox.font", new FontUIResource(MEDIUM_TEXT));
    UIManager.put("MenuBar.font", new FontUIResource(MEDIUM_TEXT));
    UIManager.put("MenuItem.font", new FontUIResource(MEDIUM_TEXT));
    UIManager.put("Menu.font", new FontUIResource(MEDIUM_TEXT));
  }

  // Method to get component-specific scaled size
  public static float getScaledSize(Component component, float baseSize) {
    // Get the component's graphics configuration
    GraphicsConfiguration gc = component.getGraphicsConfiguration();
    if (gc != null) {
      // Get the transform for this specific screen
      AffineTransform transform = gc.getDefaultTransform();
      double scaleX = transform.getScaleX();
      double scaleY = transform.getScaleY();

      // Use the larger scale factor
      double localScale = Math.max(scaleX, scaleY);
      return Math.round(baseSize * localScale * BASE_SCALE);
    }
    // Fall back to global scale if no specific configuration
    return Math.round(baseSize * SCALE_FACTOR);
  }
}
