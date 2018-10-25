package net.Screens;

import net.Main;
import net.Visuals.BackgroundImage;
import net.Visuals.Boundary;

import javax.swing.*;

public class Room3 extends Screen {

    boolean open;
    boolean inColorRange;

    @Override
    public void init() {
        open = false;
        inColorRange = false;
        background.add(new BackgroundImage("img/room3.png", 800, 600));

        Main.environment.add(new Boundary(0, 0, 25, 267));
        Main.environment.add(new Boundary(26, 0, 748, 102));
        Main.environment.add(new Boundary(774, 0, 20, 266));
        Main.environment.add(new Boundary(774, 344, 20, 153));
        Main.environment.add(new Boundary(439, 497, 356, 76));
        Main.environment.add(new Boundary(0, 497, 356, 76));
        Main.environment.add(new Boundary(0,344,26,228));

        Main.environment.add(new Boundary(0, 0, 25, 267));

    }

    @Override
    public void behavior() {
        if (Main.player.x > 370 && Main.player.x < 425 && Main.player.y < 180) {
            inColorRange = true;
        } else  {
            inColorRange = false;
        }
        if (!inColorRange) {
            open = false;
        }

        if (inColorRange && !open) {
            open = true;
            Main.playerCanMove = false;
            Main.doTick = false;
            Main.player.color = JColorChooser.showDialog(null, "Choose your new color", Main.player.color);
            Main.doTick = true;
            Main.playerCanMove = true;
            Main.player.x = 400;
            Main.player.y = 200;
        }

    }
}
