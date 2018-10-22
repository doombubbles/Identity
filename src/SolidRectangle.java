import java.awt.*;

public class SolidRectangle extends VisualObject {

    public Color color;

    public SolidRectangle(int x, int y, int width, int height, Color c) {
        super(x, y, width, height);
        this.color = c;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
    }
}
