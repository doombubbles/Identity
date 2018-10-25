package net.Visuals;


import net.Main;

import java.awt.*;

public class MessagePopUp extends VisualObject {

    String text;
    int timeLeft;
    boolean blockInput;
    Color textColor;

    public MessagePopUp(int y, int height, String text, int timeLeft, boolean blockInput, Color textColor) {
        super(0, y, 800, height);
        this.text = text;
        this.timeLeft = timeLeft;
        this.blockInput = blockInput;
        solid = false;
        this.textColor = textColor;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        g.setColor(Color.darkGray);
        g.fillRoundRect(x + 25, y + 25, width - 50, height, 10, 10);
        g.setColor(textColor);
        g.setFont(new Font("", Font.BOLD, 20));
        g.drawString(text, x + 50, y + 50);

        g.setColor(Color.BLACK);

    }

    @Override
    public void behavior() {
        timeLeft--;
        if (blockInput) {
            Main.playerCanMove = false;
        }
        if (timeLeft == 0 || Main.spacePressed) {
            destroyed = true;
            if (blockInput) {
                Main.playerCanMove = true;
            }
            if (Main.spacePressed) {
                Main.spacePressed = false;
            }
        }
    }
}
