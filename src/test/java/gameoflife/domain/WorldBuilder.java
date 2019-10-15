package gameoflife.domain;

import gameoflife.domain.api.ActiveCell;
import gameoflife.domain.api.WorldDto;

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
