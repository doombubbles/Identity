import java.awt.*;

public class Player extends VisualObject {

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        if (Main.playerIsVisible) {
            g.setColor(Color.red);
            g.fillRect(x, y, width, height);
            g.setColor(Color.BLACK);
        }
    }

    @Override
    public void ai() {
        super.ai();

        if (Main.playerCanMove) {
            if (Main.wPressed) {
                y -= 10;
            }
            if (Main.sPressed) {
                y += 10;
            }
            if (Main.aPressed) {
                x -= 10;
            }
            if (Main.dPressed) {
                x += 10;
            }
        }
    }
}
