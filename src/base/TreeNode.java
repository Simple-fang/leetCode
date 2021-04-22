package base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode{
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode() {}
	public TreeNode(int val) {this.val = val;}
	public TreeNode(TreeNode left, TreeNode right, int val) {
		this.left = left;
		this.right = right;
		this.val = val;
	}
	
	//通过层次遍历结果重建二叉树
	public static TreeNode buildTree(int[] arr) {
		if(arr == null)
			return null;
		
		TreeNode root = new TreeNode(arr[0]);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		for(int i=1 ; i<arr.length && !queue.isEmpty() ; i+=2) {
			TreeNode cur = queue.poll();
			if(cur!=null) {
				TreeNode left = null;
				if(arr[i] != -1)
					left = new TreeNode(arr[i]);
				cur.left = left;
				queue.offer(left);
				
				TreeNode right = null;
				if(i+1 < arr.length && arr[i+1]!=-1)
					right = new TreeNode(arr[i+1]);
				cur.right = right;
				queue.offer(right);
			}
		}
		
		
		return root;
	}
	
	//打印二叉树层次遍历结果
	public static List<Integer> printTree(TreeNode root){
		if(root == null)
			return null;
		List<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if(cur!=null) {
				list.add(cur.val);
				TreeNode left = cur.left;
//				if(left!=null)
					queue.offer(left);
				TreeNode right = cur.right;
//				if(right!=null)
					queue.offer(right);
			}else {
				list.add(-1);
			}
		}
		
		return list;
	}
	
	
	
	public static void main(String[] args) {
		int[] root = {0, 1, 2, -1, 3, -1, 4, -1, -1, -1, -1};		//-1表示节点为null
		
		TreeNode r = buildTree(root);
		
		
//		TreeNode r = new TreeNode(0);
//		r.left = new TreeNode(1);
//		r.right = new TreeNode(2);
//		r.left.left = new TreeNode(3);
//		r.left.right = null;
//		r.right.left = null;
//		r.right.right = new TreeNode(4);
		
		List<Integer> list = printTree(r);
		System.out.println(list);
		
	}
}
