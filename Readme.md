# Conway Game of Life

## What is Conway's Game of Life
This simple projects implements game described by mathematician John Horton Conway in 1970.
This game happens on a infinite cellular board, in which each of cells can be in one of two states: dead or alive.
Living cycles happens in ticks, next state of the world is calculated according to four rules:
* Any alive cell with less than two neighbours dies from under population
* Any alive cell that has two or three neighbours stays alive
* Any alive cell with more than three neighbours dies due to overpopulation
* Any dead cell with exactly three neighbours come to life as of reproduction

For more information on Conway's Game of Life or patterns that can be created please visit Wikipedia: https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life

## Application
Application is written in pure Java 11 without frameworks. Gradle is used as a project management tool.
Spock framework is used for writing tests in groovy. Purpose of this project is to learn more
on creating flexible architecture, SOLID and software development in general. Domain should be
separated from any infrastructure, that is why at the beginning there is no framework.

## Tests
To run tests `./gradlew test`