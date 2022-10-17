package LeetCode.Tree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_TreeNodeVer2Test {
    public static void main(String[] args) {
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
        b.right = null;
        b.next = c;
        c.left = f;
        c.right = g;
        d.next = e;
        e.next = f;
        f.next = g;

        traverse(a);
    }

    public static void traverse(TreeNode root) {
        List<TreeNode> beginNodeList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        beginNodeList.add(root);
        findBeginNode(root.left, root.right, beginNodeList);
        for(TreeNode t:beginNodeList) {
            System.out.print(t.val);
        }

        while(root != null) {
            TreeNode begin = root;
            while (begin != null) {
                list.add((String)begin.val);
                begin = begin.next;
            }
            list.add("#");
            root = root.left == null ? root.right : root.left;
        }

//        for(String s : list) {
//            System.out.print(s+"\t");
//        }

    }

    public static void findBeginNode(TreeNode left, TreeNode right, List<TreeNode> beginNodeList) {
        if (left.left != null || left.right != null) {
            beginNodeList.add(left);
            if(left.left == null ) {
                findBeginNode(left.left, left.right, beginNodeList);
            } else if (left.right == null) {

            }
        }
        else if(right != null) {
            beginNodeList.add(right);
            findBeginNode(right.left, right.right, beginNodeList);
        }
        else {
            return;
        }
    }
}