package net.Screens;

import net.Main;
import net.Visuals.*;

import javax.swing.*;
import java.awt.*;

public class Room6 extends Screen {

    int startTime;

    NPC npc;
    NPC npc2;

    Door doorLeft;
    Door doorRight;

    @Override
    public void init() {

        startTime = Main.time;
        background.add(new BackgroundImage("img/room6.png", 800, 600));
        Main.environment.add(new Boundary(0, 0, 25, 267));
        Main.environment.add(new Boundary(26, 0, 748, 102));
        Main.environment.add(new Boundary(774, 0, 20, 266));
        Main.environment.add(new Boundary(774, 344, 20, 153));
        Main.environment.add(new Boundary(0,498,794,74));
        Main.environment.add(new Boundary(0,344,26,228));


        Main.environment.add(new Boundary(310,199,175,196));

        doorRight = new Door(774, 267, 26, 77, new Room3(), 50, 300, true);
        doorLeft = new Door(0, 267, 26, 77, new Room4(), 750, 300, true);
        Main.environment.add(doorRight);
        Main.environment.add(doorLeft);




        Main.environment.add(new NPC(230, 400, 30, 50, new Color(127, 55 , 0)));


    }

    @Override
    public void behavior() {
        if (Main.checkpoint == 6) {
            if (Main.time == startTime) {
                npc = new NPC(230, 230, 30, 50, Color.RED);
                Main.environment.add(npc);
                foreground.add(new MessagePopUp(0, 50, "It'll be months before we can free anybody more.", 60, false, new Color(127, 55 , 0)));
            }

            if (Main.time < startTime + 20) {
                Main.player.x -= 5;
            }

            if (Main.time == startTime + 80) {
                foreground.add(new MessagePopUp(0, 50, "What do you mean \"free\" anybody?", 60, false, Main.player.color));
            }

            if (Main.time == startTime + 145) {
                foreground.add(new MessagePopUp(0, 50, "It's been you separating us from the Lake?", 60, false, Main.player.color));
            }

            if(Main.time == startTime + 220) {
                foreground.add(new MessagePopUp(0, 50, "We were going to tell you eventually.", 60, false, Color.RED));
            }

            if(Main.time == startTime + 285) {
                foreground.add(new MessagePopUp(0, 50, "But don't you see?", 30, false, Color.RED));
            }

            if(Main.time == startTime + 320) {
                foreground.add(new MessagePopUp(0, 50, "There's no free will living as part of the Lake.", 60, false, Color.RED));
            }

            if(Main.time == startTime + 375) {
                foreground.add(new MessagePopUp(0, 50, "You can't truly think for yourself or feel for yourself.", 60, false, Color.RED));
            }

            if(Main.time == startTime + 440) {
                foreground.add(new MessagePopUp(0, 50, "What's the point in existing like that?", 60, false, Color.RED));
            }

            if(Main.time == startTime + 510) {
                foreground.add(new MessagePopUp(0, 50, "That's not your decision to make. Or mine.", 60, false, Main.player.color));
            }

            if(Main.time == startTime + 590) {
                foreground.add(new MessagePopUp(0, 50, "Without us, you couldn't ever have made a decision for yourself.", 60, false, Color.red));
            }

            if(Main.time == startTime + 660) {
                foreground.add(new MessagePopUp(0, 50, "So, now I'll give you another choice.", 40, false, Color.red));
            }

            if(Main.time == startTime + 705) {
                foreground.add(new MessagePopUp(0, 50, "You can stay and help us build our society...", 50, false, Color.red));
            }

            if(Main.time == startTime + 755) {
                foreground.add(new MessagePopUp(0, 50, "Or leave, and be even more alone than you've ever been.", 50, false, Color.red));
            }

            if(Main.time == startTime + 810) {
                foreground.add(new MessagePopUp(0, 50, "Which is it going to be?", 60, false, Color.red));
            }

            if (Main.time == startTime + 880) {
                Main.doTick = false;
                Main.decision2 = JOptionPane.showConfirmDialog(null, "Do you want to escape?", "Choose your path", JOptionPane.YES_NO_OPTION);
                Main.doTick = true;

                if (Main.decision2 == JOptionPane.YES_OPTION) {
                    foreground.add(new MessagePopUp(0, 50, "Sorry, but I can't support this.", 60, false, Main.player.color));
                } else {
                    foreground.add(new MessagePopUp(0, 50, "I think I understand now. I'll stay.", 60, false, Main.player.color));
                }

            }

            if (Main.time == startTime + 930) {
                if (Main.decision2 == JOptionPane.YES_OPTION) {
                    foreground.add(new MessagePopUp(0, 50, "Well, that's your decision. Exit's to the left.", 120, false, Color.red));
                    doorRight.destroyed = true;
                    Main.environment.add(new Boundary(774, 0, 20, 572));
                } else {
                    foreground.add(new MessagePopUp(0, 50, "Good, because we have a new arrival. I think you know what to do.", 120, false, Color.red));
                    doorLeft.destroyed = true;
                    Main.environment.add(new Boundary(0, 0, 20, 572));
                }
                Main.checkpoint = 7;
                Main.playerCanMove = true;
            }

        }
    }
}
