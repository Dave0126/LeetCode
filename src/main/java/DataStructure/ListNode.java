package DataStructure;

public class ListNode{
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public static ListNode createListNodeFromList(int[] list){
        ListNode head = new ListNode(list[0]);
        ListNode ptNxt = head;
        for (int i = 1; i < list.length; i++) {
            ptNxt.next = new ListNode(list[i]);
            ptNxt = ptNxt.next;
        }
        return head;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
