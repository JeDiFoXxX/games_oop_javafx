package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.stream.IntStream;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Cell[] steps = figures[index].way(dest);
        free(steps);
        figures[index] = figures[index].copy(dest);
    }

    private boolean free(Cell[] steps) throws OccupiedCellException {
        boolean result = Arrays.stream(steps)
                .anyMatch(step -> Arrays.stream(figures)
                        .noneMatch(figure -> figure.position().equals(step)));
        if (result) {
            return true;
        }
        throw new OccupiedCellException("Cell is occupied.");
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        return IntStream.range(0, figures.length)
                .filter(index -> figures[index] != null)
                .filter(index -> figures[index].position().equals(cell))
                .findFirst()
                .orElseThrow(() -> new FigureNotFoundException("Figure not found on the board."));

    }
}
