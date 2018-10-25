package net.Screens;


import net.*;
import net.Visuals.*;

import java.awt.*;

public class MainMenuScreen extends Screen {

    BackgroundImage backgroundImage;
    VisualLabel loadingLabel;
    VisualObjectGroup backgroundImage2 = new VisualObjectGroup();

    @Override
    public void init() {
        backgroundImage = new BackgroundImage("Map_Background_Ocean.png", 800, 600);
        background.add(backgroundImage);

        loadingLabel = new VisualLabel("Loading...", 280, 200, 50, Color.WHITE);
        foreground.add(loadingLabel);

        backgroundImage2.add(new SolidRectangle(400, 1000, 800, 650, new Color(100,70,0)));
    }

    @Override
    public void behavior() {
        if (Main.time == 80) {
            foreground.remove(loadingLabel);
        }

        if (Main.time > 100 && Main.time < 140) {
            backgroundImage.y -= (Main.time - 100);
            if (Main.time < 120) {
                Main.player.y -= (Main.time - 100);
            }
        }

        if (Main.time == 140) {
            backgroundImage2.addTo(background);
        }
        if (Main.time > 140 && Main.time < 163) {
            backgroundImage2.changePos(0, -1 * (Main.time - 120));
        }

        if (Main.time == 170) {
            foreground.add(new MessagePopUp(450,75, "What happens when a drop is separated from a lake?", 60, false, Color.WHITE));

        }
    }
}
