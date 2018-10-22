import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Screen extends JPanel {

    public List<VisualObject> background;

    public Screen() {
        setVisible(true);
        background = new ArrayList<>();
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
    }
}
