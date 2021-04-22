package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import base.TreeNode;

/*
 * 查找二叉树最小深度
 * 
 * 首先明确最小深度即是根节点到叶子节点最短路径（叶子节点即是左子树右子树为null）
 * 二叉树只能从根节点到子节点遍历，不会走回头路，故不需要保存已访问节点
 */
public class N_111_minDepth {
	
	
	public static int minDepth(TreeNode root) {
		if(root==null) return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		//	root节点深度即为1层
		int depth = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			//for循环遍历所有邻接节点
			for(int i=0 ; i<size ; i++) {
				TreeNode cur = q.poll();
				if(cur.left==null && cur.right==null)
					return depth;
				
				if(cur.left!=null) {
					q.offer(cur.left);
				}
				if(cur.right!=null) {
					q.offer(cur.right);
				}
			}
			depth++;
		}
		
		return depth;
	}
	
	
	
	
	
	public static void main(String[] args) {
		int[] root = {0, 1, 2, -1, -1, 4, -1, -1, -1};		//-1表示节点为null
		
		TreeNode r = TreeNode.buildTree(root);
		System.out.println(minDepth(r));
		
	}
}
