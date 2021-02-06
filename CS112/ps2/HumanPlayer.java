import java.util.*;

public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name);
        // Scanner scan = new Scanner(System.in);
        // System.out.println("What's your name: ");
        // String name = scan.nextLine();
    }

    public Guess nextGuess(Scanner console, Board otherBoard) {
        int row;
        int col;
        System.out.println("Enter your guess.");
        System.out.print("row: ");
        row = console.nextInt();
        System.out.print("column: ");
        col = console.nextInt();
        System.out.println("your guessed: " + row + ", " + col);
        Guess guess = new Guess(row, col);
        return guess;
    }
}