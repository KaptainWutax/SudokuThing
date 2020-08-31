package GUI.components;

import levels.Level;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;


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
        gamePanel = new GamePanel(Level.LEVEL0);
        infoPanel = new InfoPanel(gamePanel);
        this.setLayout(new BorderLayout());

        gameMenu.setText("Level");
        restart.setText("restart");
        restart.addActionListener(e -> restartGame());

        solveLevel.setText("solve");
        solveLevel.addActionListener(e -> solveAll());

        nextLevel.setText("skip");
        nextLevel.addActionListener(e -> {
            gamePanel.loadLevel(Level.nextLevel(gamePanel.getCurrentLevel()));
            infoPanel.reset();

            restartGame();
        });

        gameMenu.add(solveLevel);
        gameMenu.add(restart);
        gameMenu.add(nextLevel);
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

    private boolean hasButtonsLeft() {
        return gamePanel.allButtons().stream().anyMatch(lb -> lb.getState() && lb.isEnabled());
    }
}
