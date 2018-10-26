package net.Screens;

import net.Main;
import net.Visuals.*;

import java.awt.*;

public class Room5 extends Screen {

    public SolidRectangle rectangle;

    @Override
    public void init() {
        background.add(new BackgroundImage("img/room5.png", 800, 600));
        Main.environment.add(new Boundary(0, 0, 25, 600));


        Main.environment.add(new Boundary(439, 0, 356, 104));
        Main.environment.add(new Boundary(0, 0, 356, 104));

        Main.environment.add(new Boundary(774, 0, 20, 572));

        Main.environment.add(new Boundary(0,498,794,74));


        Main.environment.add(new NPC(150, 225, 30, 50, Color.ORANGE));
        Main.environment.add(new NPC(150, 392, 30, 50, Color.PINK));
        Main.environment.add(new NPC(650, 225, 30, 50, Color.BLACK));

        Main.environment.add(new Door(356, 0, 83, 23, new Room3(), 400, 450, true));

        rectangle = new SolidRectangle(400, 300, 800, 600, new Color(0,0,0,0));
        foreground.add(rectangle);
    }


    @Override
    public void behavior() {
        if (Main.checkpoint == 4) {
            if (Main.player.x > 608 && Main.player.x < 608 + 77 && Main.player.y > 369 && Main.player.y < 369 + 46) {
                Main.player.x = 650;
                Main.player.y = 392;
                Main.playerCanMove = false;
                rectangle.color = new Color(0, 0, 0, Math.min(255, rectangle.color.getAlpha() + 3));
            }
            if (rectangle.color.getAlpha() == 255) {
                Main.checkpoint = 5;
            }
        }
        if (Main.checkpoint == 5) {
            if (rectangle.color.getAlpha() == 255) {
                foreground.add(new MessagePopUp(450, 50, "*you hear a noise clattering in the distance*", 60, false, Color.WHITE));
            }

            rectangle.color = new Color(0, 0, 0, Math.max(0, rectangle.color.getAlpha() - 1));
            if (rectangle.color.getAlpha() < 150) {
                rectangle.color = new Color(0, 0, 0, Math.max(0, rectangle.color.getAlpha() - 4));

                Main.playerCanMove = true;
            }

            if (rectangle.color.getAlpha() == 0) {
                Main.checkpoint = 6;
            }
        }
    }
}
