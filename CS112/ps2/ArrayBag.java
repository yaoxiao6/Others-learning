/* 
 * ArrayBag.java
 * 
 * Computer Science 112
 */

import java.util.*;

/**
 * An implementation of a bag data structure using an array.
 */
public class ArrayBag {
    /**
     * The array used to store the items in the bag.
     */
    private Object[] items;

    /**
     * The number of items in the bag.
     */
    private int numItems;

    public static final int DEFAULT_MAX_SIZE = 50;

    /**
     * Constructor with no parameters - creates a new, empty ArrayBag with the
     * default maximum size.
     */
    public ArrayBag() {
        this.items = new Object[DEFAULT_MAX_SIZE];
        this.numItems = 0;
    }

    /**
     * A constructor that creates a new, empty ArrayBag with the specified maximum
     * size.
     */
    public ArrayBag(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize must be > 0");
        }
        this.items = new Object[maxSize];
        this.numItems = 0;
    }

    /**
     * numItems - accessor method that returns the number of items in this ArrayBag.
     */
    public int numItems() {
        return this.numItems;
    }

    /**
     * add - adds the specified item to this ArrayBag. Returns true if there is room
     * to add it, and false otherwise. Throws an IllegalArgumentException if the
     * item is null.
     */
    public boolean add(Object item) {
        if (item == null) {
            throw new IllegalArgumentException("item must be non-null");
        } else if (this.numItems == this.items.length) {
            return false; // no more room!
        } else {
            this.items[this.numItems] = item;
            this.numItems++;
            return true;
        }
    }

    /**
     * remove - removes one occurrence of the specified item (if any) from this
     * ArrayBag. Returns true on success and false if the specified item (i.e., an
     * object equal to item) is not in this ArrayBag.
     */
    public boolean remove(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                // Shift the remaining items left by one.
                for (int j = i; j < this.numItems - 1; j++) {
                    this.items[j] = this.items[j + 1];
                }
                this.items[this.numItems - 1] = null;

                this.numItems--;
                return true;
            }
        }

        return false; // item not found
    }

    /**
     * contains - returns true if the specified item is in the Bag, and false
     * otherwise.
     */
    public boolean contains(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                return true;
            }
        }

        return false;
    }

    /**
     * grab - returns a reference to a randomly chosen item in this ArrayBag.
     */
    public Object grab() {
        if (this.numItems == 0) {
            throw new IllegalStateException("the bag is empty");
        }

        int whichOne = (int) (Math.random() * this.numItems);
        return this.items[whichOne];
    }

    /**
     * toArray - return an array containing the current contents of the bag
     */
    public Object[] toArray() {
        Object[] copy = new Object[this.numItems];

        for (int i = 0; i < this.numItems; i++) {
            copy[i] = this.items[i];
        }

        return copy;
    }

    /**
     * toString - converts this ArrayBag into a string that can be printed.
     * Overrides the version of this method inherited from the Object class.
     */
    public String toString() {
        String str = "{";

        for (int i = 0; i < this.numItems; i++) {
            str = str + this.items[i];
            if (i != this.numItems - 1) {
                str += ", ";
            }
        }

        str = str + "}";
        return str;
    }

    // This method should return the number of additional items that the called
    // ArrayBag has room to store.
    public int roomLeft() {
        return this.items.length - this.numItems();
    }

    // This method should return true if the called ArrayBag is full, and false
    // otherwise.
    public boolean isFull() {
        return this.roomLeft() == 0;
    }

    // This method should increase the maximum capacity of the called ArrayBag by
    // the specified amount.
    public void increaseCapacity(int increment) {
        if (increment < 0) {
            throw new IllegalArgumentException("increment should be greater than 0");
        } else if (increment == 0) {
            return;
        }
        Object[] newItems = new Object[this.items.length + increment];
        for (int i = 0; i < this.numItems(); i++) {
            newItems[i] = this.items[i];
        }
        this.items = newItems;
    }

    // This method should attempt to remove from the called ArrayBag all occurrences
    // of the items found in the parameter other. If the called object contains
    // multiple copies of an item from other, all of the copies should be removed.
    // The method should return true if one or more items are removed, and false
    // otherwise.
    public boolean removeItems(ArrayBag other) {
        if (other == null) {
            throw new IllegalArgumentException();
        }
        if (other.items.length == 0) {
            return false;
        }
        boolean removed = false;
        for (int j = 0; j < this.items.length; j++) {
            for (Object i : other.items) {
                if (this.contains(i)) {
                    this.remove(i);
                    removed = true;
                }
            }
        }
        return removed;
    }

    // This method should create and return an ArrayBag containing one occurrence of
    // any item that is found in both the called object and the parameter other. For
    // full credit, the resulting bag should not include any duplicates.
    public ArrayBag intersectionWith(ArrayBag other) {
        if (other == null) {
            throw new IllegalArgumentException();
        }
        ArrayBag andBag = new ArrayBag(1);
        if (this.items.length == 0 || other.items.length == 0) {
            return andBag;
        }
        boolean smallAndBag = this.items.length > andBag.items.length && other.items.length > andBag.items.length;
        if (smallAndBag) {
            if (this.items.length >= other.items.length) {
                andBag.increaseCapacity(other.items.length - andBag.items.length - 1);
            } else {
                andBag.increaseCapacity(this.items.length - andBag.items.length - 1);
            }
        }
        for (Object i : other.items) {
            if (this.contains(i) && !andBag.contains(i)) {
                andBag.add(i);
            }
        }
        return andBag;
    }

    /* Test the ArrayBag implementation. */
    public static void main(String[] args) {
        
    }
}
