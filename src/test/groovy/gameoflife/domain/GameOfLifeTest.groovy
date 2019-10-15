package gameoflife.domain


import gameoflife.domain.api.WorldDto
import spock.lang.Specification

class GameOfLifeTest extends Specification {

    def "Empty map should be in next tick still empty"() {
        given: "Empty world"
        GameOfLife gameOfLife = new ConwayGameOfLife()

        when: "Game moves by one game tick"
        gameOfLife.tick()
        WorldDto world = gameOfLife.world()

        then: "World is dead"
        world.isDead()
    }

    def "World with one cell should be dead in next tick"() {
        given: "World with one alive cell only"
        WorldDto worldDto = new WorldBuilder()
                .withAliveCellAt(1, 1)
                .build()
        GameOfLife gameOfLife = new ConwayGameOfLife(worldDto, 10, 10)

        when: "Game moves by one game tick"
        gameOfLife.tick()
        WorldDto world = gameOfLife.world()

        then: "World is dead"
        world.isDead()
    }

    def "World with two adjacent cells should be dead in next tick"() {
        given: "World with two adjacent cells"
        WorldDto worldDto = new WorldBuilder()
                .withAliveCellAt(1, 1)
                .withAliveCellAt(1, 2)
                .build()
        GameOfLife gameOfLife = new ConwayGameOfLife(worldDto, 10, 10)

        when: "World moves by one game tick"
        gameOfLife.tick()
        WorldDto world = gameOfLife.world()

        then: "World is dead"
        world.isDead()
    }

    def "World with three adjacent cells should stay alive"() {
        given: "World with three adjacent cells"
        WorldDto worldDto = new WorldBuilder()
                .withAliveCellAt(1, 1)
                .withAliveCellAt(1, 2)
                .withAliveCellAt(2, 1)
                .build()
        GameOfLife gameOfLife = new ConwayGameOfLife(worldDto, 10, 10)

        when: "World moves by one game tick"
        gameOfLife.tick()
        WorldDto world = gameOfLife.world()

        then: "World is alive"
        !world.isDead()
    }
}
