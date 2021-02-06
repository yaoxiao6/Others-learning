public class Time {
    private int hour;
    private int min;

    public Time(int h, int m) {
        this.hour = h;
        this.min = m;
    }

    public void setHour(int newH) {
        this.hour = newH;
    }

    public int minuteUntilMidnight() {
        return 60 - this.min + 60 * (23 - this.hour);
    }

    public static void main(String[] args) {
        int h = 22;
        int m = 15;
        Time t3 = new Time(h, m);
        int result = t3.minuteUntilMidnight();
        System.out.println(result);
    }
}