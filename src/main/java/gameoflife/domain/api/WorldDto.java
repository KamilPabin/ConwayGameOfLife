package gameoflife.domain.api;

import java.util.List;

public class WorldDto {

    private final List<ActiveCell> activeCells;

    public WorldDto(List<ActiveCell> activeCells) {
        this.activeCells = activeCells;
    }

    public boolean isDead() {
        return activeCells.isEmpty();
    }

    public List<ActiveCell> getActiveCells() {
        return activeCells;
    }

    public boolean hasActiveCellAt(int x, int y) {
        return activeCells.stream().anyMatch(cell -> cell.getX() == x && cell.getY() == y);
    }

    @Override
    public String toString() {
        return "WorldDto{" +
                "activeCells=" + activeCells +
                '}';
    }
}