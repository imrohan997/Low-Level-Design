import java.util.Deque;
import java.util.LinkedList;

public class Game {
    private Board board;
    private Dice dice;
    private Deque<Player> playerDeque;
    private Player winner;

    public Game() {
        board = new Board(10,5,4);
        dice = new Dice(1);
        winner = null;
        playerDeque = new LinkedList<>();
        addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);
        playerDeque.add(player1);
        playerDeque.add(player2);
    }

    public void start() {

        while (winner == null) {
            Player playerTurn = getPlayer();
            System.out.println("Player turn is:" + playerTurn.getId() + " and Player current position is:" + playerTurn.getCurrentPosition());

            int diceCount = dice.rollDice();

            //After rolling dice we get steps we need to move as diceCount.
            int newPosition = playerTurn.getCurrentPosition() + diceCount;
            //We check if after moving diceCount number of steps, do we have Snake or Ladder at that position.
            newPosition = getJump(newPosition);
            playerTurn.setCurrentPosition(newPosition);

            System.out.println("Player turn is:" + playerTurn.getId() + " and Player new position is:" + newPosition);

            // If position of player crosses length of board then that player will win.
            if(newPosition >= board.cells.length*board.cells.length) {
                winner = playerTurn;
            }
        }
        System.out.println("Winner Player Id is:" + winner.getId());
    }

    private Player getPlayer() {
        Player player = playerDeque.remove();
        playerDeque.add(player);
        return player;
    }

    private int getJump(int newPosition) {
        if(newPosition>= board.cells.length*board.cells.length) {
            return newPosition;
        }
        Cell cell = board.getCell(newPosition);
        if (cell.getJump() != null) {
            String jump = cell.getJump().getStart() < cell.getJump().getEnd() ? "ladder" : "snake";
            System.out.println("Jump is done  by:" + jump);
            return cell.getJump().getEnd();
        }
        return newPosition;
    }

}
