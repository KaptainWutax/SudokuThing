package levels;

import GUI.components.LevelButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LevelCreator {

    public static void setRow(LevelButton[] buttons, int bitRow) {
        for (int i = 0; i < buttons.length; i++) {
            if ((bitRow & 1 << i) != 0)
                buttons[i].setState(true);
        }
    }

    private static int stringToBitRow(String binary) {
        int bitRow = 0;
        int[] layout = binary.replaceAll("[^0-1]","").chars().toArray();
        for (int i = 0; i < layout.length; i++) {
            if (layout[i] == '1') {
                bitRow |= 1 << i;
            }
        }
        return bitRow;
    }

    private static int randomBitRow(int lenght) {
        int bitRow = 0;
        Random random = new Random();
        for (int i = 0; i < lenght; i++) {
            if (random.nextBoolean()) {
                bitRow |= 1 << i;
            }
        }
        return bitRow;
    }

    public static int[] randomLayout(int size) {
        int[] layout = new int[size];
        for (int i = 0; i < size; i++) {
            layout[i] = randomBitRow(size);
        }
        return layout;
    }

    private static int[][] toBinaryTable(int[] layout) {
        int[][] binaryTable = new int[layout.length][layout.length];
        int i = 0;
        for (int[] row : binaryTable) {
            for (int j = 0; j < layout.length; j++) {
                if ((layout[i] & 1 << j) != 0) {
                    row[j] = 1;
                }
                else {
                    row[j] = 0;
                }
            }
            i++;
        }
        return binaryTable;
    }

    private static int[][] transpose(int[][] sudoMatrix) {
        int[][] transposed = new int[sudoMatrix.length][sudoMatrix.length];
        for (int i = 0; i < sudoMatrix.length; i++) {
            for (int j = 0; j < sudoMatrix.length; j++) {
                transposed[i][j] = sudoMatrix[j][i];
            }
        }
        return transposed;
    }

    private static String[] parseHint(String binary) {
        String[] hints = binary.split("[0]+");
        for (int i = 0; i < hints.length; i++) {
            hints[i] = String.valueOf(hints[i].length());
        }
        return hints;
    }

    private static String fromIntArray(int[] array) {
        String[] strings = new String[array.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = String.valueOf(array[i]);
        }
        return String.join("",strings);
    }

    public static String[] getRowHints(int[] layout) {
        String[] hints = new String[layout.length];
        for (int i = 0; i < hints.length; i++) {
            hints[i] = (String.join(" ",
                    parseHint(new StringBuffer(Integer.toBinaryString(layout[i])).reverse().toString()))).replaceAll("0 ","");
        }
        return hints;
    }

    public static String[] getCollumnHints(int[] layout) {
        ArrayList<String> list = new ArrayList<>();
        for (int[] i : transpose(toBinaryTable(layout))) {
            list.add(String.join("\n",parseHint(fromIntArray(i))).replaceAll("0\n",""));
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
//        System.out.print(stringToBitRow("11011 11111 11111") + ", ");
//        System.out.print(stringToBitRow("10001 11111 11011") + ", ");
//        System.out.print(stringToBitRow("01100 01111 11000") + ", ");
//        System.out.print(stringToBitRow("10000 00001 10000") + ", ");
//        System.out.print(stringToBitRow("00000 00000 00001") + ", ");
//
//        System.out.print(stringToBitRow("10001 00000 01100") + ", ");
//        System.out.print(stringToBitRow("10101 10010 00100") + ", ");
//        System.out.print(stringToBitRow("00110 10111 00100") + ", ");
//        System.out.print(stringToBitRow("01100 00011 00001") + ", ");
//        System.out.print(stringToBitRow("11000 00000 01000") + ", ");
//
//        System.out.print(stringToBitRow("10000 00001 01000") + ", ");
//        System.out.print(stringToBitRow("11100 00110 01100") + ", ");
//        System.out.print(stringToBitRow("10100 01100 00110") + ", ");
//        System.out.print(stringToBitRow("11011 11000 00011") + ", ");
//        System.out.print(stringToBitRow("11111 11000 00001") + ", ");
//        System.out.println(Arrays.deepToString(transpose(toBinaryTable(Level.LEVEL0.getLayout()))));
//        System.out.println(Arrays.toString(parseHint("1110101011000101010101010101")));
//        System.out.println(Arrays.toString(getRowHints(Level.LEVEL0.getLayout())));
    }
}
