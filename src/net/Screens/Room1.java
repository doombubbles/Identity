package net.Screens;

import net.Main;
import net.Visuals.BackgroundImage;
import net.Visuals.Boundary;
import net.Visuals.Door;

public class Room1 extends Screen {

    @Override
    public void init() {
        background.add(new BackgroundImage("img/room1.png", 800, 600));
        Main.environment.add(new Boundary(0, 0, 25, 267));
        Main.environment.add(new Boundary(26, 0, 748, 102));
        Main.environment.add(new Boundary(774, 0, 20, 572));
        Main.environment.add(new Boundary(0,498,794,74));
        Main.environment.add(new Boundary(0,344,26,228));
        Main.environment.add(new Door(0, 267, 26, 77, new Room2(), 750, 300, true));
    }
}
