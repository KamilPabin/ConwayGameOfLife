package gameoflife.domain;

import gameoflife.domain.api.WorldDto;

interface World {

    int worldPopulation();

    WorldDto dto();

    void evolve();
}
