package GUI.components;

import levels.LevelCreator;

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
        JMenuItem loadLevel = new JMenuItem();
        gamePanel = new GamePanel();
        infoPanel = new InfoPanel();
        this.setLayout(new BorderLayout());

        gameMenu.setText("Level");
        restart.setText("restart");
        restart.addActionListener(e -> restartGame());

        solveLevel.setText("solve");
        solveLevel.addActionListener(e -> solveAll());

        nextLevel.setText("next");
        nextLevel.addActionListener(e -> newRandomGame());

        loadLevel.setText("from Layout");
        loadLevel.addActionListener(e -> {
            LoadPrompt p = new LoadPrompt();
        });

        gameMenu.add(solveLevel);
        gameMenu.add(restart);
        gameMenu.add(nextLevel);
        gameMenu.add(loadLevel);
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

            solveAll();
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
        newRandomGame(15);
    }

    public void newRandomGame(int size) {
        gamePanel.loadLevel(LevelCreator.randomLayout(size));
        infoPanel.reset();
    }

    private boolean hasButtonsLeft() {
        return gamePanel.allButtons().stream().anyMatch(lb -> lb.getState() && lb.isEnabled());
    }
}
