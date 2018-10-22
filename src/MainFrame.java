import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public Screen currentScreen;

    public MainFrame() {
        setTitle("Identity");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        this.setLocationRelativeTo(null);
        //seticonimage
        currentScreen = new MainMenuScreen();
        add(currentScreen);
        setVisible(true);
        setFocusable(true);
        addKeyListener(Main.keyListener());
    }

    @Override
    public void revalidate() {
        super.revalidate();
        for (VisualObject visualObject : currentScreen.background) {
            visualObject.ai();
        }
        for (VisualObject visualObject : Main.environment) {
            visualObject.ai();
        }
    }
}
