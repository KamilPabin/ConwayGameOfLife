package gameoflife.domain;

import gameoflife.api.WorldDto;

public interface GameOfLife {

    void tick();
    WorldDto world();
}
