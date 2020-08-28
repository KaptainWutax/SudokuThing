package GUI.components;

import javax.swing.*;
import java.awt.*;


public class MainFrame {
    public MainFrame() {
        initComponents();
    }
    public JFrame MainFrame;
    private void initComponents() {
        MainFrame = new JFrame();
        JMenuBar mainMenu = new JMenuBar();
        JMenu gameMenu = new JMenu();
        JMenuItem newLevel = new JMenuItem();
        JMenuItem solveLevel = new JMenuItem();
        GamePanel gamePanel = new GamePanel();

        MainFrame.setLayout(new BorderLayout());
        gameMenu.setText("Level");
        newLevel.setText("new");
        newLevel.addActionListener(e -> gamePanel.allButtons().forEach(LevelButton::reset));

        solveLevel.setText("solve");
        solveLevel.addActionListener(e -> gamePanel.allButtons().forEach(LevelButton::solve));

        gameMenu.add(solveLevel);
        gameMenu.add(newLevel);
        mainMenu.add(gameMenu);

        MainFrame.add(gamePanel);
        MainFrame.setJMenuBar(mainMenu);
        MainFrame.pack();
    }
}
