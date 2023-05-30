package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BishopBlackTest {
    @Test
    public void whenTheSamePosition() {
        BishopBlack bishop = new BishopBlack(Cell.D2);
        Cell result = bishop.position();
        Cell expected = Cell.D2;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenCopy() {
        BishopBlack bishop = new BishopBlack(Cell.B2);
        BishopBlack bishopMove = (BishopBlack) bishop.copy(Cell.G7);
        Cell result = bishopMove.position();
        Cell expected = Cell.G7;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenWayC1ToG5() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        Cell[] result = bishop.way(Cell.E5);
        Cell[] expected = {Cell.B2, Cell.C3, Cell.D4, Cell.E5};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenIsNotDiagonal() {
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    BishopBlack bishop = new BishopBlack(Cell.A1);
                    bishop.way(Cell.D3);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from A1 to D3");
    }
}