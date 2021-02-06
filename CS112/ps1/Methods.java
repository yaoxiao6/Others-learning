/*
 * Problem Set 1
 *
 * Practice with static methods, part I
 */

public class Methods {
    /*
     * printVertical - takes a string s and prints the characters of the string
     * vertically -- with one character per line.
     */
    public static void printVertical(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c);
        }
    }

    // a static method called printWithSpaces that takes a String as its parameter
    // and prints the characters of the string separated by spaces. For example, a
    // call of printWithSpaces("method") should produce the following output:
    public static void printWithSpaces(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.print(c + " ");
        }
    }

    // a static method called middleChar that takes a String object as a parameter
    // and returns the character (a value of type char) in the “middle” of the
    // string.
    public static char middleChar(String s) {
        return s.charAt((int) (s.length() / 2.0 - 0.5));
    }

    // a static method called moveToEnd that takes as its two parameters a string
    // str and an index i and returns a new string created by “moving” the first i
    // characters of str to the end of the string, after the other characters in
    // str. If the string str has i or fewer characters, the method should simply
    // return the original string.
    public static String moveToEnd(String str, int i) {
        if (str.length() < i) {
            return str;
        } else {
            return str.substring(i) + str.substring(0, i);
        }
    }

    public static void main(String[] args) {
        /* Sample test call */
        printVertical("method");

    }
}
