package LeetCode.Tree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static LeetCode.Tree.LeetCode_TraverseTreeByLevel.printList;

/**
 * 对称二叉树: 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 *
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xoxzgv/
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class LeetCode_IsSymmetricTree {
    public static void main(String[] args) {
        TreeNode tree1 =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3),
                                new TreeNode(4)),
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(3)));

        TreeNode tree2 =
                new TreeNode(1,
                        new TreeNode(2,null,
                                new TreeNode(4)),
                        new TreeNode(2,
                                null,
                                new TreeNode(3)));

        TreeNode tree3 = new TreeNode(1);

        boolean res = isSymmetric(tree1);
        System.out.println(res);
    }

    public static boolean isSymmetric(TreeNode root) {
        return judge(root.left, root.right);
    }

    public static boolean judge(TreeNode left, TreeNode right) {
        // 情况一：左右两个子树都为空
        if (left == null && right == null) {
            return true;
        }

        // 情况二：左右两个子树有一个为空
        if ((left == null && right != null)
                || (left != null && right == null)) {
            return false;
        }

        return (left.val == right.val                   // 左子树的值 == 右子树的值
                && judge(left.left, right.right)        // 递归判断
                && judge(left.right, right.left));
    }


}

