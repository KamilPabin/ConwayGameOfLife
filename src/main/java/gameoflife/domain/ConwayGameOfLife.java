package gameoflife.domain;

import gameoflife.api.WorldDto;

import java.util.Collections;

public class ConwayGameOfLife implements GameOfLife {

    private final World world;

    public ConwayGameOfLife(WorldDto worldDto) {
        this.world = new WorldImpl(worldDto);
    }

    @Override
    public void tick() {

    }

    @Override
    public WorldDto world() {
        return new WorldDto(Collections.emptyList());
    }
}
