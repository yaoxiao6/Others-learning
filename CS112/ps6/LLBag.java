import java.util.*;

public class LLBag implements Bag {
    private class Node {
        private Object item;
        private Node next;

        private Node(Object i, Node n) {
            item = i;
            next = n;
        }
    }

    private Node head;
    private int numItems;

    /*
     * Constructor with no parameters - creates a new, empty LLBag
     */
    public LLBag() {
        head = new Node(null, null);
        numItems = 0;
    }

    /* 
     * add - adds the specified item to this LLBag. Returns true if there 
     * is room to add it, and false otherwise.
     * Throws an IllegalArgumentException if the item is null.
     */
    public boolean add(Object item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node newNode = new Node(item, null);
        newNode.next = head.next;
        head.next = newNode;
        numItems++;
        return true;
    }

    /* 
     * remove - removes one occurrence of the specified item (if any)
     * from this LLBag.  Returns true on success and false if the
     * specified item (i.e., an object equal to item) is not in this LLBag.
     */
    public boolean remove(Object item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        boolean removed = false;

        Node prev = head;
        for (Node trav = head.next; trav != null; trav = trav.next) {
            if (trav.item.equals(item)) {
                prev.next = prev.next.next;
                removed = true;
                break;
            }
            prev = prev.next;
        }

        numItems--;
        return removed;
    }

    /*
     * contains - returns true if the specified item is in the Bag, and
     * false otherwise.
     */
    public boolean contains(Object item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        for (Node trav = head.next; trav != null; trav = trav.next) {
            if (trav.item.equals(item)) {
                return true;
            }
        }
        return false;
    }

    /*
     * numItems - accessor method that returns the number of items 
     * in this LLBag.
     */
    public int numItems() {
        return numItems;
    }

    /*
     * grab - returns a reference to a randomly chosen item in this ArrayBag.
     */
    public Object grab() {
        if (numItems == 0) {
            throw new IllegalStateException("the bag is empty");
        }

        int whichOne = (int) (Math.random() * numItems);
        int i = 0;
        for (Node trav = head.next; trav != null; trav = trav.next) {
            if (i == whichOne) {
                return trav.item;
                // break;
            }
            i++;
        }
        return null;
    }

    /*
     * toArray - return an array containing the current contents of the bag
     */
    public Object[] toArray() {
        Object[] copy = new Object[numItems];

        int i = 0;
        for (Node trav = head.next; trav != null; trav = trav.next) {
            copy[i] = trav.item;
            i++;
        }

        return copy;
    }

    /*
     * toString - converts this LLBag into a string that can be printed.
     * Overrides the version of this method inherited from the Object class.
     */
    public String toString() {
        String str = "{";

        Node trav = head.next; // skip over the dummy head node
        while (trav != null) {
            str = str + trav.item;
            if (trav.next != null) {
                str = str + ", ";
            }
            trav = trav.next;
        }

        str = str + "}";
        return str;
    }

    // public static void main(String[] args) {
    //     // Create a Scanner object for user input.
    //     Scanner scan = new Scanner(System.in);

    //     // Create an LLBag named bag1.
    //     System.out.print("number of items in bag 1: ");
    //     int numItems = scan.nextInt();
    //     Bag bag1 = new LLBag(numItems);
    //     scan.nextLine(); // consume the rest of the line

    //     // Read in strings, add them to bag1, and print out bag1.
    //     String itemStr;
    //     for (int i = 0; i < numItems; i++) {
    //         System.out.print("item " + i + ": ");
    //         itemStr = scan.nextLine();
    //         bag1.add(itemStr);
    //     }
    //     System.out.println("bag 1 = " + bag1);
    //     System.out.println();

    //     // Select a random item and print it.
    //     Object item = bag1.grab();
    //     System.out.println("grabbed " + item);
    //     System.out.println();

    //     // Iterate over the objects in bag1, printing them one per line.
    //     Object[] items = bag1.toArray();
    //     for (int i = 0; i < items.length; i++) {
    //         System.out.println(items[i]);
    //     }
    //     System.out.println();

    //     // Get an item to remove from bag1, remove it, and reprint the bag.
    //     System.out.print("item to remove: ");
    //     itemStr = scan.nextLine();
    //     if (bag1.contains(itemStr)) {
    //         bag1.remove(itemStr);
    //     }
    //     System.out.println("bag 1 = " + bag1);
    //     System.out.println();
    // }
}