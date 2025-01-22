package com.Recursos.Modifiers;

import javax.swing.border.AbstractBorder;
import java.awt.*;

public class RoundBorder extends AbstractBorder {
    private int radius;
    private Color color = Color.BLACK;
    private int thickness = 2;

    public RoundBorder(int radius) {this.radius = radius;}
    public RoundBorder(int radius, Color color,int thickness) {this.thickness = thickness;this.radius = radius; this.color = color;}
//Dibuja el Borde
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(color); // Color del borde
        g2d.setStroke(new BasicStroke(thickness)); // Grosor del borde
        g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(5, 5, 5, 5);
    }
}
