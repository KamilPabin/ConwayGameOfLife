package gameoflife.api;

public class ActiveCell {
    private final int x;
    private final int y;

    public ActiveCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
