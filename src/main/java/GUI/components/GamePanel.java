package GUI.components;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        addContent();
    }

    private void addContent() {
        JPanel gamePanel = new JPanel();
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        for (int y = 0; y < gridSize; y++) {
            gbc.gridy = y;
            for (int x = 0; x < gridSize; x++) {
                gbc.gridx = x;
                this.add(new LevelButton(), gbc);
            }
        }
    }

    private int gridSize = 15;

    public void setGridSize(int i) {
        gridSize = i;
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
}
