package levels;

import GUI.components.LevelButton;

public class LevelCreator {

    public void setRow(LevelButton[] buttons, int bitRow) {
        for (int i = 0; i < buttons.length; i++) {
            if ((bitRow & 1 << i) != 0)
                buttons[i].setState(true);
        }
    }

    private static int stringToBitRow(String binary) {
        int bitRow = 0;
        int[] layout = binary.replaceAll("[^0-1]","").chars().toArray();
        for (int i = 0; i < layout.length; i++) {
            if (layout[i] == 1) {
                bitRow |= 1 << i;
            }
        }
        return bitRow;
    }

    public static void main(String[] args) {
        System.out.println(stringToBitRow("11111111100111"));
    }
}
