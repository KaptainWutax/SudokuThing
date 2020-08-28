package GUI.components;

import javax.swing.*;
import java.awt.*;


public class MainFrame {
    public MainFrame() {
        initComponents();
    }
    public JFrame mainFrame;
    private void initComponents() {
        mainFrame = new JFrame();
        JMenuBar mainMenu = new JMenuBar();
        JMenu gameMenu = new JMenu();
        JMenuItem newLevel = new JMenuItem();
        JMenuItem solveLevel = new JMenuItem();
        GamePanel gamePanel = new GamePanel();

        mainFrame.setLayout(new BorderLayout());
        gameMenu.setText("Level");

        newLevel.setText("new");
        newLevel.addActionListener(e -> gamePanel.allButtons().forEach(LevelButton::reset));

        solveLevel.setText("solve");
        solveLevel.addActionListener(e -> gamePanel.allButtons().forEach(LevelButton::solve));

        gameMenu.add(solveLevel);
        gameMenu.add(newLevel);
        mainMenu.add(gameMenu);

        mainFrame.add(gamePanel);
        mainFrame.setJMenuBar(mainMenu);
        mainFrame.pack();
    }
}
