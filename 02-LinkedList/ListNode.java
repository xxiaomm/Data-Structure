
public class ListNode {
    private int val;
    private ListNode next;

    public ListNode() {}

    public ListNode(int value) {
        this.val = value;
        this.next = null;
    }

    public int getValue() {
        return this.val;
    }

    public void setValue(int value) {
        this.val = value;
    }

    public ListNode getNext() {
        return this.next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}