package tree;

import base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *中序&后序重建二叉树
 */
public class N_106_buildTree2 {

    static Map<Integer, Integer> map = new HashMap<>();

    private static TreeNode buildTree(int[] inArr, int[] postArr) {
        for (int i = 0; i < inArr.length; i++) {
            map.put(inArr[i], i);
        }
        return buildTree(inArr, 0, inArr.length - 1, postArr, 0, postArr.length - 1);
    }

    private static TreeNode buildTree(int[] inArr, int inStart, int inEnd, int[] postArr, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postArr[postEnd];
        int rootIndex = map.get(rootVal);
        int leftSize = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(inArr, inStart, rootIndex - 1, postArr, postStart, postStart + leftSize - 1);
        root.right = buildTree(inArr, rootIndex + 1, inEnd, postArr, postStart + leftSize, postEnd - 1);

        return root;
    }

    private static void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        traverse(node.left);
        traverse(node.right);

    }

    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        traverse(root);
    }
}
