package net.Screens;

import net.Main;
import net.Visuals.BackgroundImage;
import net.Visuals.Boundary;
import net.Visuals.Door;
import net.Visuals.NPC;

import java.awt.*;

public class Room2 extends Screen {

    @Override
    public void init() {
        if (Main.checkpoint == 0) {
            NPC npc = new NPC(550, 300, 30, 50, Color.red);
            Main.environment.add(npc);
            npc.addMovementRoute(-1000, 0);
            Main.checkpoint = 1;
        }
        background.add(new BackgroundImage("img/room2.png", 800, 600));
        Main.environment.add(new Boundary(0, 0, 25, 267));
        Main.environment.add(new Boundary(26, 0, 748, 102));
        Main.environment.add(new Boundary(774, 0, 20, 266));
        Main.environment.add(new Boundary(774, 344, 20, 153));
        Main.environment.add(new Boundary(0,498,794,74));
        Main.environment.add(new Boundary(0,344,26,228));
        Main.environment.add(new Door(774, 267, 26, 77, new Room1(), 50, 300, true));
        Main.environment.add(new Door(0, 267, 26, 77, new Room3(), 750, 300, true));

        Main.environment.add(new NPC(150, 150, 30, 50, Color.GREEN));
        Main.environment.add(new NPC(500, 450, 30, 50, Color.cyan));
    }
}
