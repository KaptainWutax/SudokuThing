package levels;

public enum Level {

    LEVEL0(0,15, Layouts.level0);

    private final int stage;
    private final int size;
    private final int[] layout;

    
    Level(int stage, int size, int[] layout) {
        this.stage = stage;
        this.size = size;
        this.layout = layout;
    }

    public int getStage() {
        return stage;
    }

    public int getSize() {
        return size;
    }

    public int[] getLayout() {
        return layout;
    }

    public static Level nextLevel(Level current) {
        for (Level l : Level.values()) {
            if (l.getStage() == current.getStage() + 1) {
                current = l;
                break;
            }
        }
        return current;
    }

}
class Layouts{
    public static final int[] level0 = {
            32763, 28657, 4038, 1537, 16384, 6161, 4405, 5036, 17158, 2051, 2561, 6535, 12485, 24699, 16511
    };
}
