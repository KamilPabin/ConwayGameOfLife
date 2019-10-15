package gameoflife.domain;

import gameoflife.domain.api.WorldDto;

public interface GameOfLife {

    void tick();
    WorldDto world();
}
