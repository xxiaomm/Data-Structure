import java.util.NoSuchElementException;

public class LinkedList<T> {
    // ListNode defination
    private class ListNode {
        private T val;
        private ListNode next;

        public ListNode(T value, ListNode node) {
            this.val = value;
            this.next = null;
        }

        public ListNode() {
            this(null, null);
        }

        public ListNode(T value) {
            this(value, null);
        }

        public T getValue() {
            return this.val;
        }

        public void setValue(T value) {
            this.val = value;
        }

        public ListNode getNext() {
            return this.next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        @Override
        public String toString(){
            return val.toString();
        }

    }

    private static final T Objec = null;

    // List defination
    private ListNode head;
    private ListNode tail;  // can be omitted
    private int size;

    // Constructor
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public LinkedList(ListNode node) {
        this.head = node;
        this.tail = node;
        this.size = 1;
    }

    // get list size
    public int size() {
        return this.size;
    }

    /** judge empty */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /** judge whether the list contains the element */
    public boolean contains(T value) {
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == value) return true;
            curr = curr.next;
        }
        return false;
    }

    /** get element */
    public T get(int index) {
        if (index < 0 || index > size) 
            throw new IllegalArgumentException("Get failed, Illegal index.");
        ListNode curr = head;
        while (index-- > 0)
            curr = curr.next;
        return curr.val;
        
    }

    public T getFirst() {
        return this.head.val;
    }

    public T getLast() {
        return this.tail.val;
    }

    /** set element with index */
    public void set(int index, T value) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set Failed, Illegal index.");
        ListNode curr = head;
        while (index-- > 0) 
            curr = curr.next;
        curr.val = value;
    }

    /** add element */
    public void addFirst(T value) {
        head = new ListNode(value, head);
        this.size ++;
    }

    public void addLast(T value) {
        ListNode newNode = new ListNode(value, null);
        if (head == null)
            head = newNode;
        else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    public void add(T value, int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed, Illegal index.");
        if (index == 0)
            addFirst(value);
        else {
            ListNode prev = head;
            while (--index > 0) {
                prev = prev.next;
            }
            prev.next = new ListNode(value, prev.next);
            size++;
        }
    }
    
    /** remove element */
    public void removeElement(T value) {
        ListNode curr = head;
        if (head.val == value) {
            head = head.next;
            size--;
        } else {
            while (curr != null && curr.next != null) {
                if (curr.next.val == value) {  // curr.next.val.equals(value)
                    curr.next = curr.next.next;
                    size--;
                }
                curr = curr.next;
            }
        }
        
    }
    
    public T remove (int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Remove Failed, Illegal index.");
            // throw new IllegalArgumentException("Remove Failed, Illegal index.");

        ListNode node;
        if (index == 0) {       //
            // removeFirst();
            if (size == 0) 
                throw new NoSuchElementException("Remove failed, the list is empty.");
            T value = head.val;
            head = head.next;
            return value;
        } else {
            ListNode prev = head;
            while (--index > 0) 
                prev = prev.next;
            node = prev.next;
            prev.next = prev.next.next;
            size--;   
            if (index == size) tail = prev; // delete tail
        }
        return node.val;
    }
    // remove head
    public T removeFirst() {
        remove(0);
    }
    // remove tail
    public T removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        ListNode cur = head;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }


}
