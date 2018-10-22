import javax.swing.*;
import java.awt.*;

public class MainMenuScreen extends Screen {

    public MainMenuScreen() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        background.add(new BackgroundImage("Map_Background_Ocean.png", 800, 455));

        add(Box.createVerticalStrut(500));

        JLabel loadingLabel = new JLabel("Loading...");
        loadingLabel.setFont(new Font("", Font.PLAIN, 20));
        loadingLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(loadingLabel);
    }
}
