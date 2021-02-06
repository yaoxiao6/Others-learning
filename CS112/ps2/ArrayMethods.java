import java.util.Arrays;

public class ArrayMethods {
    public static final String[] DAYS = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
            "Saturday" };

    // takes a reference to a string and returns the index of that string in the
    // array referred to by the class constant DAYS that you declared above
    public static int getDayIndex(String day) {
        if (day == null) {
            return -1;
        }
        for (int i = 0; i < DAYS.length; i++) {
            if (day.equalsIgnoreCase(DAYS[i])) {
                return i;
            }
        }
        return -1;
    }

    // takes a reference to an array of integers values and swaps adjacent pairs of
    // elements: values[0] with values[1], values[2] with values[3], etc.
    public static void swapAdjacent(int[] values) {
        if (values == null) {
            throw new IllegalArgumentException();
        }
        if (values.length < 2) {
            return;
        }
        for (int i = 1; i < values.length; i += 2) {
            int a = values[i];
            values[i] = values[i - 1];
            values[i - 1] = a;
        }
    }

    // takes a reference to an array of integers values and an integer cap, and that
    // creates and returns a new array based on values in which all elements greater
    // than cap are replaced by the value cap.
    public static int[] copyCapped(int[] values, int cap) {
        if (values == null) {
            throw new IllegalArgumentException();
        }

        int[] cappedValues = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            if (values[i] <= cap) {
                cappedValues[i] = values[i];
            } else {
                cappedValues[i] = cap;
            }
        }
        return cappedValues;
    }

    // takes a reference to a sorted array of integers and returns the value that
    // occurs most frequently in the array.
    public static int mostFrequentValue(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int freqNum = arr[0];
        int counter = 1;
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                counter++;
                // System.out.println("counter=" + counter);
                if (counter > max) {
                    max = counter;
                    // System.out.println("new max: " + max);
                    freqNum = arr[i - 1];
                    // System.out.println("I am " + freqNum + ", I am larger " + counter);
                }
            } else {
                if (counter > max) {
                    max = counter;
                    // System.out.println("new max: " + max);
                    freqNum = arr[i - 1];
                    // System.out.println("I am " + freqNum + ", I am larger " + counter);
                }
                counter = 1;
                // System.out.println("zero counter=" + counter);
            }
        }
        return freqNum;
    }

    public static void main(String[] args) {
        // int[] a = { 1, 2, 2, 3, 3, 4 };
        // System.out.println(mostFrequentValue(a));
        // int[] b = { 1, 1, 1, 2, 4, 4, 4, 4 };
        // System.out.println(mostFrequentValue(b));
        // int[] d = null;
        // System.out.println(mostFrequentValue(d));
        int[] c = {};
        System.out.println(mostFrequentValue(c));

    }

    // takes two arrays containing sequences of integers and that returns the index
    // of the first occurrence of the first sequence in the second sequence, or -1
    // if the first sequence does not appear in the second sequence.
    public static int indexOf(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < arr2.length; i++) {
            if (arr1[0] == arr2[i] && arr2.length >= arr1.length + i) {
                for (int j = 0; j < arr1.length; j++) {
                    if (arr1[j] != arr2[i + j]) {
                        break;
                    }
                    if (j == arr1.length - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}