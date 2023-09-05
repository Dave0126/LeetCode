package LeetCode;

import DataStructure.ListNode;

/**
 * @author Guohao
 * @version 1.0
 * @description 两两交换链表中的节点(中等)
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *
 *
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 * @create 2023/9/2 15:34
 */
public class LeetCode_0024_SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = ListNode.createListNodeFromList(new int[]{1, 2, 3, 4});
        ListNode result = swapPairs(head);
    }

    public static ListNode swapPairs(ListNode head){
        ListNode ptLst;
        ListNode ptCur;
        ListNode result = new ListNode(0, head);
        ListNode temp = result;
        while(temp.next != null && temp.next.next != null){
            ptLst = temp.next;
            ptCur = ptLst.next;
            temp.next = ptCur;
            ptLst.next = ptCur.next;
            ptCur.next = ptLst;
            temp = ptLst;
        }
        return result.next;
    }
}

