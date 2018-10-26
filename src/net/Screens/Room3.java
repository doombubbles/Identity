package net.Screens;

import net.Main;
import net.Visuals.BackgroundImage;
import net.Visuals.Boundary;
import net.Visuals.MessagePopUp;
import net.Visuals.NPC;

import javax.swing.*;
import java.awt.*;

public class Room3 extends Screen {

    boolean open;
    boolean inColorRange;
    int startTime;

    NPC npc;
    NPC npc2;

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


        npc = new NPC(400, 300, 30, 50, Color.RED);
        Main.environment.add(npc);

    }

    @Override
    public void behavior() {
        if (Main.checkpoint == 1) {
            if (Main.time == startTime) {
                npc2 = new NPC(100, 100, 30, 50, Main.tardisBlue);
                Main.environment.add(npc2);
                Main.playerCanMove = false;
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
                foreground.add(new MessagePopUp(0, 50, "", 60, false, Color.RED));
            }

        }





        if (Main.player.x > 370 && Main.player.x < 425 && Main.player.y < 170) {
            inColorRange = true;
        } else  {
            inColorRange = false;
        }
        if (!inColorRange) {
            open = false;
        }

        if (inColorRange && !open) {
            open = true;
            Main.playerCanMove = false;
            Main.doTick = false;
            Main.player.color = JColorChooser.showDialog(null, "Choose your new color", Main.player.color);
            Main.doTick = true;
            Main.playerCanMove = true;
            Main.player.x = 400;
            Main.player.y = 200;
        }

    }
}
