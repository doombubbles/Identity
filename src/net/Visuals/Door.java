package net.Visuals;


import net.Main;
import net.MovementLogic;
import net.Screens.Screen;

import java.awt.*;

public class Door extends VisualObject {

    Screen screen;
    int newX;
    int newY;
    boolean clearEnvironment;

    public Door(int x, int y, int width, int height, Screen screen, int newX, int newY, boolean clearEnvironment) {
        super(x, y, width, height);
        this.screen = screen;
        this.newX = newX;
        this.newY = newY;
        this.clearEnvironment = clearEnvironment;
        solid = false;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillOval(x-1, y-1, 2, 2);
    }

    @Override
    public void behavior() {
        if (MovementLogic.wouldOverlap(Main.player, 0, 0, this, true)) {
            Main.switchScreen(screen);
            Main.player.x = newX;
            Main.player.y = newY;

            if (clearEnvironment) {
                for (VisualObject visualObject : Main.environment) {
                    if (!(visualObject instanceof Player)) {
                        visualObject.destroyed = true;
                    }
                }
            }

        }


    }
}
