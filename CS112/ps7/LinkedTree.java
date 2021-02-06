/*
 * LinkedTree.java
 *
 * Computer Science 112
 *
 * Modifications and additions by:
 *     name:
 *     username:
 */

import java.util.*;

/*
 * LinkedTree - a class that represents a binary tree containing data
 * items with integer keys.  If the nodes are inserted using the
 * insert method, the result will be a binary search tree.
 */
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
     * Prints the keys of the tree in the order given by a preorder traversal.
     * Invokes the recursive preorderPrintTree method to do the work.
     */
    public void preorderPrint() {
        if (root != null) {
            preorderPrintTree(root);
        }
        System.out.println();
    }

    /*
     * Recursively performs a preorder traversal of the tree/subtree whose root is
     * specified, printing the keys of the visited nodes. Note that the parameter is
     * *not* necessarily the root of the entire tree.
     */
    private static void preorderPrintTree(Node root) {
        System.out.print(root.key + " ");
        if (root.left != null) {
            preorderPrintTree(root.left);
        }
        if (root.right != null) {
            preorderPrintTree(root.right);
        }
    }

    /*
     * Prints the keys of the tree in the order given by a postorder traversal.
     * Invokes the recursive postorderPrintTree method to do the work.
     */
    public void postorderPrint() {
        if (root != null) {
            postorderPrintTree(root);
        }
        System.out.println();
    }

    /*
     * Recursively performs a postorder traversal of the tree/subtree whose root is
     * specified, printing the keys of the visited nodes. Note that the parameter is
     * *not* necessarily the root of the entire tree.
     */
    private static void postorderPrintTree(Node root) {
        if (root.left != null) {
            postorderPrintTree(root.left);
        }
        if (root.right != null) {
            postorderPrintTree(root.right);
        }
        System.out.print(root.key + " ");
    }

    /*
     * Prints the keys of the tree in the order given by an inorder traversal.
     * Invokes the recursive inorderPrintTree method to do the work.
     */
    public void inorderPrint() {
        if (root != null) {
            inorderPrintTree(root);
        }
        System.out.println();
    }

    /*
     * Recursively performs an inorder traversal of the tree/subtree whose root is
     * specified, printing the keys of the visited nodes. Note that the parameter is
     * *not* necessarily the root of the entire tree.
     */
    private static void inorderPrintTree(Node root) {
        if (root.left != null) {
            inorderPrintTree(root.left);
        }
        System.out.print(root.key + " ");
        if (root.right != null) {
            inorderPrintTree(root.right);
        }
    }

    /*
     * Inner class for temporarily associating a node's depth with the node, so that
     * levelOrderPrint can print the levels of the tree on separate lines.
     */
    private class NodePlusDepth {
        private Node node;
        private int depth;

        private NodePlusDepth(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    /*
     * Prints the keys of the tree in the order given by a level-order traversal.
     */
    public void levelOrderPrint() {
        LLQueue<NodePlusDepth> q = new LLQueue<NodePlusDepth>();

        // Insert the root into the queue if the root is not null.
        if (root != null) {
            q.insert(new NodePlusDepth(root, 0));
        }

        // We continue until the queue is empty. At each step,
        // we remove an element from the queue, print its value,
        // and insert its children (if any) into the queue.
        // We also keep track of the current level, and add a newline
        // whenever we advance to a new level.
        int level = 0;
        while (!q.isEmpty()) {
            NodePlusDepth item = q.remove();

            if (item.depth > level) {
                System.out.println();
                level++;
            }
            System.out.print(item.node.key + " ");

            if (item.node.left != null) {
                q.insert(new NodePlusDepth(item.node.left, item.depth + 1));
            }
            if (item.node.right != null) {
                q.insert(new NodePlusDepth(item.node.right, item.depth + 1));
            }
        }
        System.out.println();
    }

    /*
     * Searches for the specified key in the tree. If it finds it, it returns the
     * list of data items associated with the key. Invokes the recursive searchTree
     * method to perform the actual search.
     */
    public LLList search(int key) {
        Node n = searchTree(root, key);
        if (n == null) {
            return null;
        } else {
            return n.data;
        }
    }

    /*
     * Recursively searches for the specified key in the tree/subtree whose root is
     * specified. Note that the parameter is *not* necessarily the root of the
     * entire tree.
     */
    private static Node searchTree(Node root, int key) {
        if (root == null) {
            return null;
        } else if (key == root.key) {
            return root;
        } else if (key < root.key) {
            return searchTree(root.left, key);
        } else {
            return searchTree(root.right, key);
        }
    }

    /*
     * Inserts the specified (key, data) pair in the tree so that the tree remains a
     * binary search tree.
     */
    public void insert(int key, Object data) {
        // Find the parent of the new node.
        Node parent = null;
        Node trav = root;
        while (trav != null) {
            if (trav.key == key) {
                trav.data.addItem(data, 0);
                return;
            }
            parent = trav;
            if (key < trav.key) {
                trav = trav.left;
            } else {
                trav = trav.right;
            }
        }

        // Insert the new node.
        Node newNode = new Node(key, data);
        if (parent == null) { // the tree was empty
            root = newNode;
        } else if (key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
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

    /*
     * Deletes the node containing the (key, data) pair with the specified key from
     * the tree and return the associated data item.
     */
    public LLList delete(int key) {
        // Find the node to be deleted and its parent.
        Node parent = null;
        Node trav = root;
        while (trav != null && trav.key != key) {
            parent = trav;
            if (key < trav.key) {
                trav = trav.left;
            } else {
                trav = trav.right;
            }
        }

        // Delete the node (if any) and return the removed data item.
        if (trav == null) { // no such key
            return null;
        } else {
            LLList removedData = trav.data;
            deleteNode(trav, parent);
            return removedData;
        }
    }

    /*
     * Deletes the node specified by the parameter toDelete. parent specifies the
     * parent of the node to be deleted.
     */
    private void deleteNode(Node toDelete, Node parent) {
        if (toDelete.left != null && toDelete.right != null) {
            // Case 3: toDelete has two children.
            // Find a replacement for the item we're deleting -- as well as
            // the replacement's parent.
            // We use the smallest item in toDelete's right subtree as
            // the replacement.
            Node replaceParent = toDelete;
            Node replace = toDelete.right;
            while (replace.left != null) {
                replaceParent = replace;
                replace = replace.left;
            }

            // Replace toDelete's key and data with those of the
            // replacement item.
            toDelete.key = replace.key;
            toDelete.data = replace.data;

            // Recursively delete the replacement item's old node.
            // It has at most one child, so we don't have to
            // worry about infinite recursion.
            deleteNode(replace, replaceParent);
        } else {
            // Cases 1 and 2: toDelete has 0 or 1 child
            Node toDeleteChild;
            if (toDelete.left != null) {
                toDeleteChild = toDelete.left;
            } else {
                toDeleteChild = toDelete.right; // null if it has no children
            }

            if (toDelete == root) {
                root = toDeleteChild;
            } else if (toDelete.key < parent.key) {
                parent.left = toDeleteChild;
            } else {
                parent.right = toDeleteChild;
            }
        }
    }

    /*
     * "wrapper method" for the recursive depthInTree() method from PS 7, Problem 6
     */
    public int depth(int key) {
        if (root == null) { // root is the root of the entire tree
            return -1;
        }

        return depthInTree(key, root);
    }

    /*
     * original version of the recursive depthInTree() method from PS 7, Problem 6.
     * You will write a more efficient version of this method.
     */
    private static int depthInTree(int key, Node root) {
        if (key == root.key) {
            return 0;
        }

        if (key < root.key) {
            if (root.left != null) {
                int depthInLeft = depthInTree(key, root.left);
                if (depthInLeft != -1) {
                    return depthInLeft + 1;
                }
            }
        } else {
            if (root.right != null) {
                int depthInRight = depthInTree(key, root.right);
                if (depthInRight != -1) {
                    return depthInRight + 1;
                }
            }
        }
        return -1;
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

    /*
     * make the initial call to that method – passing in the root of the tree as a
     * whole – and it should return whatever value that method returns.
     */
    public int numLeafNodes() {
        return numLeafNodesInTree(this.root);
    }

    /*
     * find and return the number of leaf nodes in the binary search tree or subtree
     * whose root node is specified by the parameter.
     */
    private static int numLeafNodesInTree(Node trav) {
        if (trav == null) {
            return 0;
        }
        if (trav.left == null && trav.right == null) {
            return 1;
        }
        int rest = 0;
        if (trav.left != null) {
            rest += numLeafNodesInTree(trav.left);
        }
        if (trav.right != null) {
            rest += numLeafNodesInTree(trav.right);
        }
        return rest;
    }

    /*
     * uses iteration to find and delete the node containing the smallest key in the
     * tree; it should also return the value of the key whose node was deleted. If
     * the tree is empty when the method is called, the method should return -1.
     */
    public int deleteSmallest() {
        if (this.root == null) {
            return -1;
        }
        Node trav = this.root;
        Node travParent = trav;
        while (trav.left != null) {
            travParent = trav;
            trav = trav.left;
        }
        int minKey = trav.key;
        travParent.left = trav.right;
        return minKey;
    }

    public static int aha(Node root) {
        int rest = 0;
        Node trav = root;
        if (trav == null) {
            return -1;
        }
        while (trav.left == null && trav.right == null) {
            if (trav.left != null) {
                trav = trav.left;
            } else if (trav.right != null) {
                trav = trav.right;
            }
            return 0;
        }
        rest = aha(trav.left) + 1;
        rest = aha(trav.right) + 1;
        return 0;
    }

    public static void main(String[] args) {
        LinkedTree tree = new LinkedTree();
        int[] keys = { 37, 26, 42, 13, 35, 56, 30, 47, 70 };
        tree.insertKeys(keys);
        int results = tree.aha(tree.root);
        System.out.println(results);

        // //
        // ================================================================================
        // System.out.println("--- Testing depthIter() from Problem 9 ---");
        // System.out.println();
        // System.out.println("(0) Testing on tree from Problem 9, depth of 13");
        // try {
        // LinkedTree tree = new LinkedTree();
        // int[] keys = { 37, 26, 42, 13, 35, 56, 30, 47, 70 };
        // tree.insertKeys(keys);

        // int results = tree.depthIter(13);
        // int expected = 2;
        // System.out.println("actual results:");
        // System.out.println(results);
        // System.out.println("expected results:");
        // System.out.println(expected);
        // System.out.print("MATCHES EXPECTED RESULTS?: ");
        // System.out.println(results == expected);
        // } catch (Exception e) {
        // System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        // }

        // System.out.println(); // include a blank line between tests

        // System.out.println("(1) Testing on tree from Problem 9, depth of 47");
        // try {
        // LinkedTree tree = new LinkedTree();
        // int[] keys = {37, 26, 42, 13, 35, 56, 30, 47, 70};
        // tree.insertKeys(keys);

        // int results = tree.depthIter(47);
        // int expected = 3;
        // System.out.println("actual results:");
        // System.out.println(results);
        // System.out.println("expected results:");
        // System.out.println(expected);
        // System.out.print("MATCHES EXPECTED RESULTS?: ");
        // System.out.println(results == expected);
        // } catch (Exception e) {
        // System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        // }

        // System.out.println(); // include a blank line between tests
        // //
        // ================================================================================
        // System.out.println("--- Testing numLeafNodes()/numLeafNodesInTree() from
        // Problem 9 ---");
        // System.out.println();
        // System.out.println("(0) Testing on tree from Problem 9, leaf of 0");
        // try {
        // LinkedTree tree = new LinkedTree();
        // // int[] keys = {37, 26, 42, 13, 35, 56, 30, 47, 70};
        // // tree.insertKeys(keys);

        // int results = tree.numLeafNodes();
        // int expected = 0;
        // System.out.println("actual results:");
        // System.out.println(results);
        // System.out.println("expected results:");
        // System.out.println(expected);
        // System.out.print("MATCHES EXPECTED RESULTS?: ");
        // System.out.println(results == expected);
        // } catch (Exception e) {
        // System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        // }

        // System.out.println(); // include a blank line between tests

        // System.out.println("(1) Testing on tree from Problem 9, leaf of 4");
        // try {
        // LinkedTree tree = new LinkedTree();
        // int[] keys = {37, 26, 42, 13, 35, 56, 30, 47, 70};
        // tree.insertKeys(keys);

        // int results = tree.numLeafNodes();
        // int expected = 4;
        // System.out.println("actual results:");
        // System.out.println(results);
        // System.out.println("expected results:");
        // System.out.println(expected);
        // System.out.print("MATCHES EXPECTED RESULTS?: ");
        // System.out.println(results == expected);
        // } catch (Exception e) {
        // System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        // }

        // System.out.println(); // include a blank line between tests
        // //
        // ================================================================================
        // System.out.println("--- Testing deleteSmallest() from Problem 9 ---");
        // System.out.println();
        // System.out.println("(0) Testing on tree from Problem 9, delete 13");
        // try {
        // LinkedTree tree = new LinkedTree();
        // int[] keys = {37, 26, 42, 13, 35, 56, 30, 47, 70};
        // tree.insertKeys(keys);

        // int results = tree.deleteSmallest();
        // int expected = 13;
        // System.out.println("actual results:");
        // System.out.println(results);
        // System.out.println("expected results:");
        // System.out.println(expected);
        // System.out.print("MATCHES EXPECTED RESULTS?: ");
        // System.out.println(results == expected);
        // } catch (Exception e) {
        // System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        // }

        // System.out.println(); // include a blank line between tests

        // System.out.println("(1) Testing on tree from Problem 9, delete 26");
        // try {
        // LinkedTree tree = new LinkedTree();
        // int[] keys = {37, 26, 42, 35, 56, 30, 47, 70};
        // tree.insertKeys(keys);

        // int results = tree.deleteSmallest();
        // int expected = 26;
        // System.out.println("actual results:");
        // System.out.println(results);
        // System.out.println("expected results:");
        // System.out.println(expected);
        // System.out.print("MATCHES EXPECTED RESULTS?: ");
        // System.out.println(results == expected);
        // } catch (Exception e) {
        // System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        // }

        System.out.println(); // include a blank line between tests
        // ================================================================================
    }
}
