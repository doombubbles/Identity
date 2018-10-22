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

    public static boolean wPressed = false;
    public static boolean aPressed = false;
    public static boolean sPressed = false;
    public static boolean dPressed = false;

    public static Player player;
    public static boolean playerCanMove;
    public static boolean playerIsVisible;

    public static void main(String[] args) {
        mainFrame = new MainFrame();
        environment = new ArrayList<>();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                tick++;
                time++;
                mainFrame.revalidate(); //also will run AI
                mainFrame.repaint();
                if (tick == 20) {
                    tick = 0;
                }
            }
        };

        Timer timer = new Timer("MyTimer");
        timer.scheduleAtFixedRate(timerTask, 0, 50);

        player = new Player(50, 50, 50, 50);
        environment.add(player);
        playerIsVisible = true;
        playerCanMove = true;
    }

    public static void switchScreen(Screen newScreen) {
        mainFrame.remove(mainFrame.currentScreen);
        mainFrame.currentScreen = newScreen;
        mainFrame.add(mainFrame.currentScreen);
    }

    public static KeyListener keyListener() {
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    wPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    aPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    sPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    dPressed = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    wPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    aPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    sPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    dPressed = false;
                }
            }
        };

        return keyListener;
    }
}
