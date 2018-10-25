package net;

import net.Screens.MainMenuScreen;
import net.Screens.Screen;
import net.Visuals.Player;
import net.Visuals.VisualObject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static List<VisualObject> environment;
    public static int tick = 0;
    public static int time = 0;

    public static MainFrame mainFrame;
    public static Screen screenToSwitchTo = null;

    public static boolean upPressed = false;
    public static boolean leftPressed = false;
    public static boolean downPressed = false;
    public static boolean rightPressed = false;
    public static boolean spacePressed = false;

    public static Player player;
    public static boolean playerCanMove;
    public static boolean playerIsVisible;

    public static void main(String[] args) {
        mainFrame = new MainFrame();
        switchScreen(new MainMenuScreen());
        environment = new ArrayList<>();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                tick++;
                time++;

                if (screenToSwitchTo != null) {
                    if (mainFrame.currentScreen != null) {
                        mainFrame.remove(mainFrame.currentScreen);
                    }
                    mainFrame.currentScreen = screenToSwitchTo;
                    mainFrame.add(mainFrame.currentScreen);
                    mainFrame.currentScreen.init();
                    screenToSwitchTo = null;
                }

                runBehaviors();
                mainFrame.revalidate();
                mainFrame.repaint();
                if (tick == 20) {
                    tick = 0;
                }
            }
        };
        Timer timer = new Timer("MyTimer");
        timer.scheduleAtFixedRate(timerTask, 0, 50);

        player = new Player(400, 450, 30, 50);
        environment.add(player);
        playerIsVisible = true;
        playerCanMove = false;
    }

    public static void switchScreen(Screen newScreen) {
        screenToSwitchTo = newScreen;
    }

    public static KeyListener keyListener() {
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
                    upPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
                    leftPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    downPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    rightPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    spacePressed = true;
                    if (time < 80) {
                        time = 79;
                    }
                }


            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
                    upPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
                    leftPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    downPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    rightPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    spacePressed = false;
                }
            }
        };

        return keyListener;
    }

    public static void runBehaviors() {
        List<VisualObject> graveyard = new ArrayList<>();
        mainFrame.currentScreen.behavior();
        for (VisualObject visualObject : mainFrame.currentScreen.background) {
            if (!visualObject.destroyed) {
                visualObject.behavior();
            } else {
                graveyard.add(visualObject);
            }
        }

        for (VisualObject visualObject : graveyard) {
            mainFrame.currentScreen.background.remove(visualObject);
        }
        graveyard = new ArrayList<>();

        for (VisualObject visualObject : Main.environment) {
            if (!visualObject.destroyed) {
                visualObject.behavior();
            } else {
                graveyard.add(visualObject);
            }
        }

        for (VisualObject visualObject : graveyard) {
            Main.environment.remove(visualObject);
        }
        graveyard = new ArrayList<>();

        for (VisualObject visualObject : mainFrame.currentScreen.foreground) {
            if (!visualObject.destroyed) {
                visualObject.behavior();
            } else {
                graveyard.add(visualObject);
            }
        }

        for (VisualObject visualObject : graveyard) {
            mainFrame.currentScreen.foreground.remove(visualObject);
        }
        //graveyard = new ArrayList<>();
    }
}
