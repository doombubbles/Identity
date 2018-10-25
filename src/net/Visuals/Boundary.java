package net.Visuals;

public class Boundary extends VisualObject{

    public Boundary(int x, int y, int width, int height) {
        super(x + width/2, y + height/2, width, height);
        solid = true;
    }
}
