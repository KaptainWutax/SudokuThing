package GUI;

import GUI.components.MainFrame;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class SudokuThing {
    public static MainFrame INSTANCE;
    public static void main(String[] args) {

        FlatLightLaf.install();
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        INSTANCE = new MainFrame();
        INSTANCE.setVisible(true);
        INSTANCE.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        INSTANCE.setTitle("SudokuThing");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        INSTANCE.setExtendedState(JFrame.MAXIMIZED_BOTH);
        INSTANCE.setSize(screenSize.width / 2, screenSize.height / 2);
        INSTANCE.pack();
    }
}
