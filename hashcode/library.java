public class library {
    private int bookNum = 0;
    private int signUpDays = 0;
    private int shipBookPerDay = 0;
    private ArrayList<Integer> books = new ArrayList<Integer>();

    public library(int bookNum, int signUpDays, int shipBookPerDay) {
        this.setBookNum(bookNum);
        this.setSignUpDays(signUpDays);
        this.setShipBookPerDay(shipBookPerDay);
    }

    public int getBookNum() {
        return this.bookNum;
    }

    public int getSignUpDays() {
        return this.signUpDays;
    }

    public int getShipBookPerDay() {
        return this.shipBookPerDay;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public void setSignUpDays(int signUpDays) {
        this.signUpDays = signUpDays;
    }

    public void setShipBookPerDay(int shipBookPerDay) {
        this.shipBookPerDay = shipBookPerDay;
    }
}