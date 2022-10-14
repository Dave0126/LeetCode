package BILIBILI;

import DataStructure.TreeNode;

/**
 * BiliBIli 笔试题（2022-09-01）
 * 题目描述：
 *      给定一个二叉搜索树，此树既可以是平衡二叉树也可以不是。现需要我们将这个数分成若干个平衡二叉树。
 *
 * 输入描述：
 *              6
 *             / \
 *            4   7
 *           / \
 *          3   5
 *         /
 *        1
 *
 * 输出描述：
 *      6
 *       \
 *        7
 *    AND
 *      4
 *     / \
 *    3   5
 *   /
 *  1
 *
 */

public class BiliBili_SplitBinaryTree {
    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(6,
                        new TreeNode(4,
                                new TreeNode(3,
                                        new TreeNode(1)),
                                new TreeNode(5)),
                        new TreeNode(7));
    }

    public static void printTree(TreeNode node) {
    }

}
