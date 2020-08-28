package GUI.components;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class GamePanel extends JPanel {
    public GamePanel() {
        addContent();
    }

    private void addContent() {
        JPanel gamePane = new JPanel();
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        for (int y = 0; y < GridSize; y++) {
            gbc.gridy = y;
            for (int x = 0; x < GridSize; x++) {
                gbc.gridx = x;
                this.add(new LevelButton(), gbc);
            }
        }
    }

    private int GridSize = 15;

    public void setGridSize(int gridSize) {
        GridSize = gridSize;
    }

    public ArrayList<LevelButton> allButtons() {
        ArrayList<LevelButton> out = new ArrayList<>(GridSize * GridSize);
        for (Component lb : this.getComponents()) {
            if (lb instanceof LevelButton) {
                out.add((LevelButton) lb);
            }
        }
        return out;
    }
}
