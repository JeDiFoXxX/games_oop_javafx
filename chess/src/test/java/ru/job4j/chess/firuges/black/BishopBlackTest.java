package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;

class BishopBlackTest {

    @Test
    void whenPositionIsF8() {
        Figure figure = new BishopBlack(Cell.F8);
        assertThat(figure.position()).isEqualTo(Cell.F8);
    }

    @Test
    void whenCopyThenNewPosition() {
        Figure figure = new BishopBlack(Cell.F8);
        Figure newPosition = figure.copy(Cell.A3);
        assertThat(newPosition.position()).isEqualTo(Cell.A3);
    }

    @Test
    void whenWayFigureFromC1ToG5() {
        Figure figure = new BishopBlack(Cell.C1);
        figure.way(Cell.G5);
    }
}