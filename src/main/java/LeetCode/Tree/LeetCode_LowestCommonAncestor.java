package LeetCode.Tree;

import DataStructure.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node0 = new TreeNode<>(0);
        TreeNode<Integer> node8 = new TreeNode<>(8);
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node4 = new TreeNode<>(4);

        node3.left = node5;
        node3.right = node1;

        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;

        node2.left = node7;
        node2.right = node4;

//        LeetCode_TraverseTreeByLevel.printList(LeetCode_TraverseTreeByLevel.treeTraversal(node3));

        TreeNode<Integer> result = lowestCommonAncestor(node3, node5, node4);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode<Integer> res = new TreeNode<>();
        Set<TreeNode> unionSet = new HashSet<>();
        // TODO
        return res;
    }

    public static void traverse(TreeNode root, TreeNode p) {
        if(root == null) {
            return;
        }
        // TODO
        if(root == p){
            Set<TreeNode> nodeSet = new HashSet<>();
            nodeSet.add(root);
        }
    }
}
