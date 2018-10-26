package net.Visuals;

import net.Main;
import net.MovementLogic;

import java.awt.*;

public class Player extends VisualObject {

    public static int speed = 10;
    public Color color = Main.tardisBlue;

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
        solid = true;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        if (Main.playerIsVisible) {
            g.setColor(color);

            Polygon triangle = new Polygon(new int[]{x - 15, x + 15, x},
                                            new int[]{y + 7, y + 7, y - 25}, 3);
            g.fillPolygon(triangle);
            g.fillOval(x - 15, y - 5, 30, 30);



            g.setColor(Color.BLACK);
        }
    }

    @Override
    public void behavior() {
        if (Main.playerCanMove) {

            if (Main.upPressed) {
                for (int i = speed; i > 0; i--) {
                    boolean canMove = true;
                    for (VisualObject visualObject : Main.environment) {
                        if (visualObject instanceof Player) {
                            continue;
                        }
                        if (MovementLogic.wouldOverlap(this, 0, i * -1, visualObject)) {
                            canMove = false;
                        }
                    }
                    if (canMove) {
                        y -= i;
                        break;
                    }
                }

            }

            if (Main.downPressed) {
                for (int i = speed; i > 0; i--) {
                    boolean canMove = true;
                    for (VisualObject visualObject : Main.environment) {
                        if (visualObject instanceof Player) {
                            continue;
                        }
                        if (MovementLogic.wouldOverlap(this, 0, i, visualObject)) {
                            canMove = false;
                        }
                    }
                    if (canMove) {
                        y += i;
                        break;
                    }
                }
            }

            if (Main.leftPressed) {
                for (int i = speed; i > 0; i--) {
                    boolean canMove = true;
                    for (VisualObject visualObject : Main.environment) {
                        if (visualObject instanceof Player) {
                            continue;
                        }
                        if (MovementLogic.wouldOverlap(this, i * -1, 0, visualObject)) {
                            canMove = false;
                        }
                    }
                    if (canMove) {
                        x -= i;
                        break;
                    }
                }
            }

            if (Main.rightPressed) {
                for (int i = speed; i > 0; i--) {
                    boolean canMove = true;
                    for (VisualObject visualObject : Main.environment) {
                        if (visualObject instanceof Player) {
                            continue;
                        }
                        if (MovementLogic.wouldOverlap(this, i, 0, visualObject)) {
                            canMove = false;
                        }
                    }
                    if (canMove) {
                        x += i;
                        break;
                    }
                }
            }
        }




    }
}
