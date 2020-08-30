package GUI.components;

import levels.Level;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame{
    public MainFrame() {
        initComponents();
    }
    public GamePanel gamePanel;
    public InfoPanel infoPanel;
    private void initComponents() {
        JMenuBar mainMenu = new JMenuBar();
        JMenu gameMenu = new JMenu();
        JMenuItem newLevel = new JMenuItem();
        JMenuItem solveLevel = new JMenuItem();
        gamePanel = new GamePanel(Level.LEVEL0);
        infoPanel = new InfoPanel(gamePanel);
        this.setLayout(new BorderLayout());

        gameMenu.setText("Level");
        newLevel.setText("new");
        newLevel.addActionListener(e -> newGame());

        solveLevel.setText("solve");
        solveLevel.addActionListener(e -> solveAll());

        gameMenu.add(solveLevel);
        gameMenu.add(newLevel);
        mainMenu.add(gameMenu);

        this.add(gamePanel,BorderLayout.CENTER);
        this.add(infoPanel,BorderLayout.WEST);
        this.setJMenuBar(mainMenu);
        this.pack();
    }

    public void looseHP() {
        infoPanel.setHp(infoPanel.getHp() - 1);
        infoPanel.reprint();
        if (infoPanel.getHp() < 1) {
            EndPrompt lostGame = new EndPrompt();

            lostGame.endText.setForeground(Color.RED);
            lostGame.setEndtext("Game lost");
            lostGame.setVisible(true);

            solveAll();
        }
    }

    public void updateBoxes() {
        infoPanel.setBoxes(infoPanel.getBoxes() - 1);
        infoPanel.reprint();
        if (infoPanel.getBoxes() == 0) {
            EndPrompt wonGame = new EndPrompt();

            wonGame.endText.setForeground(Color.GREEN);
            wonGame.setEndtext("Game won");
            wonGame.setVisible(true);
        }
    }

    public void solveAll() {
        gamePanel.allButtons().forEach(LevelButton::solve);
        gamePanel.repaint();
    }

    public void newGame() {
        gamePanel.allButtons().forEach(LevelButton::reset);
        infoPanel.reset();
    }
}
