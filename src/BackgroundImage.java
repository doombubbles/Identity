import javax.swing.*;
import java.awt.*;

public class BackgroundImage extends VisualObject {

    public Image image;

    public BackgroundImage(String s) {
        super(0, 0, 0, 0);
        this.image = new ImageIcon(s).getImage();
    }

    public BackgroundImage(String s, int width, int height) {
        super(0, 0, width, height);
        this.image = new ImageIcon(s).getImage();
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        if (width != 0 || height != 0) {
            g.drawImage(image, x, y, width, height, null);
        } else {
            g.drawImage(image, x, y, null);
        }
    }

}
