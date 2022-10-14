package LeetCode.Tree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * 层序遍历二叉树
 *
 * 用例:
 *              1
 *             / \
 *            2   3
 *           /\   /\
 *          4 5  6  7
 *
 * 输出：[[1], [2,3], [4,5,6,7]]
 */
public class LeetCode_TraverseTreeByLevel {
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
        List<List<Integer>> res = treeTraversal(tree1);
        printList(res);
    }

    /**
     * 以一定方法对树 tree 进行遍历
     * @param tree
     * @return 返回遍历后的结果
     */
    public static List<List<Integer>> treeTraversal(TreeNode tree) {
        int level = 0;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        levelOrderTraverse(tree, level, list);
        return list;
    }

    /**
     * 将树 tree 按【层序遍历】
     * @param tree 二叉树
     * @param level 层序数
     * @param list 存储连接结果的数组
     */
    public static void levelOrderTraverse(TreeNode tree, int level, List<List<Integer>> list) {
        // 如果不存在该节点，则level自减，因为不存在这一行
        if(tree == null) {
            level--;
            return;
        }

        // 想象一下，当一个树形如示例：
        // *              1
        // *             / \
        // *            2   3
        // *           /\   /\
        // *          4 5  6  7
        // 我们在遍历第2行时，level=1（level从零开始），list.size = 1，故满足 list.size() < level+1
        if (list.size() < level+1) {
            list.add(new ArrayList<>());
        }

        list.get(level).add(tree.val);
        // 递归
        levelOrderTraverse(tree.left, level+1, list);
        levelOrderTraverse(tree.right, level+1, list);
    }

    /**
     * 打印一个 List<List<Integer>> 类型的数组
     * 预期的结果为 [[x],[x,...,x],...,[]]
     * @param list
     */
    public static void printList(List<List<Integer>> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < list.get(i).size(); j++) {
                if (j == list.get(i).size() - 1) {
                    System.out.print(list.get(i).get(j));
                } else {
                    System.out.print(list.get(i).get(j) + ",");
                }
            }
            System.out.print("] ");
        }
        System.out.print("]");
    }


}
