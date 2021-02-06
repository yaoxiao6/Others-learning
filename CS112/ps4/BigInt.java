
/* 
 BigInt.java
 *
 A class for objects that represent non-negative integers of 
 up to 20 digits.
 */
import java.util.Arrays;

public class BigInt {
    // the maximum number of digits in a BigInt -- and thus the length
    // of the digits array
    private static final int SIZE = 20;

    // the array of digits for this BigInt object
    private int[] digits;

    // the number of significant digits in this BigInt object
    private int numSigDigits;

    /*
     * Default, no-argument constructor -- creates a BigInt that represents the
     * number 0.
     */
    public BigInt() {
        this.digits = new int[SIZE];
        this.numSigDigits = 1; // 0 has one sig. digit--the rightmost 0!
    }

    // use the contents of the array that is passed in as the basis of the new
    // BigInt object.
    public BigInt(int[] arr) {
        if (arr == null || arr.length > SIZE) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > 9) {
                throw new IllegalArgumentException();
            }
        }
        this.digits = new int[SIZE];
        int j = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            this.digits[SIZE - j] = arr[i];
            j++;
        }
        this.calculateSigDigits();
    }

    // calculate the signicficant digits of this.digits and assign it to
    // this.numSigDigits.
    private void calculateSigDigits() {
        int indexNotZero = 0;
        boolean allZero = true;
        for (int i = 0; i < SIZE; i++) {
            if (this.digits[i] != 0) {
                indexNotZero = i;
                allZero = false;
                break;
            }
        }
        this.numSigDigits = SIZE - indexNotZero;
        if (allZero) {
            this.numSigDigits = 1;
        }
    }

    public BigInt(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.digits = new int[SIZE];
        if (n == 0) {
            this.numSigDigits = 1;
            return;
        }
        // this.numSigDigits = Integer.toString(n).length(); // can we use the fucking
        // integer.toString()????????????????????????????????????????????????????????????????????????????????????????????????????????
        this.numSigDigits = 0;
        int i = 1;
        do {
            this.digits[SIZE - i] = n % 10;
            i++;
            n = n / 10;
            this.numSigDigits++;
        } while (n > 0);
    }

    // an accessor method called getNumSigDigits() that returns the value of the
    // numSigDigits field.
    public int getNumSigDigits() {
        return this.numSigDigits;
    }

    // return a string that can be used to print a BigInt object in the way that we
    // would ordinarily write the corresponding integer—with no leading zeroes.
    public String toString() {
        String num = "";
        for (int i = SIZE - this.getNumSigDigits(); i < SIZE; i++) {
            num += this.digits[i];
        }
        return num;
    }

    // This method should compare the called BigInt object to the parameter other
    // and return:
    // -1 if integer represented by the called object is less than the integer
    // represented by other
    // 0 if integer represented by the called object is equal to
    // the integer represented by other
    // 1 if integer represented by the called object is greater than the integer
    // represented by other
    public int compareTo(BigInt other) {
        if (other == null) {
            throw new IllegalArgumentException();
        }
        if (this.getNumSigDigits() > other.getNumSigDigits()) {
            return 1;
        } else if (this.getNumSigDigits() < other.getNumSigDigits()) {
            return -1;
        } else {
            for (int i = SIZE - this.getNumSigDigits(); i < SIZE; i++) {
                if (this.digits[i] > other.digits[i]) {
                    return 1;
                } else if (this.digits[i] < other.digits[i]) {
                    return -1;
                }
            }
        }
        return 0;
    }

    // create and return a new BigInt object for the sum of the integers represented
    // by the called object and other.
    public BigInt add(BigInt other) {
        if (other == null) {
            throw new IllegalArgumentException();
        }
        BigInt sum = new BigInt();
        int carry = 0;
        for (int i = SIZE - 1; i >= 0; i--) {
            sum.digits[i] = (this.digits[i] + other.digits[i] + carry) % 10;
            carry = (this.digits[i] + other.digits[i] + carry) / 10;
            System.out.println(carry);
        }
        if (carry == 1) {
            throw new ArithmeticException();
        }
        sum.calculateSigDigits();
        return sum;
    }

    // create and return a new BigInt object for the product of the integers
    // represented by the called object and other.
    public BigInt mul(BigInt other) {
        if (other == null) {
            throw new IllegalArgumentException();
        }
        // System.out.println(Arrays.toString(this.digits));
        // System.out.println(Arrays.toString(other.digits));
        BigInt[] muls = new BigInt[SIZE];
        // System.out.println(Arrays.toString(muls));
        BigInt mul = new BigInt();
        // System.out.println(Arrays.toString(mul.digits));
        int carry = 0;
        int a = 0;
        for (int i = SIZE - 1; i >= SIZE - this.getNumSigDigits(); i--) {
            muls[i] = new BigInt();
            a = 0;
            carry = 0;
            for (int j = SIZE - 1; j >= SIZE - other.getNumSigDigits(); j--) {
                // System.out.println("this digits is " + this.digits[i] + " other digits is " +
                // other.digits[j]);
                if (i >= a) {
                    muls[i].digits[i - a] = (this.digits[i] * other.digits[j] + carry) % 10;
                }
                // System.out.println(muls[i].digits[i - a]);
                carry = (this.digits[i] * other.digits[j] + carry) / 10;
                // System.out.println("carry is " + carry);
                a++;
            }
            if (i == a && carry > 0) {
                throw new ArithmeticException();
            }
            if (i >= a) {
                muls[i].digits[i - a] = carry;
            }
            // System.out.println(Arrays.toString(muls[i].digits));
        }
        // System.out.println(Arrays.toString(muls));
        mul = muls[SIZE - 1].add(muls[SIZE - 2]);
        for (int i = SIZE - 3; i >= SIZE - this.getNumSigDigits(); i--) {
            mul = mul.add(muls[i]);
        }

        mul.calculateSigDigits();
        return mul;
    }

    public static void main(String[] args) {
    }
}