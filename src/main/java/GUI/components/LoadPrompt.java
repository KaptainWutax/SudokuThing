package GUI.components;

import GUI.SudokuThing;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;

public class LoadPrompt extends JDialog {
    LoadPrompt() {
        setPrompt();
    }
    private void setPrompt() {
        JTextField input = new JTextField();
        JButton confirm = new JButton();

        confirm.setText("load Layout");
        confirm.addActionListener(e -> {
            SudokuThing.INSTANCE.gamePanel.loadLevel(fromString(input));
//            System.out.println(Arrays.toString(fromString(input)));
            this.dispose();
        });

        this.setLayout(new BorderLayout());
        this.add(input, BorderLayout.NORTH);
        this.add(confirm, BorderLayout.CENTER);
        this.setTitle("enter Layout");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(300,100));
        this.pack();
    }

    private int[] fromString(JTextField in) {
        return Stream.of(in.getText().replaceAll("[\\[\\]\\ ]", "").split(",")).mapToInt(Integer::parseInt).toArray();
    }
}
