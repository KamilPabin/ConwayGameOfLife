package gameoflife.domain;

import gameoflife.domain.api.ActiveCell;
import gameoflife.domain.api.WorldDto;

import java.util.ArrayList;
import java.util.List;

class BoundedWorld implements World {

    private final int width;
    private final int height;
    private boolean[][] cells;

    BoundedWorld(WorldDto worldDto, int width, int height) {
        this.width = width;
        this.height = height;

        cells = new boolean[width][height];
        worldDto.getActiveCells()
                .forEach(cell -> cells[cell.getX()][cell.getY()] = true);
    }

    private BoundedWorld(boolean[][] cells, int width, int height) {
        this.cells = cells;
        this.width = width;
        this.height = height;

    }

    static World singular() {
        return new BoundedWorld(new boolean[0][0], 0, 0);
    }

    @Override
    public int worldPopulation() {
        int count = 0;
        for (boolean[] cellLine : cells) {
            for (boolean cell : cellLine) {
                if (cell) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public WorldDto dto() {
        int x = 0;
        int y = 0;
        List<ActiveCell> activeCells = new ArrayList<>();
        for (boolean[] cellLine : cells) {
            for (boolean cell : cellLine) {
                if (cell) {
                    activeCells.add(new ActiveCell(x, y));
                }
                x++;
            }
            x = 0;
            y++;
        }
        return new WorldDto(activeCells);
    }

    @Override
    public void evolve() {
        int x = 0;
        int y = 0;
        boolean[][] nextState = new boolean[width][height];
        for (boolean[] cellLine : cells) {
            for (boolean cell : cellLine) {
                int neighbourSize = neighbourhoodSize(x, y);
                if (neighbourSize < 2) {
                    nextState[x][y] = false;
                }
                if (neighbourSize == 3) {
                    nextState[x][y] = true;
                }
                if (neighbourSize > 3) {
                    nextState[x][y] = false;
                }
                x++;
            }
            x = 0;
            y++;
        }
        cells = nextState;
    }

    private int neighbourhoodSize(int x, int y) {
        int neighbourSize = 0;
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                try {
                    if (cells[i][j]) {
                        neighbourSize++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }
            }
        }
        return neighbourSize;
    }
}
