import java.util.HashMap;
import java.util.Map;

public class Leetcode146 {
    private class Node {

        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    private final Map<Integer, Node> cache;

    private final Node head;
    private final Node tail;

    public Leetcode146(int capacity) {

        this.capacity = capacity;

        cache = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);

        remove(node);
        insertAtFront(node);

        return node.value;
    }

    public void put(int key, int value) {


        if (cache.containsKey(key)) {

            Node oldNode = cache.get(key);

            remove(oldNode);
        }

        Node newNode = new Node(key, value);

        cache.put(key, newNode);

        insertAtFront(newNode);

        if (cache.size() > capacity) {

            Node leastRecentlyUsed = tail.prev;

            remove(leastRecentlyUsed);

            cache.remove(leastRecentlyUsed.key);
        }
    }

    private void remove(Node node) {

        Node previousNode = node.prev;
        Node nextNode = node.next;

        previousNode.next = nextNode;
        nextNode.prev = previousNode;
    }
    private void insertAtFront(Node node) {

        Node nextNode = head.next;

        node.prev = head;
        node.next = nextNode;

        head.next = node;
        nextNode.prev = node;
    }
}