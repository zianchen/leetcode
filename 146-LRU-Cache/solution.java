public class LRUCache {
    
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> hs = new HashMap<>();
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }
    
    public int get(int key) {
        if (!hs.containsKey(key)) {
            return -1;
        }
        
        //remove cur
        Node cur = hs.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        
        //move cur to tail
        move_to_tail(cur);
        
        return hs.get(key).value;
    }
    
    public void set(int key, int value) {
        if (get(key) != -1) {
            hs.get(key).value = value;
            return;
        }
        
        if (hs.size() == capacity) {   //这个算法里的head相当于dummy，然后head.next是least recent used的node，tail.prev是most recent used的节点
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        Node insert = new Node(key, value);
        hs.put(key, insert);
        move_to_tail(insert);
    }
    
    private void move_to_tail(Node cur) {
        cur.prev = tail.prev;
        tail.prev = cur;
        cur.prev.next = cur;
        cur.next = tail;
    }
}