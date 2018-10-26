package net.Screens;


import net.*;
import net.Visuals.*;

import java.awt.*;

public class MainMenuScreen extends Screen {

    BackgroundImage backgroundImage;
    VisualLabel loadingLabel;
    BackgroundImage backgroundImage2;

    NPC npc;

    @Override
    public void init() {
        backgroundImage = new BackgroundImage("img/Map_Background_Ocean.png", 800, 600);
        background.add(backgroundImage);

        loadingLabel = new VisualLabel("Loading...", 280, 200, 50, Color.WHITE);
        foreground.add(loadingLabel);

        backgroundImage2 = new BackgroundImage("img/room1.png", 800, 600);
    }

    @Override
    public void behavior() {
        if (Main.time == 80) {
            foreground.remove(loadingLabel);
        }

        if (Main.time > 100 && Main.time < 140) {
            backgroundImage.y -= (Main.time - 100);
            if (Main.time < 118) {
                Main.player.y -= (Main.time - 100);
            }
        }

        if (Main.time == 140) {
            background.add(backgroundImage2);
            backgroundImage2.y = 1000;
        }

        if (Main.time > 140 && Main.time <= 170) {
            if (backgroundImage2.y > 0) {
                backgroundImage2.y -= Main.time - 120;
            }
            if (backgroundImage2.y < 0) {
                backgroundImage2.y = 0;
            }
        }

        if (Main.time == 170) {
            foreground.add(new MessagePopUp(450,75, "What happens when a drop is separated from the lake?", 60, false, Color.WHITE));
            Main.environment.add(new Boundary(0, 0, 25, 267));
            Main.environment.add(new Boundary(26, 0, 748, 102));
            Main.environment.add(new Boundary(774, 0, 20, 572));
            Main.environment.add(new Boundary(0,498,794,74));
            Main.environment.add(new Boundary(0,344,26,228));
            Main.environment.add(new Door(0, 267, 26, 77, new Room2(), 750, 300, true));

            npc = new NPC(-700, 300, 30, 50, Color.RED);
            Main.environment.add(npc);
            npc.plotCourse(950, 0);
        }

        if (Main.time == 280) {
            foreground.add(new MessagePopUp(0, 50, "You are alone now.", 60, false, Color.red));
        }

        if (Main.time == 350) {
            foreground.add(new MessagePopUp(0, 50, "You can't go back to the Lake.", 60, false, Color.red));
        }

        if (Main.time == 420) {
            foreground.add(new MessagePopUp(0, 50, "None of us can.", 60, false, Color.red));
        }

        if (Main.time == 495) {
            npc.plotCourse(-500, 0);
            Main.playerCanMove = true;
            foreground.add(new MessagePopUp(0, 50, "Wait!", 40, false, Main.player.color));
        }

        if (Main.time == 570) {
            foreground.add(new BackgroundImage("img/wasd.png", 260, 135));
        }
    }
}
