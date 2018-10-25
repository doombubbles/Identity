package net.Screens;


import net.*;
import net.Visuals.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Screen extends JPanel {

    public List<VisualObject> background;

    public List<VisualObject> foreground;

    public Screen() {
        setVisible(true);
        background = new ArrayList<>();

        foreground = new ArrayList<>();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (VisualObject visualObject : background) {
            visualObject.draw(g);
        }
        for (VisualObject visualObject : Main.environment) {
            visualObject.draw(g);
        }
        for (VisualObject visualObject : foreground) {
            visualObject.draw(g);
        }
    }

    public void behavior() {

    }

    public void init() {

    }
}
