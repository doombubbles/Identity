package net.Screens;

import java.awt.*;
import net.*;
import net.Visuals.*;

public class TestNewScreen extends Screen {

    @Override
    public void init() {
        Main.environment.add(new SolidRectangle(100, 500, 50, 50, Color.BLACK));
    }
}
