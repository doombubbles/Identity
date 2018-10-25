package net;

import net.Screens.Screen;

import javax.swing.*;

public class MainFrame extends JFrame {

    public Screen currentScreen;

    public MainFrame() {
        setTitle("Identity");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        this.setLocationRelativeTo(null);
        //seticonimage
        setVisible(true);
        setFocusable(true);
        addKeyListener(Main.keyListener());
    }

    @Override
    public void revalidate() {
        super.revalidate();
    }
}
