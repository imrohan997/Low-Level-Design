import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int diceCount;
    private final int min = 1;
    private final int max = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int sum = 0;
        int count = diceCount;

        //Based on number of dices provided in a game we calculate moves to be moved.
        while (count-- > 0) {
            sum += ThreadLocalRandom.current().nextInt(min, max + 1);
        }
        return sum;
    }
}
