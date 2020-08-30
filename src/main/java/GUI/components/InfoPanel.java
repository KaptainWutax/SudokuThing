package GUI.components;

import javax.swing.*;

public class InfoPanel extends JPanel {
    public InfoPanel(GamePanel gamePanel) {
        setStartBoxes((gamePanel.getGridSize() * gamePanel.getGridSize()));
        addInfo();
    }

    public JLabel healthInfo;
    public JLabel progressInfo;
    private void addInfo() {
        healthInfo = new JLabel();
        progressInfo = new JLabel();

        reprint();

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(healthInfo);
        this.add(progressInfo);
    }
    private int hp = 3;
    private int startBoxes;
    private int boxes;

    private void setStartBoxes(int i) {
        startBoxes = boxes = i;
    }

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
        this.setBoxes(startBoxes);
        this.reprint();
    }
}
