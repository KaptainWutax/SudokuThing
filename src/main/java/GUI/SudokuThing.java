package GUI;

import GUI.components.MainFrame;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class SudokuThing {
    public static void main(String[] args) {

        FlatLightLaf.install();
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFrame main = new MainFrame().MainFrame;
        main.setVisible(true);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setTitle("SudokuThing");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        main.setExtendedState(JFrame.MAXIMIZED_BOTH);
        main.setSize(screenSize.width / 2, screenSize.height / 2);
        main.pack();
    }
}
