public class StringRecursion {

    // This method should use recursion to print the individual characters in the
    // string str in reverse order.
    public static void printReverse(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        printReverse(str.substring(1));
        System.out.print(str.charAt(0));
    }

    // This method should take a string str and use recursion to return a string in
    // which any leading and/or trailing spaces in the original string are removed.
    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }
        if (str.substring(0, 1).equals(" ")) {
            return trim(str.substring(1));
        }
        if (str.substring(str.length() - 1).equals(" ")) {
            return trim(str.substring(0, str.length() - 1));
        }
        return str;
    }

    // This method should use recursion to find and return the index of the first
    // occurrence of the character ch in the string str, or -1 if ch does not occur
    // in str.
    public static int find(char ch, String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int rest = find(ch, str.substring(0, str.length() - 1));
        if (rest > -1) {
            return rest;
        }
        if (str.charAt(str.length() - 1) == ch) {
            return str.length() - 1;
        }
        return rest;
    }

    public static void main(String[] args) {
        System.out.println("[" + trim("      ") + "]");
    }
}