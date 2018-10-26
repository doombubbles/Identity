package net.Screens;

import net.Main;
import net.Visuals.*;

import javax.swing.*;
import java.awt.*;

public class Room1 extends Screen {

    int startTime;

    NPC npc;

    public SolidRectangle rectangle;

    @Override
    public void init() {
        startTime = Main.time;
        background.add(new BackgroundImage("img/room1.png", 800, 600));
        Main.environment.add(new Boundary(0, 0, 25, 267));
        Main.environment.add(new Boundary(26, 0, 748, 102));
        Main.environment.add(new Boundary(774, 0, 20, 572));
        Main.environment.add(new Boundary(0,498,794,74));
        Main.environment.add(new Boundary(0,344,26,228));
        Main.environment.add(new Door(0, 267, 26, 77, new Room2(), 750, 300, true));

        rectangle = new SolidRectangle(400, 300, 800, 600, new Color(0,0,0,0));
        foreground.add(rectangle);
    }

    @Override
    public void behavior() {
        if (Main.checkpoint == 7) {
            if (Main.time == startTime) {
                Main.playerCanMove = false;
                npc = new NPC(400, -1000, 30, 50, Main.tardisBlue);
                Main.environment.add(npc);
            }
            if (Main.time < startTime + 25) {
                Main.player.x += 10;
            }

            npc.y = Math.min(300, npc.y + (Main.time - startTime));

            if (Main.time == startTime + 70) {
                foreground.add(new MessagePopUp(0, 50, "You are alone now.", 60, false, Main.player.color));
            }

            if (Main.time == startTime + 140) {
                foreground.add(new MessagePopUp(0, 50, "You can't go back to the Lake.", 60, false, Main.player.color));
            }

            if (Main.time == startTime + 210) {
                foreground.add(new MessagePopUp(0, 50, "None of us can.", 60, false, Main.player.color));
            }


            if (Main.time == startTime + 300 && Main.decision1 == JOptionPane.NO_OPTION) {
                Main.player.x += 2;
            }

            if (Main.time == startTime + 302 && Main.decision1 == JOptionPane.NO_OPTION) {
                Main.player.x -= 2;
            }

            if (Main.time > startTime + 320) {
                rectangle.color = new Color(0, 0, 0, Math.min(255, rectangle.color.getAlpha() + 5));
            }

            if (Main.time == startTime + 400) {
                Main.mainFrame.setVisible(false);
                Main.mainFrame.dispose();
                System.exit(0);
            }

        }
    }
}
