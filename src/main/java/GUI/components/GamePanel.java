package GUI.components;

import levels.Level;
import levels.LevelCreator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
        this.removeAll();
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        ButtonTable = new LevelButton[gridSize][gridSize];

        for (int x = 0; x < gridSize; x++) {
            gbc.gridx = x+1;
            for (int y = 0; y < gridSize; y++) {
                gbc.gridy = y+1;
                ButtonTable[y][x] = new LevelButton();
                this.add(ButtonTable[y][x], gbc);
            }
        }
        for (int i = 0; i < gridSize; i++) {
            gbc.gridx = 0;
            gbc.gridy = i+1;
            this.add(new JLabel(LevelCreator.getRowHints(layout)[i]),gbc);
        }
        for (int i = 0; i < gridSize; i++) {
            gbc.gridx = i+1;
            gbc.gridy = 0;
            this.add(new JLabel(String.format("<html><margin = 10 px> %s </margin></html>",LevelCreator.getCollumnHints(layout)[i])), gbc);
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
        if(layout == null){
        layout = LevelCreator.randomLayout(level.getSize());
        }
        addContent();
        setupLevel();

        this.revalidate();
        this.repaint();
    }
}
