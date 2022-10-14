package BILIBILI;

import DataStructure.ListNode;
import java.util.ArrayList;


/**
 * BiliBIli 笔试题（2022-09-01）
 * 题目描述：
 *      给定一个拥有偶数个元素的链表，将相邻的两个节点元素的val相乘。返回合并后的链表。
 */

public class BiliBIli_MergeTwoNeighborNode {
    public static void main(String[] args) {
        // 测试链编为 head = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));
        // 应返回的链表是 head = 1*2 -> 3*4 -> 5*6 -> 7*8
        ListNode result = mergeNode(head);
        while (result != null){
            System.out.print("->" + result.val);
            result = result.next;
        }
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode mergeNode (ListNode head) {
        // write code here
        ArrayList<ListNode> resArr = new ArrayList<>();


        while(head != null) {
            ListNode tempNode = new ListNode(0);
            tempNode.next = head.next.next;
            resArr.add(new ListNode(head.val * head.next.val));
            head = tempNode.next;
        }

        for (int i =0; i<resArr.size() -1; i++) {
            resArr.get(i).next = resArr.get(i+1);
        }

        return resArr.get(0);
    }
}
