/*
 * ChainedHashTable.java
 *
 * Computer Science 112, Boston University
 * 
 * Modifications and additions by:
 *     name:
 *     email:
 */

import java.util.*; // to allow for the use of Arrays.toString() in testing

/*
 * A class that implements a hash table using separate chaining.
 */
public class ChainedHashTable implements HashTable {
    /*
     * Private inner class for a node in a linked list for a given position of the
     * hash table
     */
    private class Node {
        private Object key;
        private LLQueue<Object> values;
        private Node next;

        private Node(Object key, Object value) {
            this.key = key;
            values = new LLQueue<Object>();
            values.insert(value);
            next = null;
        }
    }

    private Node[] table; // the hash table itself
    private int numKeys; // the total number of keys in the table

    public int getNumKeys() {
        return numKeys;
    }

    public double load() {
        return 1.0 * numKeys / table.length;
    }

    public Object[] getAllKeys() {
        Object[] keyList = new Object[numKeys];
        int i = 0;
        Node trav;
        for (int j = 0; j < table.length; j++) {
            if (table[j] != null) {
                trav = table[j];
                while (trav != null) {
                    keyList[i] = trav.key;
                    i++;
                    trav = trav.next;
                }
            }
        }
        return keyList;
    }

    public void resize(int newSize) {
        ChainedHashTable newTable = new ChainedHashTable(newSize);
        for (int i = 0; i < this.table.length; i++) {
            Node header = this.table[i];
            Node trav = header;
            while (trav != null) {
                newTable.insert(trav.key, trav.values);
                System.out.println("=========");
                trav = trav.next;
            }
        }
        this.table = newTable.table;
    }

    /* hash function */
    public int h1(Object key) {
        int h1 = key.hashCode() % table.length;
        if (h1 < 0) {
            h1 += table.length;
        }
        return h1;
    }

    /*** Add your constructor here ***/
    public ChainedHashTable(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        table = new Node[size];
    }

    /*
     * insert - insert the specified (key, value) pair in the hash table. Returns
     * true if the pair can be added and false if there is overflow.
     */
    public boolean insert(Object key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException("key must be non-null");
        }
        Node header = table[h1(key)];
        Node trav = header;
        Node trail = trav;
        Node insertKey = new Node(key, value);
        if (trav == null) {
            table[h1(key)] = insertKey;
            numKeys++;
            return true;
        }
        while (trav != null) {
            if (trav.key.equals(key)) {
                trav.values.insert(value);
                return true;
            }
            trail = trav;
            trav = trav.next;
        }
        trail.next = insertKey;
        numKeys++;
        return true;
    }

    /*
     * search - search for the specified key and return the associated collection of
     * values, or null if the key is not in the table
     */
    public Queue<Object> search(Object key) {
        if (key == null) {
            throw new IllegalArgumentException("key must be non-null");
        }
        Node header = table[h1(key)];
        Node trav = header;
        while (trav != null) {
            if (trav.key.equals(key)) {
                return trav.values;
            }
            trav = trav.next;
        }
        return null;
    }

    /*
     * remove - remove from the table the entry for the specified key and return the
     * associated collection of values, or null if the key is not in the table
     */
    public Queue<Object> remove(Object key) {
        if (key == null) {
            throw new IllegalArgumentException("key must be non-null");
        }
        Node header = table[h1(key)];
        // if (header == null) {
        // return null;
        // }
        Node trav = header;
        Node trail = trav;
        if (trav.next == null) {// it has only one node
            LLQueue<Object> returnMe = trav.values;
            table[h1(key)] = null;
        }
        if (trav.key.equals(key)) {// dealing with the first node in the multiple node
            table[h1(key)] = trav.next;
            numKeys--;
            return trav.values;
        }
        // double leader = true;
        while (trav != null) {// dealing with other multiple nodes
            if (trav.key.equals(key)) {
                trail.next = trav.next;
                numKeys--;
                return trav.values;
            }
            trail = trav;
            trav = trav.next;
        }
        return null;
    }

    /*** Add the other required methods here ***/

    /*
     * toString - returns a string representation of this ChainedHashTable object.
     * *** You should NOT change this method. ***
     */
    public String toString() {
        String s = "[";

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                s += "null";
            } else {
                String keys = "{";
                Node trav = table[i];
                while (trav != null) {
                    keys += trav.key;
                    if (trav.next != null) {
                        keys += "; ";
                    }
                    trav = trav.next;
                }
                keys += "}";
                s += keys;
            }

            if (i < table.length - 1) {
                s += ", ";
            }
        }

        s += "]";
        return s;
    }

    public static void main(String[] args) {
        // ChainedHashTable table = new ChainedHashTable(5);
        // table.insert("howdy", 15);
        // table.insert("goodbye", 10);
        // System.out.println(table.insert("apple", 5));
        // System.out.println(table);

        // //4
        // ChainedHashTable table = new ChainedHashTable(5);
        // table.insert("howdy", 15);
        // table.insert("goodbye", 10);
        // table.insert("apple", 5);
        // System.out.println(table.getNumKeys());
        // table.insert("howdy", 25); // insert a duplicate
        // System.out.println(table.getNumKeys());

        // //5
        // ChainedHashTable table = new ChainedHashTable(5);
        // table.insert("howdy", 15);
        // table.insert("goodbye", 10);
        // table.insert("apple", 5);
        // System.out.println(table.load());
        // table.insert("pear", 6);
        // System.out.println(table.load());

        // // 6
        // ChainedHashTable table = new ChainedHashTable(5);
        // table.insert("howdy", 15);
        // table.insert("goodbye", 10);
        // table.insert("apple", 5);
        // table.insert("howdy", 25); // insert a duplicate
        // Object[] keys = table.getAllKeys();
        // System.out.println(Arrays.toString(keys));

        // // 7
        // ChainedHashTable table = new ChainedHashTable(5);
        // table.insert("howdy", 15);
        // table.insert("goodbye", 10);
        // table.insert("apple", 5);
        // System.out.println("old table is " + table);
        // table.resize(7);
        // System.out.println("new table is " + table);
    }
}
