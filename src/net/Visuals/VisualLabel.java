package net.Visuals;


import java.awt.*;

public class VisualLabel extends VisualObject {

    String string;
    int size;
    Color color;

    public VisualLabel(String text, int x, int y, int size, Color color) {
        super(x, y, 0, 0);
        string = text;
        this.size = size;
        this.color = color;
        solid = false;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.setFont(new Font("", Font.PLAIN, size));
        g.setColor(color);
        g.drawString(string, x, y);
        g.setFont(new Font("", Font.PLAIN, 12));
        g.setColor(Color.BLACK);
    }
}
