public class Ship {

    private String type;
    private int length;
    private int numHits;

    public Ship(String type, int length) {
        if (type == null || type == "" || length < 1) {
            throw new IllegalArgumentException();
        }
        this.type = type;
        this.length = length;
        this.numHits = 0;
    }

    public String getType() {
        return this.type;
    }

    public int getLength() {
        return this.length;
    }

    public int getNumHits() {
        return this.numHits;
    }

    public char getSymbol() {
        return this.getType().charAt(0);
    }

    public void applyHit() {
        this.numHits++;
    }

    public boolean isSunk() {
        return this.getNumHits() >= this.getLength();
    }

    public String toString() {
        return this.getType() + " of length " + this.getLength();
    }
}