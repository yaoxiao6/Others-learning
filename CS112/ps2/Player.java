/*
 * Player.java - blueprint class for objects that represent a single
 * "random" player in the game of Battleship.
 * 
 * Computer Science 112, Boston University
 */

import java.util.*;

public class Player {
    // a constant for the maximum number of ships per player
    public static final int SHIPS_PER_PLAYER = 5;

    // fields
    private String name;
    private Ship[] ships;
    private int numShips;

    // PS 2: add the fields for the player's collection of ships

    /*
     * constructor for a Player with the specified name
     */
    public Player(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("name must have at least one character");
        }

        this.name = name;
        this.ships = new Ship[SHIPS_PER_PLAYER];
        this.numShips = 0;
        // PS 2: initialize the fields that you added above

    }

    /*
     * getName - returns the name of the player
     */
    public String getName() {
        return this.name;
    }

    /*
     * addShip - add the specified ship to the player's collection of ships
     */
    public void addShip(Ship s) {
        if (s == null || this.numShips == SHIPS_PER_PLAYER) {
            throw new IllegalArgumentException("parameter must be non-null");
        }
        this.ships[this.numShips] = s;
        this.numShips++;
        // PS 2: add code to this method
    }

    /*
     * removeShip - removes the specified ship from the player's collection of ships
     */
    public void removeShip(Ship s) {
        if (s == null) {
            throw new IllegalArgumentException("parameter must be non-null");
        }
        int indexS = -1;
        for (int i = 0; i < this.ships.length; i++) {
            if (this.ships[i].equals(s)) {
                indexS = i;
                break;
            }
        }
        if (indexS == -1) {
            return;
        }
        this.ships[indexS] = this.ships[this.numShips - 1];
        this.ships[this.numShips - 1] = null;
        this.numShips--;

        // PS 2: add code to this method
    }

    /*
     * printShips - prints whatever ships remain in the player's collection
     */
    public void printShips() {
        if (this.ships == null || this.ships.length == 0) {
            return;
        }
        for (Ship i : this.ships) {
            if (i == null) {
                return;
            }
            System.out.println(i);
        }
        // PS 2: implement this method

    }

    /*
     * hasLost - has this player lost the game? Returns true if this is the case,
     * and false otherwise.
     */
    public boolean hasLost() {
        // PS 2: implement this method
        return this.numShips == 0;
    }

    /*
     * nextGuess - returns a Guess object representing the player's next guess for
     * the location of a ship on the board specified by the parameter otherBoard.
     */
    public Guess nextGuess(Scanner console, Board otherBoard) {
        int row;
        int col;

        // Keep randomly selecting coordinates until we get
        // a position that has not already been tried.
        do {
            row = Board.RAND.nextInt(otherBoard.getDimension());
            col = Board.RAND.nextInt(otherBoard.getDimension());
        } while (otherBoard.hasBeenTried(row, col));

        Guess guess = new Guess(row, col);
        return guess;
    }

    public int getNumShips() {
        return this.numShips;
    }

    /*
     * toString - returns a string representation of the player
     */
    public String toString() {
        return this.name;
    }
}