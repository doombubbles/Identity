package net.Screens;

import net.Main;
import net.Visuals.BackgroundImage;
import net.Visuals.Boundary;
import net.Visuals.MessagePopUp;
import net.Visuals.SolidRectangle;

import javax.swing.*;
import java.awt.*;

public class Room7 extends Screen {

    int laps = 0;

    public SolidRectangle rectangle;

    @Override
    public void init() {

        if (Main.decision1 == JOptionPane.YES_OPTION) {
            foreground.add(new MessagePopUp(450, 50, "What you seek is above you, but you may not like what you find.", 60, false, Color.white));
        } else {
            foreground.add(new MessagePopUp(450, 50, "What you seek is above you.", 60, false, Color.white));
        }
        Main.environment.add(new Boundary(-2, -2, 2, 1000));
        Main.environment.add(new Boundary(800, -2, 2, 1000));
        Main.environment.add(new Boundary(0, 600, 1000, 1000));

        rectangle = new SolidRectangle(400, 300, 800, 600, new Color(0,0,0,0));
        foreground.add(rectangle);
    }

    @Override
    public void behavior() {
        if (Main.player.y == 0) {
            if (laps == 2) {
                background.add(new BackgroundImage("img/Map_Background_Ocean.png", 800, 600));
            } else {
                Main.player.y = 550;
                laps++;
            }

        }

        if (!background.isEmpty()) {
            laps++;
            if(Main.decision1 == JOptionPane.YES_OPTION) {
                if (laps == 20) {
                    foreground.add(new MessagePopUp(0, 50, "Yes!", 40, false, Main.player.color));
                }

                if (laps == 65) {
                    foreground.add(new MessagePopUp(0, 50, "Guys, it's me!", 60, false, Main.player.color));
                }

                if (laps == 130) {
                    foreground.add(new MessagePopUp(0, 50, "Don't you recognize me?", 60, false, Main.player.color));
                }

                if (laps == 220) {
                    foreground.add(new MessagePopUp(0, 50, "Guys?", 60, false, Main.player.color));
                }

                if (laps > 300) {
                    rectangle.color = new Color(0, 0, 0, Math.min(255, rectangle.color.getAlpha() + 5));
                }
                if (laps == 400) {
                    Main.mainFrame.setVisible(false);
                    Main.mainFrame.dispose();
                    System.exit(0);
                }

            } else {
                Main.playerCanMove = false;
                if (laps > 50 && laps < 100) {
                    Main.player.y -= 3;
                    Main.player.color = new Color(Main.player.color.getRed(), Main.player.color.getGreen(), Main.player.color.getBlue(), (int)(Main.player.color.getAlpha() / 1.1f));
                }
                if (laps > 200) {
                    rectangle.color = new Color(0, 0, 0, Math.min(255, rectangle.color.getAlpha() + 5));
                }
                if (laps == 300) {
                    Main.mainFrame.setVisible(false);
                    Main.mainFrame.dispose();
                    System.exit(0);
                }

            }


        }
    }
}
