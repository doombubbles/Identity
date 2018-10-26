package net.Screens;

import net.Main;
import net.Visuals.BackgroundImage;
import net.Visuals.Boundary;
import net.Visuals.Door;

import javax.swing.*;

public class Room4 extends Screen {
    @Override
    public void init() {
        if (Main.decision2 == JOptionPane.YES_OPTION) {
            background.add(new BackgroundImage("img/room4_2.png", 800, 600));
            Main.environment.add(new Door(294, 146, 228, 32, new Room7(), 400, 450, true));

        } else {
            background.add(new BackgroundImage("img/room4.png", 800, 600));
            Main.environment.add(new Boundary(294, 146, 228, 32));
            Main.environment.add(new Door(774, 267, 20, 77, new Room6(), 50, 300, true));
        }


        Main.environment.add(new Boundary(0, 77, 26, 495));
        Main.environment.add(new Boundary(0, 77, 325, 101));
        Main.environment.add(new Boundary(467, 77, 328, 103));
        Main.environment.add(new Boundary(775, 179,  19, 86));
        Main.environment.add(new Boundary(776, 344, 20, 228));
        Main.environment.add(new Boundary(0, 497, 794, 75));


    }
}
