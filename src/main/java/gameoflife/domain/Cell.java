package gameoflife.domain;

import java.util.Set;

class Cell {

    private final int x;
    private final int y;
    private final Set<Cell> neighbourhood;

    Cell(int x, int y, Set<Cell> neighbourhood) {
        this.x = x;
        this.y = y;
        this.neighbourhood = neighbourhood;
    }
}
