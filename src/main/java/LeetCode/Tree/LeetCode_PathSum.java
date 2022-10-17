package LeetCode.Tree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 * 提示：叶子节点 是指没有子节点的节点。
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示
 *
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/data-structure-binary-tree/xo566j/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCode_PathSum {
    public static void main(String[] args) {
        TreeNode tree1 =
                new TreeNode(5,
                        new TreeNode(4,
                                new TreeNode(11,
                                        new TreeNode(7),
                                        new TreeNode(2)),
                                null),
                        new TreeNode(8,
                                new TreeNode(13),
                                new TreeNode(4,
                                        null,
                                        new TreeNode(1))));

        boolean res = hasPathSum(tree1, 22);
        System.out.println(res);
    }

    public static List<List<Integer>> pathList = new ArrayList<>();

    public static boolean hasPathSum(TreeNode root, int targetSum) {

//        getPathSum(root, 0);
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null) {
            return targetSum == (int) root.val;
        }

        return hasPathSum(root.left, targetSum- (int) root.val)
                || hasPathSum(root.right, targetSum - (int) root.val);
    }

    public static void getPath(TreeNode tree, List<Integer> path, List<List<Integer>> pathList) {
        if (tree == null) {
            return;
        }

        if (tree.left == null || tree.right == null) {
            path = new ArrayList<>();
            path.add((int)tree.val);
            pathList.add(path);
        }

        if (tree.left != null) {
            path.add((int)tree.left.val);
            getPath(tree.left, path, pathList);
        }

        if (tree.right != null) {
            path.add((int)tree.right.val);
            getPath(tree.right, path, pathList);
        }

    }
}
