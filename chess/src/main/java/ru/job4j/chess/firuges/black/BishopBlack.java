package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.stream.IntStream;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int deltaX = Integer.signum(dest.getX() - position.getX());
        int deltaY = Integer.signum(dest.getY() - position.getY());
        return IntStream.range(0, Math.abs(position.getX() - dest.getX()))
                .mapToObj(index -> {
                    int x = position().getX() + (index + 1) * deltaX;
                    int y = position().getY() + (index + 1) * deltaY;
                    return Cell.findBy(x, y);
                })
                .toArray(Cell[]::new);
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return source.getX() != dest.getX() && source.getY() != dest.getY()
                && Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
