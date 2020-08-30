package levels;

public enum Level {

    LEVEL0(0,15, new int[15]);

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

    public Level nextLevel(Level current) {
        for (Level l : Level.values()) {
            if (l.getStage() == current.getStage() + 1) {
                current = l;
                break;
            }
        }
        return current;
    }
}
