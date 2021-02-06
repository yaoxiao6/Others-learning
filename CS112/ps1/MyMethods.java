/*
 * Problem Set 1
 *
 * Practice with static methods, part II
 */

public class MyMethods {
    // a static method called printDecreasing that takes a String as its parameter
    // and prints decreasing substrings of the original string.
    public static void printDecreasing(String str) {
        for (int i = str.length(); i > 0; i--) {
            System.out.println(str.substring(0, i));
        }
    }

    // a static method called firstAndLast that takes a string str as its parameter
    // and returns a new string formed by combining the first and last characters of
    // str. If the string has only one character, the method should just return the
    // original string.
    public static String firstAndLast(String str) {
        if (str.length() == 1) {
            return str;
        } else {
            return str.substring(0, 1) + str.substring(str.length() - 1);
        }
    }

    // a static method called lastIndexOf that takes as its two parameters a string
    // str and a character ch and returns the index of the last occurrence of ch in
    // str. If ch does not appear in str at all, the method should return -1.
    public static int lastIndexOf(String str, char ch) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ch) {
                return i;
            }
        }
        return -1;
    }

    // a static method called repeat that takes as its two parameters a string str
    // and an integer n and returns a new string consisting of n copies of str. You
    // may assume that n is positive.
    public static String repeat(String str, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += str;
        }
        return result;
    }

}