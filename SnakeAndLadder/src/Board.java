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

        //Adding snakes in board
        while (snakes-- > 0) {
            int start = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length);

            //For snakes start should be greater than end.
            if (start < end) {
                continue;
            }

            //Setting jump with start and end for a cell with start index.
            Jump jump = new Jump();
            jump.setStart(start);
            jump.setEnd(end);

            Cell cell = getCell(start);
            cell.setJump(jump);
        }

        //Adding ladders in board
        while (ladders-- > 0) {
            int start = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length);

            //For ladders start should be less than end.
            if (start > end) {
                continue;
            }

            //Setting jump with start and end for a cell with start index.
            Jump jump = new Jump();
            jump.setStart(start);
            jump.setEnd(end);

            Cell cell = getCell(start);
            cell.setJump(jump);
        }
    }

    //Return cell in a cells matrix by taking position as input.
    public Cell getCell(int position) {
        int row = position / cells.length;
        int col = position % cells.length;
        return cells[row][col];
    }

}
