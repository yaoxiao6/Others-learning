
public class Final {
    public static int process(String s1, String s2, char c) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException();
        }
        int n = 0;
        int counter = 0;
        for (int i = 0; i < s1.length() || i < s2.length(); i++) {
            if (i < s1.length() && i < s2.length()) {
                n = i;
            }
            if (i < s1.length() && s1.charAt(i) == c) {
                counter++;
                // System.out.println("ONE");
            }
            if (i < s2.length() && s2.charAt(i) == c) {
                counter++;
                // System.out.println("TWO");
            }
        }
        System.out.println(s1.substring(0, n + 1));
        return counter;
    }

    public static int find(Node root) {

        if (root == null || root.left == null) {
            return -1;
        }
        Node trav = root.left;
        int max = trav.key;
        while (trav != null) {

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(process("hello", "all", 'l'));
    }
}