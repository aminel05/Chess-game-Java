package chess;

import javax.swing.*;
import java.awt.*;

public class CustomBackgroundLabel extends JLabel {
    private final Color backgroundColor;
    private final String labelText;

    public CustomBackgroundLabel(String text, Color backgroundColor) {
        super();
        this.labelText = text;
        this.backgroundColor = backgroundColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Calculate the width of the text
        FontMetrics metrics = g.getFontMetrics(getFont());
        int textWidth = metrics.stringWidth(labelText);

        // Set the background color for the specified portion
        g.setColor(backgroundColor);
        g.fillRect(0, 0, textWidth, getHeight());

        // Draw the text
        g.setColor(getForeground());
        g.drawString(labelText, 0, getHeight() - metrics.getDescent());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom Background Label Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 100);

            // Create a custom label with blue background for part of the text
            CustomBackgroundLabel customLabel = new CustomBackgroundLabel("Colored Text", Color.BLUE);
            customLabel.setForeground(Color.WHITE); // Set text color
            frame.add(customLabel);

            frame.setVisible(true);
        });
    }
}