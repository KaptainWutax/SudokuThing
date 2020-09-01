package GUI.components;

import GUI.SudokuThing;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.Arrays;

public class InfoPanel extends JPanel {
    public InfoPanel() {
        addInfo();
    }

    public JLabel healthInfo;
    public JLabel progressInfo;
    private void addInfo() {
        healthInfo = new JLabel();
        progressInfo = new JLabel();
        JButton shareLayout = new JButton();

        shareLayout.setText("copy layout");
        shareLayout.addActionListener(e -> Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(Arrays.toString(SudokuThing.INSTANCE.gamePanel.getCurrentLevel())), null));



        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(healthInfo);
        this.add(progressInfo);
        this.add(shareLayout);
    }
    private int hp;
    private int boxes;

    public int getHp() {
        return hp;
    }

    public void setHp(int i) {
        hp = i;
    }

    public int getBoxes() {
        return boxes;
    }

    public void setBoxes(int i) {
        boxes = i;
    }

    public void reprint() {
        healthInfo.setText("Mistakes left: " + getHp());
        progressInfo.setText("Squares left: " + getBoxes());
    }

    public void reset() {
        this.setHp(3);
        this.setBoxes(SudokuThing.INSTANCE.gamePanel.getGridSize() * SudokuThing.INSTANCE.gamePanel.getGridSize());
        this.reprint();
    }
}
