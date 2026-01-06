package src.Hashmaps;

import java.util.*;

class CustomHashMap<K, V> {

    // Node class for linked list
    private class Node {
        K key;
        V value;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 16; // default size
    private Node[] buckets;

    public CustomHashMap() {
        buckets = new Node[capacity];
    }

    // Hash function
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // Insert or update key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Node head = buckets[index];

        // Check if key already exists
        Node current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value; // update
                return;
            }
            current = current.next;
        }

        // Insert new node at beginning
        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets[index] = newNode;
    }

    // Retrieve value by key
    public V get(K key) {
        int index = getBucketIndex(key);
        Node current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // key not found
    }

    // Remove key-value pair
    public void remove(K key) {
        int index = getBucketIndex(key);
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}

// Testing the CustomHashMap
public class HashMap {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

        System.out.println(map.get("Apple"));   // 10
        System.out.println(map.get("Banana"));  // 20

        map.remove("Banana");
        System.out.println(map.get("Banana"));  // null
    }
}
