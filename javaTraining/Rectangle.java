package AP_CS;

public class Rectangle {
    private int width;
    private int height;
    private final int lines = 4;

    getLines(){
        return this.lines;
    }

    setLines(){
        this.lines = 5;
    }

    public int getWidth() {
        return this.width;
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int area() {
        return this.width * this.height;
    }

    public static boolean isSquare(int wid, int height) {
        return wid == height;
    }

    public static void main(String[] args) {
        Rectangle a = new Rectangle(10, 10);
        int width = a.getWidth();
        System.out.println(width);

}