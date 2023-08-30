package LeetCode;

/**
 * @author Guohao
 * @version 1.0
 * @description 反转链表
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 *
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 * @create 2023/8/30 10:12
 */

import DataStructure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class LeetCode_0206_ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = ListNode.createListNodeFromList(new int[]{1,2,3,4,5});
        ListNode result = reverseList(head);

    }

    public static ListNode reverseList(ListNode head) {
        return solutionItor(head);
    }

    private static ListNode solutionItor(ListNode head){
        ListNode ptLst = null;
        ListNode ptCur = head;
        while(ptCur != null){
            ListNode ptTemp = ptCur.next;
            ptCur.next = ptLst;
            ptLst = ptCur;
            ptCur = ptTemp;
        }
        return ptLst;
    }

    private static ListNode solutionRec(ListNode head){
//        TODO
        return new ListNode();
    }
}
