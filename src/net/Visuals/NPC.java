package net.Visuals;

import java.awt.*;

public class NPC extends VisualObject {

    public Color color;
    public int dx;
    public int dy;
    public int speed = 10;

    public NPC(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);

        Polygon triangle = new Polygon(new int[]{x - 15, x + 15, x},
                new int[]{y + 5, y + 5, y - 25}, 3);
        g.fillPolygon(triangle);
        g.fillOval(x - 15, y - 5, 30, 30);



        g.setColor(Color.BLACK);
    }

    public void addMovementRoute(int dx, int dy) {
        this.dx += dx;
        this.dy += dy;
    }

    @Override
    public void behavior() {
        if (dx > 0) {
            int step = Math.min(dx, speed);
            x += step;
            dx -= step;
        }
        if (dx < 0) {
            int step = Math.max(dx, speed * -1);
            x += step;
            dx -= step;
        }
        if (dy > 0) {
            int step = Math.min(dy, speed);
            y += step;
            dy -= step;
        }
        if (dy < 0) {
            int step = Math.max(dy, speed * -1);
            y += step;
            dy -= step;
        }
    }
}
