package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(figure.way(Cell.G5)).isEqualTo(expected);
    }

    @Test
    void whenInvalidMove() {
        Figure figure = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    figure.way(Cell.C7);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from C1 to C7");
    }
}