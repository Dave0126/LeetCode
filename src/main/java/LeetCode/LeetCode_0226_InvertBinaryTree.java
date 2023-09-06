package LeetCode;

import DataStructure.TreeNode;
import DataStructure.TreeNodeFactory;

/**
 * @author Guohao
 * @version 1.0
 * @description 翻转二叉树(简单)
 *
 * 给你一棵二叉树的根节点 root ，将这棵二叉树及其所有子树左右反转，并返回其根节点。
 *
 *
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 示例 2：
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * @create 2023/9/6 17:47
 */
public class LeetCode_0226_InvertBinaryTree {
    public static void main(String[] args) {
        TreeNodeFactory treeNodeFactory = new TreeNodeFactory();
        TreeNode root = treeNodeFactory.buildTreeByLevel(new Integer[]{4,2,7,1,3,6,9});
        TreeNode resultSol1 = invertTree(root);
        TreeNode resultSol2 = treeNodeFactory.invertTree(root);
        System.out.println(treeNodeFactory.isSameTree(resultSol1, resultSol2));
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        return new TreeNode(root.val, invertTree(root.right), invertTree(root.left));
    }
}
