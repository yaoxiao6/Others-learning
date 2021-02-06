public class LinkedTree {
    // An inner class for the nodes in the tree
    private class Node {
        private int key; // the key field
        private LLList data; // list of data values for this key
        private Node left; // reference to the left child/subtree
        private Node right; // reference to the right child/subtree

        private Node(int key, Object data) {
            this.key = key;
            this.data = new LLList();
            this.data.addItem(data, 0);
            this.left = null;
            this.right = null;
        }
    }

    // the root of the tree as a whole
    private Node root;

    public LinkedTree() {
        root = null;
    }

    /*
     * FOR TESTING: Processes the integer keys in the specified array from left to
     * right, adding a node for each of them to the tree. The data associated with
     * each key is a string based on the key.
     */
    public void insertKeys(int[] keys) {
        for (int i = 0; i < keys.length; i++) {
            insert(keys[i], "data for key " + keys[i]);
        }
    }

    public static int aha() {

    }

    /*
     * determine and return the depth of the node with that key.
     */
    public int depthIter(int key) {
        LinkedTree tempTree = new LinkedTree();
        tempTree.root = this.root;
        for (int i = 0; tempTree.root != null; i++) {
            if (key == tempTree.root.key) {
                return i;
            } else if (key < tempTree.root.key) {
                tempTree.root = tempTree.root.left;
            } else {
                tempTree.root = tempTree.root.right;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // ================================================================================
        System.out.println("--- Testing aha() ---");
        System.out.println();
        System.out.println("(0) Testing on tree, depth of 13");
        try {
            LinkedTree tree = new LinkedTree();
            int[] keys = { 37, 26, 42, 13, 35, 56, 30, 47, 70 };
            tree.insertKeys(keys);

            int results = tree.depthIter(13);
            int expected = 2;
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println(expected);
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == expected);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }

        System.out.println(); // include a blank line between tests
    }
}