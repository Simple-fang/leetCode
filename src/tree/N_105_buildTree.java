package tree;

import base.TreeNode;
import sun.text.bidi.BidiLine;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 已知二叉树的前序 & 中序遍历序列（不含重复数字），重建二叉树
 */
public class N_105_buildTree {

    static Map<Integer, Integer> map = new HashMap<>();

    private static TreeNode build(int[] preArr, int[] inArr) {
        for (int i = 0; i < inArr.length; i++) {
            map.put(inArr[i], i);
        }
        return build(preArr, inArr, 0, preArr.length - 1, 0, inArr.length - 1);
    }

    //pre : 3, 9, 20, 15, 7
    //in  : 9, 3, 15, 20, 7
    private static TreeNode build(int[] preArr, int[] inArr, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootIndex = map.get(preArr[preStart]);
        int leftSize = rootIndex - inStart;

        TreeNode root = new TreeNode(inArr[rootIndex]);
        //找到头节点，前序&中序分别去除头节点重建左右子数
        root.left = build(preArr, inArr, preStart + 1, preStart + leftSize, inStart, rootIndex - 1);
        root.right = build(preArr, inArr, preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd);
        return root;

    }



    private static void traverse(TreeNode root) {
        if (root==null) {
            return;
        }
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = build(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        traverse(root);
    }
}
