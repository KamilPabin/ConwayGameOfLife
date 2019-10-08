package gameoflife.domain;

import gameoflife.api.ActiveCell;
import gameoflife.api.WorldDto;

import java.util.ArrayList;

class WorldBuilder {

    private ArrayList<ActiveCell> cells;

    public WorldBuilder() {
        this.cells = new ArrayList<>();
    }

    WorldBuilder withAliveCellAt(int x, int y) {
        cells.add(new ActiveCell(x, y));
        return this;
    }

    WorldDto build() {
        return new WorldDto(cells);
    }
}
