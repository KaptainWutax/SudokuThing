package GUI.components;

import levels.Level;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
    }
    public GamePanel gamePanel;
    public InfoPanel infoPanel;
    private void initComponents() {
        JMenuBar mainMenu = new JMenuBar();
        JMenu gameMenu = new JMenu();
        JMenuItem restart = new JMenuItem();
        JMenuItem solveLevel = new JMenuItem();
        JMenuItem nextLevel = new JMenuItem();
        JMenuItem randomLevel = new JMenuItem();
        gamePanel = new GamePanel(Level.LEVEL0);
        infoPanel = new InfoPanel(gamePanel);
        this.setLayout(new BorderLayout());

        gameMenu.setText("Level");
        restart.setText("restart");
        restart.addActionListener(e -> restartGame());

        solveLevel.setText("solve");
        solveLevel.addActionListener(e -> solveAll());

        nextLevel.setText("next");
        nextLevel.addActionListener(e -> {
            gamePanel.loadLevel(Level.nextLevel(gamePanel.getCurrentLevel()));

            restartGame();
        });

        randomLevel.setText("random");
        randomLevel.addActionListener(e -> newRandomGame());

        gameMenu.add(solveLevel);
        gameMenu.add(restart);
        gameMenu.add(nextLevel);
        gameMenu.add(randomLevel);
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
        if (infoPanel.getBoxes() == 0 || !hasButtonsLeft()) {
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

    public void restartGame() {
        gamePanel.allButtons().forEach(LevelButton::reset);
        infoPanel.reset();
    }

    public void newRandomGame() {
        gamePanel.loadLevel(Level.LEVELRANDOM);
        infoPanel.reset();
    }

    private boolean hasButtonsLeft() {
        return gamePanel.allButtons().stream().anyMatch(lb -> lb.getState() && lb.isEnabled());
    }
}
