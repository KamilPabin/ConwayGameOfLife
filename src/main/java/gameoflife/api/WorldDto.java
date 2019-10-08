package gameoflife.api;

import java.util.List;

public class WorldDto {

    private final List<ActiveCell> activeCells;

    public WorldDto(List<ActiveCell> activeCells) {
        this.activeCells = activeCells;
    }

    public boolean isDead() {
        return activeCells.isEmpty();
    }
}