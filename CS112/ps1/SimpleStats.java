/*
 * Problem Set 1
 * 
 * A simple interactive program that performs operations 
 * on a set of three integers.
 */

import java.util.*;

public class SimpleStats {

    public static void printMenu() {
        System.out.println("(0) Enter new numbers");
        System.out.println("(1) Find the largest");
        System.out.println("(2) Compute the sum");
        System.out.println("(3) Compute the range (largest - smallest)");
        System.out.println("(4) Compute the average");
        System.out.println("(5) Print the numbers in ascending order");
        System.out.println("(6) Quit");
        System.out.println();
    }

    /*** PUT YOUR SEPARATE HELPER METHODS FOR OPTIONS 1-5 HERE ***/

    public static int findLargest(int a, int b, int c) {
        if (a <= b && c <= b) {
            return b;
        } else if (b <= a && c <= a) {
            return a;
        } else {
            return c;
        }
    }

    public static int findSum(int a, int b, int c) {
        return a + b + c;
    }

    public static int findRange(int a, int b, int c) {
        int max = findLargest(a, b, c);
        int r1 = max - a;
        int r2 = max - b;
        int r3 = max - c;
        return findLargest(r1, r2, r3);
    }

    public static double findAvg(int a, int b, int c) {
        return findSum(a, b, c) / 3.0;
    }

    public static void printAscendingOrder(int a, int b, int c) {
        int max = findLargest(a, b, c);
        int min = max - findRange(a, b, c);
        double avg=findAvg(a, b, c);
        System.out.print(min+" ");
        if (min < a && a < max) {
            System.out.print(a+" ");
        } else if (min < b && b < max) {
            System.out.print(b+" ");
        } else if (min < c && c < max) {
            System.out.print(c+" ");
        } else if ((avg-min)>(max-avg)){
            System.out.print(max+" ");
        } else {
            System.out.print(min+" ");
        }
        System.out.print(max+" ");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // the three integers
        int n1 = 2;
        int n2 = 4;
        int n3 = 6;

        boolean more_input = true;

        do {
            System.out.print("The current numbers are: ");
            System.out.println(n1 + " " + n2 + " " + n3);

            printMenu();
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();

            /*
             * Expand this conditional statement to process choices 1-5. Make sure to follow
             * the guidelines in the assignment for doing so.
             */
            if (choice == 0) {
                System.out.print("Enter three new numbers: ");
                n1 = scan.nextInt();
                n2 = scan.nextInt();
                n3 = scan.nextInt();
            } else if(choice==1){
                System.out.println("The largest value is "+findLargest(n1, n2, n3));
            } else if(choice==2){
                System.out.println("Sum is "+findSum(n1, n2, n3));

            } else if(choice==3){
                System.out.println("Range is "+findRange(n1, n2, n3));

            } else if(choice==4){
                System.out.println("Average is "+findAvg(n1, n2, n3));

            } else if(choice==5){
                printAscendingOrder(n1, n2, n3);
            } else if (choice == 6) {
                more_input = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        } while (more_input);

        System.out.println("Have a nice day!");
    }
}
