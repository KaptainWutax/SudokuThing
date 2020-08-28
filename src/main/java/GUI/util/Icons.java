package GUI.util;

import GUI.components.LevelButton;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Icons {
    public static final Image CROSS = load("cross.png");
    public static final Image FILLED = load("filled.png");

    public static Image load(String path) {
        try {
            return ImageIO.read(LevelButton.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
