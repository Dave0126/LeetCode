package LeetCode.Tree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.sleep;
import static java.util.concurrent.locks.LockSupport.park;

/**
 * 关于树的前序、中序及后序遍历。
 */
public class LeetCode_TraverseTree {
    public static void main(String[] args) {
        TreeNode tree1 =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3,
                                new TreeNode(6),
                                new TreeNode(7)));

        TreeNode tree2 = null;

        List<Integer> list = treeTraversal(tree1);
        for(Integer i : list) {
            System.out.print(i + "\t");
        }
    }

//    public static List<Integer> res = new ArrayList<>();

    public static List<Integer> treeTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrderTraverse(root,res);   // 前序遍历
//        inOrderTraverse(root,res);      // 中序遍历
//        postOrderTraverse(root,res);  // 后序遍历
        return res;
    }

    /**
     * 以前序遍历树
     * @param tree
     */
    public static void preOrderTraverse(TreeNode tree, List<Integer> res) {
        if(tree == null) {
            return;
        }
        res.add(tree.val);
        preOrderTraverse(tree.left,res);
        preOrderTraverse(tree.right,res);
    }

    /**
     * 以中序遍历树
     * @param tree
     */
    public static void inOrderTraverse(TreeNode tree, List<Integer> res) {
        if(tree == null) {
            return;
        }
        inOrderTraverse(tree.left,res);
        res.add(tree.val);
        inOrderTraverse(tree.right,res);
    }

    /**
     * 以 后序遍历 树
     * @param tree
     */
    public static void postOrderTraverse(TreeNode tree, List<Integer> res) {
        if(tree == null) {
            return;
        }
        postOrderTraverse(tree.left,res);
        postOrderTraverse(tree.right,res);
        res.add(tree.val);
    }



}

