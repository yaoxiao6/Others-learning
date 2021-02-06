class Tanker extends Ship {
    public Tanker() {
        super("Tanker", 3);
    }

    public boolean isSunk() {
        return this.getNumHits() > 0;
    }
}