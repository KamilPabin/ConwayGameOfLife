package gameoflife.domain;

import gameoflife.domain.api.WorldDto;

public class ConwayGameOfLife implements GameOfLife {

    private final World world;

    public ConwayGameOfLife() {
        this.world = BoundedWorld.singular();
    }

    public ConwayGameOfLife(WorldDto worldDto, int width, int height) {
        this.world = new BoundedWorld(worldDto, width, height);
    }

    @Override
    public void tick() {
        world.evolve();
    }

    @Override
    public WorldDto world() {
        return world.dto();
    }
}
