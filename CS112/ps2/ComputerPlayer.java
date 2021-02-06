import java.util.*;

public class ComputerPlayer extends Player {
    public int[] lastGuess = new int[2];
    // private int numComputerShips;

    public ComputerPlayer(String name) {
        super(name);
    }

    public Guess nextGuess(Scanner console, Board otherBoard) {
        Guess randomGuess = super.nextGuess(console, otherBoard);
        this.lastGuess[0] = randomGuess.getRow();
        this.lastGuess[1] = randomGuess.getColumn();
        if (otherBoard.previousHit(this.lastGuess[0], this.lastGuess[1])) {
            if (this.lastGuess[0] < otherBoard.getDimension() - 1
                    && otherBoard.hasBeenTried(this.lastGuess[0] + 1, this.lastGuess[1])) {
                this.lastGuess[0]++;
            } else if (this.lastGuess[0] > 1 && otherBoard.hasBeenTried(this.lastGuess[0] - 1, this.lastGuess[1])) {
                this.lastGuess[0]--;
            } else if (this.lastGuess[1] < otherBoard.getDimension() - 1
                    && otherBoard.hasBeenTried(this.lastGuess[0], this.lastGuess[1] + 1)) {
                this.lastGuess[1]++;
            } else if (this.lastGuess[1] > 1 && otherBoard.hasBeenTried(this.lastGuess[0], this.lastGuess[1] - 1)) {
                this.lastGuess[1]--;
            }
        }
        Guess guess = new Guess(this.lastGuess[0], this.lastGuess[1]);
        return guess;
    }
}