class LRUCache {

    private Map<Integer, Node> map;

    // Dummy nodes
    private Node head; // before LRU
    private Node tail; // after MRU

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Move to MRU position
        removeNode(node);
        addNode(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {

            Node current = map.get(key);

            current.value = value;

            // Move to MRU position
            removeNode(current);
            addNode(current);

            return;
        }

        // Cache is full
        if (map.size() >= capacity) {

            // head.next = LRU
            Node lru = head.next;

            removeNode(lru);

            // Remove the actual key from HashMap
            map.remove(lru.key);
        }

        // Create new node
        Node newNode = new Node(key, value);

        // Add to HashMap
        map.put(key, newNode);

        // Add as MRU
        addNode(newNode);
    }

    // Remove a node from the linked list
    private void removeNode(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    // Add node right before tail
    // This makes it the MRU
    private void addNode(Node node) {
        node.next = tail;
        node.previous = tail.previous;

        tail.previous.next = node;
        tail.previous = node;
    }
}


class Node {

    int key;
    int value;

    Node next;
    Node previous;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}