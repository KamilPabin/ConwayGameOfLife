package gameoflife.domain;

import gameoflife.api.WorldDto;

import java.util.Collections;
import java.util.Set;

class WorldImpl implements World {

    private final Set<Cell> cells;

     WorldImpl(WorldDto worldDto) {
     this.cells = Collections.emptySet();
     }

    @Override
    public int worldPopulation() {
        return cells.size();
    }
}
