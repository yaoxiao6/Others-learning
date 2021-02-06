/*
 * Test program for PS 1, MyMethods class
 *
 * Put this program in the same folder as your MyMethods.java.
 *
 * If it doesn't compile, that means that one or more of your methods
 * does not have the correct header -- i.e., either the return type
 * or the parameters are incorrect.
 *
 * The correct results to these method calls are given in the assignment.
 */

public class TestMyMethods {
    public static void main(String[] args) {
        System.out.println("** part 1 **");
        MyMethods.printDecreasing("method");
        System.out.println();
        
        System.out.println("** part 2, example 1 **");
        String str1 = MyMethods.firstAndLast("Boston");
        System.out.println(str1);
        System.out.println();
 
        System.out.println("** part 2, example 2 **");
        String str2 = MyMethods.firstAndLast("University");
        System.out.println(str2);
        System.out.println();
        
        System.out.println("** part 2, example 3 **");
        String str3 = MyMethods.firstAndLast("a");
        System.out.println(str3);
        System.out.println();

        System.out.println("** part 3, example 1 **");
        int index1 = MyMethods.lastIndexOf("Boston", 'o');
        System.out.println(index1);
        System.out.println();

        System.out.println("** part 3, example 2 **");
        int index2 = MyMethods.lastIndexOf("banana", 'a');
        System.out.println(index2);
        System.out.println();

        System.out.println("** part 3, example 3 **");
        int index3 = MyMethods.lastIndexOf("banana", 'b');
        System.out.println(index3);
        System.out.println();

        System.out.println("** part 3, example 4 **");
        int index4 = MyMethods.lastIndexOf("banana", 'x');
        System.out.println(index4);
        System.out.println();
        
        System.out.println("** part 4, example 1 **");
        String str4 = MyMethods.repeat("Java", 3);
        System.out.println(str4);
        System.out.println();
        
        System.out.println("** part 4, example 2 **");
        String str5 = MyMethods.repeat("oh!", 7);
        System.out.println(str5);
        System.out.println();
    }
}
