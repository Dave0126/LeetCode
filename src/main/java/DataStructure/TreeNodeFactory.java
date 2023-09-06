package DataStructure;

import java.util.Arrays;

public class TreeNodeFactory{
    /**
     * 通过层序遍历的字符串数组 input[]，创建（完全）二叉树。
     * 不存在的节点使用"null"表示。
     *
     * 例如：
     *      输入： input[] = {"1","2","3","4","null","null","7"}
     *      输出：
     *                          1
     *                         / \
     *                        2   3
     *                       /     \
     *                      4       7
     *
     * @param input 层序遍历的字符串数组 input[]
     * @return 创建的（完全）二叉树
     */
    public <T> TreeNode buildTreeByLevel(T[] input) {
        // 1. 判断是否遍历完整个input数组，没有就继续创建TreeNode节点
        TreeNode[] treeNodes = new TreeNode[input.length];
        for (int i = 0; i < input.length; i++) {
            if (input[i] == null) {
                treeNodes[i] = null;
            } else {
                treeNodes[i] = new TreeNode(input[i]);
            }
        }

        // 2.将这些TreeNode节点通过链表连接起来
        //                  0               level 1
        //                 1 2              level 2
        //               3 4 5 6            level 3
        //          7 8 9 10 11 12 13 14    level 4
        // n*2+1 n*2+2
        for (int i = 0; i < treeNodes.length/2 ; i++) {
            if(2*i-1 < treeNodes.length) {
                treeNodes[i].setLeft(treeNodes[2*i+1]);
            } else {
                treeNodes[i].setLeft(null);
            }
            if(2*i+2 < treeNodes.length){
                treeNodes[i].setRight(treeNodes[2*i+2]);
            } else {
                treeNodes[i].setRight(null);
            }
        }
        return treeNodes[0];
    }

    /**
     * 通过中序遍历与前序遍历的结果推出原二叉树。
     * @param preOrder 前序遍历
     * @param inOrder 中序遍历
     * @return 二叉树
     */
    public TreeNode buildTreeByInOrderAndPreOrder ( int[] preOrder, int[] inOrder) {
        if (inOrder.length == 0) {
            return null;
        }

        if(inOrder.length == 1) {
            return new TreeNode(inOrder[0]);
        }
        else {
            int root = preOrder[0];
            TreeNode tree = new TreeNode(root);
            int index = 0;
            while( root != inOrder[index]){
                index++;
            }

            int[] leftTreeInOrder = Arrays.copyOfRange(inOrder, 0,index);
            int[] rightTreeInOrder = Arrays.copyOfRange(inOrder,index+1, inOrder.length);

            int[] leftTreePreOrder = Arrays.copyOfRange(preOrder, 1, leftTreeInOrder.length+1);
            int[] rightTreePreOrder = Arrays.copyOfRange(preOrder, leftTreePreOrder.length+1, preOrder.length);

            tree.setLeft(buildTreeByInOrderAndPreOrder(leftTreePreOrder, leftTreeInOrder));
            tree.setRight(buildTreeByInOrderAndPreOrder(rightTreePreOrder, rightTreeInOrder));
            return tree;
        }
    }

    /**
     * 通过中序遍历与后序遍历的结果逆推出树的结构
     * @param inOrder 中序遍历序列
     * @param postOrder 后续遍历序列
     * @return 逆推出的二叉树
     */
    public TreeNode buildTreeByInOrderAndPostOrder(int[] inOrder, int[] postOrder) {
        if(inOrder.length <= 0) {
            return null;
        }

        if(inOrder.length == 1) {
            return new TreeNode(inOrder[0]);
        } else {
            int root = postOrder[inOrder.length -1];
            TreeNode tree = new TreeNode(root);
            int index = 0;
            while(root != inOrder[index]) {
                index++;
            }
            int[] leftTreeInOrder = Arrays.copyOfRange(inOrder, 0,index);
            int[] rightTreeInOrder = Arrays.copyOfRange(inOrder, index+1, inOrder.length);

            int[] leftTreePostOrder = Arrays.copyOfRange(postOrder, 0, leftTreeInOrder.length);
            int[] rightTreePostOrder = Arrays.copyOfRange(postOrder, leftTreePostOrder.length, inOrder.length-1);

            tree.left = buildTreeByInOrderAndPostOrder(leftTreeInOrder, leftTreePostOrder);
            tree.right = buildTreeByInOrderAndPreOrder(rightTreeInOrder,rightTreePostOrder);
            return tree;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.getVal().equals(q.getVal())
                && isSameTree(p.getLeft(), q.getLeft())
                && isSameTree(p.getRight(), q.getRight());
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        return new TreeNode(root.val, invertTree(root.right), invertTree(root.left));
    }
}
