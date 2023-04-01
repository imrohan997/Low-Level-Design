import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell cells[][];

    public Board(int size, int snakes, int ladders) {
        cells = new Cell[size][size];
        for (int i = 0; i < cells.length; ++i) {
            for (int j = 0; j < cells.length; ++j) {
                cells[i][j] = new Cell();
            }
        }
        initializeCells(snakes, ladders);
    }

    private void initializeCells(int snakes, int ladders) {

        while (snakes-- > 0) {
            int start = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length);

            //For snakes start should be greater than end.
            if (start < end) {
                continue;
            }

            Jump jump = new Jump();
            jump.setStart(start);
            jump.setEnd(end);

            Cell cell = getCell(start);
            cell.setJump(jump);
        }

        while (ladders-- > 0) {
            int start = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length);

            if (start > end) {
                continue;
            }

            Jump jump = new Jump();
            jump.setStart(start);
            jump.setEnd(end);

            Cell cell = getCell(start);
            cell.setJump(jump);
        }
    }

    public Cell getCell(int start) {
        int row = start / cells.length;
        int col = start % cells.length;
        return cells[row][col];
    }

}
