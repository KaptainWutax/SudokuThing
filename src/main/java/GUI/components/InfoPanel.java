package GUI.components;

import javax.swing.*;

public class InfoPanel extends JPanel {
    public InfoPanel() {
        addInfo();
    }

    private void addInfo() {
        JPanel infoPanel = new JPanel();
        JLabel healthInfo = new JLabel();
        JLabel progressInfo = new JLabel();

        healthInfo.setText("Mistakes left: " + getHp());
        progressInfo.setText("Squares left: " + getSquares());

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(healthInfo);
        this.add(progressInfo);
    }
    private int hp = 3;
    private int squares = 225;

    public int getHp() {
        return hp;
    }

    public void setHp(int i) {
        hp = i;
    }

    public int getSquares() {
        return squares;
    }
    public void setSquares(int i) {
        squares = i;
    }
}
