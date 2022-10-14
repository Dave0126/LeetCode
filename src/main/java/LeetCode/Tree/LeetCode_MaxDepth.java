package LeetCode.Tree;

import DataStructure.TreeNode;

/**
 * 计算一个二叉树的深度
 */
public class LeetCode_MaxDepth {
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

        int result = maxDepth(tree1);
        System.out.println(result);
    }

    public static int maxDepth(TreeNode root) {
        return traverseByLevel(root, 0);
    }

    public static int traverseByLevel(TreeNode tree, int level){
        if (tree == null) {
            return level--;
        }
        // 递归返回左右子树中深度最大的子树的深度
       return Math.max(traverseByLevel(tree.left, level+1), traverseByLevel(tree.right,level+1));
    }
}
