package LeetCode.Tree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定二叉树，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xorvud/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class LeetCode_TreeNodeVer2Test {
    public static void main(String[] args) {
        TreeNode tree = createTreeNode();
        traverse(null);
    }


    public static void traverse(TreeNode root) {
        if(root == null) {
            return;
        }

        List<TreeNode> beginNodeList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        beginNodeList.add(root);
        findBeginNode(root.left, root.right, beginNodeList);
        for(TreeNode t:beginNodeList) {
            TreeNode begin = t;
            while (begin != null) {
                list.add((String)begin.val);
                begin = begin.next;
            }
            list.add("#");
        }

        for(String s : list) {
            System.out.print(s+"\t");
        }
    }

    public static void findBeginNode(TreeNode left, TreeNode right, List<TreeNode> beginNodeList) {
        if (left != null && !(left.left == null && left.right == null)) {
            beginNodeList.add(left);
            findBeginNode(left.left, left.right, beginNodeList);
        }
        else if(right != null && !(right.left == null && right.right == null)) {
            beginNodeList.add(right);
            findBeginNode(right.left, right.right, beginNodeList);
        }
        else {
            if (left == null && right == null) {
                return;
            }
            beginNodeList.add(left == null ? right : left);
        }
    }

    /**
     * 创建一个带有 next 指针的二叉树
     * @return 返回一个形如 [a # b, c # e, f, g] 的二叉树
     *
     *              a
     *             / \
     *            b   c
     *            \  / \
     *            e f  g
     */
    private static TreeNode createTreeNode() {
        TreeNode a = new TreeNode("a");
        TreeNode b = new TreeNode("b");
        TreeNode c = new TreeNode("c");
        TreeNode d = new TreeNode("d");
        TreeNode e = new TreeNode("e");
        TreeNode f = new TreeNode("f");
        TreeNode g = new TreeNode("g");
        a.left = b;
        a.right = c;
        b.left = null;
        b.right = e;
        b.next = c;
        c.left = f;
        c.right = g;
        d.next = e;
        e.next = f;
        f.next = g;
        return a;
    }
}