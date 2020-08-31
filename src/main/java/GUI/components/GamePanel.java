package GUI.components;

import levels.Level;
import levels.LevelCreator;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        this(15);
    }
    public GamePanel(int gridSize){
        setGridSize(gridSize);
        addContent();
    }
    public GamePanel(Level level) {
        loadLevel(level);
    }
    private Level currentLevel;
    private int gridSize;
    private LevelButton[][] ButtonTable;
    private int[] layout;

    private void addContent() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        ButtonTable = new LevelButton[gridSize][gridSize];

        for (int x = 0; x < gridSize; x++) {
            gbc.gridx = x;
            for (int y = 0; y < gridSize; y++) {
                gbc.gridy = y;
                ButtonTable[y][x] = new LevelButton();
                this.add(ButtonTable[y][x], gbc);
            }
        }
    }

    private void setupLevel() {
        int i = 0;
        for (LevelButton[] row : ButtonTable) {
            LevelCreator.setRow(row,layout[i]);
            i++;
        }
    }

    public void setGridSize(int i) {
        gridSize = i;
    }

    public int getGridSize() {
        return gridSize;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public ArrayList<LevelButton> allButtons() {
        ArrayList<LevelButton> out = new ArrayList<>(gridSize * gridSize);
        for (Component lb : this.getComponents()) {
            if (lb instanceof LevelButton) {
                out.add((LevelButton) lb);
            }
        }
        return out;
    }

    public void loadLevel(Level level) {
        setGridSize(level.getSize());
        currentLevel = level;
        layout = level.getLayout();
        this.removeAll();
        addContent();
        setupLevel();
    }
}
