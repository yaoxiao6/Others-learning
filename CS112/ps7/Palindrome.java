/*
 * Palindrome.java
 *
 * Computer Science 112
 *
 * Modifications and additions by:
 *     name:
 *     username:
 */

public class Palindrome {
    // Add your definition of isPal here.
    public static boolean isPal(String s) {
        LLStack invS = new LLStack();
        LLQueue copyS = new LLQueue();
        int len = s.length();

        // copy letters in S into a stack and a queue.
        for (int i = 0; i < len; i++) {
            char charFront = Character.toUpperCase(s.charAt(i));
            if ('A' <= charFront && charFront <= 'Z') {
                invS.push(charFront);
                copyS.insert(charFront);
            }
        }

        // check elements in invS(stack) and copyS(queue)
        while (!invS.isEmpty() /* && copyS.isEmpty() */) {
            if (!invS.pop().equals(copyS.remove())) {
                return false;
            }
        }
        return true;
    }

    
    public static void main(String[] args) {
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(0) Testing on \"A man, a plan, a canal, Panama!\"");
        try {
            boolean results = isPal("A man, a plan, a canal, Panama!");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }

        System.out.println(); // include a blank line between tests

        /*
         * Add five more unit tests that test a variety of different cases. Follow the
         * same format that we have used above.
         */

        System.out.println("(1) Testing on \"A man, nam. A ? !\"");
        try {
            boolean results = isPal("A man, nam. A ? !");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }

        System.out.println();

        System.out.println("(2) Testing on \"A. bc! De, EdC.   Ba!\"");
        try {
            boolean results = isPal("A. bc! De, EdC.   Ba!");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }

        System.out.println();

        System.out.println("(3) Testing on \"Only! My! Railgun!\"");
        try {
            boolean results = isPal("Only! My! Railgun!");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("false");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == false);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }

        System.out.println();

        System.out.println("(4) Testing on \"Happy, YppAh.\"");
        try {
            boolean results = isPal("Happy, YppAh.");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }

        System.out.println();

        System.out.println("(5) Testing on \"Study hard, play hard.\"");
        try {
            boolean results = isPal("Study hard, play hard.");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("false");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == false);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }

        System.out.println();
    }
}