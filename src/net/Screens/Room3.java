package net.Screens;

import net.Main;
import net.Visuals.*;

import javax.swing.*;
import java.awt.*;

public class Room3 extends Screen {

    boolean open;
    boolean inColorRange;
    int startTime;
    boolean hasChangedColor;

    NPC npc;
    NPC npc2;

    Boundary boundary1;
    Boundary boundary2;
    Boundary boundary3;

    @Override
    public void init() {
        open = false;
        startTime = Main.time;
        inColorRange = false;
        background.add(new BackgroundImage("img/room3.png", 800, 600));

        Main.environment.add(new Boundary(0, 0, 25, 267));
        Main.environment.add(new Boundary(26, 0, 748, 102));
        Main.environment.add(new Boundary(774, 0, 20, 266));
        Main.environment.add(new Boundary(774, 344, 20, 153));
        Main.environment.add(new Boundary(439, 497, 356, 76));
        Main.environment.add(new Boundary(0, 497, 356, 76));
        Main.environment.add(new Boundary(0,344,26,228));

        Main.environment.add(new Boundary(0, 0, 25, 267));

        if (Main.checkpoint < 6) {
            npc = new NPC(400, 300, 30, 50, Color.RED);
            Main.environment.add(npc);

        }

        Main.environment.add(new NPC(150, 450, 30, 50, Color.magenta));
        hasChangedColor = false;

        if (Main.checkpoint >= 4) {
            Main.environment.add(new Door(0, 266, 26, 78, new Room6(), 750, 300, true));
            Main.environment.add(new Door(356, 497, 83, 76, new Room5(), 400, 150, true));
            Main.environment.add(new Door(774, 267, 21, 77, new Room2(), 50, 300, true));
        }

    }

    @Override
    public void behavior() {
        if (Main.checkpoint == 1) {
            if (Main.time == startTime) {
                npc2 = new NPC(100, 100, 30, 50, Main.tardisBlue);
                Main.environment.add(npc2);
                Main.playerCanMove = false;

                boundary1 = new Boundary(0, 266, 26, 78);
                Main.environment.add(boundary1);
                boundary2 = new Boundary(356, 497, 83, 76);
                Main.environment.add(boundary2);
                boundary3 = new Boundary(774, 267, 21, 77);
                Main.environment.add(boundary3);
            }

            if (Main.time % 4 == 0) {
                npc2.x += 2;
            } else if (Main.time % 4 == 2) {
                npc2.x -= 2;
            }

            if (Main.time < startTime + 20) {
                Main.player.x -= 10;
            }
            if (Main.time == startTime + 30) {
                foreground.add(new MessagePopUp(0, 50, "Why are our thoughts separate?", 65, false, Main.player.color));
            }

            if (Main.time == startTime + 100) {
                foreground.add(new MessagePopUp(0, 50, "Why can't I feel anything?", 65, false, Main.player.color));
            }

            if (Main.time == startTime + 190) {
                foreground.add((new MessagePopUp(0, 50, "You can still feel, Blue. We're just not together in the Lake anymore.", 65, false, Color.RED)));
            }

            if (Main.time == startTime + 260) {
                foreground.add(new MessagePopUp(0, 50, "You can only feel your own feelings, hear your own thoughts.", 60, false, Color.red));
            }

            if (Main.time == startTime + 320) {
                npc.plotCourse(-300, 0);
            }
            if (Main.time == startTime + 350) {
                npc.plotCourse(0, -150);
            }

            if (Main.time == startTime + 370) {
                foreground.add(new MessagePopUp(0, 50, "Some take it harder than others.", 60, false, Color.red));
            }

            if (Main.time == startTime + 450) {
                Main.checkpoint = 2;
            }


        }
        if (Main.checkpoint == 2) {
            if (!npc2.destroyed) {
                if (Main.time > startTime + 470 && Main.time < startTime + 510) {
                    npc2.color = new Color(npc2.color.getRed(), npc2.color.getGreen(), npc2.color.getBlue(), (int)(npc2.color.getAlpha() / 1.1f));
                }
                if (Main.time == startTime + 510) {
                    npc2.destroyed = true;
                }
            }

            if (Main.time == startTime + 540) {
                foreground.add(new MessagePopUp(0, 50, "...", 40, false, Color.RED));
            }

            if (Main.time == startTime + 585) {
                foreground.add(new MessagePopUp(0, 50, "I'm sorry you had to be there to see that.", 60, false, Color.RED));
            }

            if (Main.time == startTime + 650) {
                foreground.add(new MessagePopUp(0, 50, "Not everyone can handle living like this.", 60, false, Color.RED));
                npc.plotCourse(0, 150);
            }
            if (Main.time == startTime + 665) {
                npc.plotCourse(300, 0);
            }
            if (Main.time == startTime + 715) {
                foreground.add(new MessagePopUp(0, 50, "It can help if you choose a color for yourself like we have.", 50, false, Color.RED));
            }
            if (Main.time == startTime + 770) {
                foreground.add(new MessagePopUp(0, 50, "Would you like to?", 60, false, Color.RED));
            }
            if (Main.time == startTime + 800) {
                Main.doTick = false;
                Main.decision1 = JOptionPane.showConfirmDialog(null, "Would you like to choose your own color for yourself?", "Choose your path", JOptionPane.YES_NO_OPTION);
                Main.doTick = true;
                Main.playerCanMove = true;
                if (Main.decision1 == JOptionPane.YES_OPTION) {
                    foreground.add(new MessagePopUp(0, 50, "Good. Just walk over to the fountain whenever you're ready.", 100, false, Color.RED));

                } else {
                    foreground.add(new MessagePopUp(0, 50, "That's your call then.", 100, false, Color.RED));
                }
            }

            if (Main.time == startTime + 900 && Main.decision1 == JOptionPane.NO_OPTION) {
                Main.checkpoint = 3;
            }

            if (hasChangedColor && Main.checkpoint == 2) {
                Main.checkpoint = 3;
            }
        }

        if (Main.checkpoint == 3) {
            foreground.add(new MessagePopUp(0, 50, "You can go to the room below and rest, or explore around.", 180, false, Color.RED));
            foreground.add(new MessagePopUp(0, 50, "Well. I know this must be a lot to take in.", 90, false, Color.RED));
            Main.checkpoint = 4;

            boundary1.destroyed = true;
            boundary2.destroyed = true;
            boundary3.destroyed = true;

            Main.environment.add(new Door(0, 266, 26, 78, new Room6(), 750, 300, true));
            Main.environment.add(new Door(356, 497, 83, 76, new Room5(), 400, 150, true));
            Main.environment.add(new Door(774, 267, 21, 77, new Room2(), 50, 300, true));

        }


        if (Main.checkpoint == 6) {
            foreground.add(new MessagePopUp(0, 50, "Freeing this next guy completely broke the machine.", 2, false, new Color(127, 55 , 0)));
        }




        if (Main.player.x > 370 && Main.player.x < 425 && Main.player.y < 170) {
            inColorRange = true;
        } else  {
            inColorRange = false;
        }
        if (!inColorRange) {
            open = false;
        }

        if (inColorRange && !open && Main.decision1 != JOptionPane.NO_OPTION) {
            open = true;
            Main.playerCanMove = false;
            Main.doTick = false;
            Main.player.color = JColorChooser.showDialog(null, "Choose your new color", Main.player.color);
            Main.doTick = true;
            Main.playerCanMove = true;
            Main.player.x = 400;
            Main.player.y = 200;
            hasChangedColor = true;
        }

    }
}
