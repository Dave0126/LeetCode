package LeetCode;

/**
 * @author Guohao
 * @version 1.0
 * @description 反转链表 II (中等)
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回反转后的链表 。
 *
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 *
 * 提示：
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 *
 * 进阶： 你可以使用一趟扫描完成反转吗？
 *
 * @create 2023/8/30 11:16
 */

import DataStructure.ListNode;

import java.util.List;

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

public class LeetCode_0092_ReverseLinkedListLv2 {
    public static void main(String[] args) {
        ListNode head = ListNode.createListNodeFromList(new int[]{1,2,3,4,5});
        ListNode result = reverseBetween(head, 1, 4);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // 为了避免left为第一个链表元素时，指针ptReversePre为空的情况。
        ListNode opListNode = new ListNode(-1, head);

        ListNode ptReversePre = null;
        ListNode ptReverseHead = null;
        ListNode ptReverseTail = null;
        ListNode ptReverseNxt = null;

        ListNode ptCur = opListNode;

        int position = 0;
        while(position < left){
            ptReversePre = ptCur;
            ptCur = ptCur.next;
            position++;
        }

        ptReverseTail = ptCur;
        ListNode ptLst = ptReverseHead;
        while(position <= right){
            ptReverseHead = ptCur;
            ListNode ptTemp = ptCur.next;
            ptCur.next = ptLst;
            ptLst = ptCur;
            ptCur = ptTemp;
            position++;
        }
        ptReverseNxt = ptCur;
        ptReversePre.next = ptReverseHead;
        ptReverseTail.next = ptReverseNxt;
        return opListNode.next;
    }
}
