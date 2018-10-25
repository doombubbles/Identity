package net.Screens;


import net.*;
import net.Visuals.*;

import java.awt.*;

public class MainMenuScreen extends Screen {

    BackgroundImage backgroundImage;
    VisualLabel loadingLabel;
    BackgroundImage backgroundImage2;

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
            } else {
                backgroundImage2.y = 0;
            }
        }

        if (Main.time == 170) {
            Main.playerCanMove = true;
            foreground.add(new MessagePopUp(450,75, "What happens when a drop is separated from a lake?", 60, false, Color.WHITE));
            Main.environment.add(new Boundary(0, 0, 25, 267));
            Main.environment.add(new Boundary(26, 0, 748, 102));
        }


    }
}
