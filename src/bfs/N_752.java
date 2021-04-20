package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。

锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。

列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 */

public class N_752 {

	//将s[i]拨轮加1
	private static  String plus(String s, int i) {
		char[] cs = s.toCharArray();
		if(cs[i] == '9')
			cs[i] = '0';
		else
			cs[i] += 1;
		
		return new String(cs);
	}
	
	//将s[i]拨轮减1
	private static String minus(String s, int i) {
		char[] cs = s.toCharArray();
		if(cs[i] == '0')
			cs[i] = '9';
		else
			cs[i] -= 1;
		
		return new String(cs);
	}
	
	private static int getRes(String[] deadEnds, String target) {
		Queue<String> queue = new LinkedList<String>();
		Set<String> deadStrs = new HashSet<String>();
		for(String str : deadEnds)
			deadStrs.add(str);
		List<String> visited = new ArrayList<String>();
		String start = "0000";
		queue.offer(start);
		visited.add(start);
		
		int step = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			//将当前队列中所有节点向周围扩散
			for(int i=0 ; i<size ; i++) {
				String s = queue.poll();
				
				if(deadStrs.contains(s))
					continue;
				if(s.equals(target))
					return step;
				
				visited.add(s);
				
				for(int j=0 ; j<4 ; i++) {
					String str_plus = plus(s, j);
					if(!visited.contains(str_plus))
						visited.add(str_plus);
					String str_min = minus(s, j);
					if(!visited.contains(str_min))
						visited.add(str_min);
				}
			}
			step++;
		}
		
		return -1;
	}
	
	
	
	public static void main(String[] args) {
		
		
	}
	
}


/*
 * 初始状态0000，每个拨轮可向上/下拨动，有两种状态；四个拨轮拨动一次共有8中可能，也即是每个节点有8个相邻节点
 * 求从初始状态转化为目标状态最少步骤，典型的图的最短路径问题，BFS求解
 * 
 * 除了使用队列存储邻接节点，还需保存死亡密码需跳过，每个拨轮可前后拨动，有可能回到已经访问的组合，需要保存已访问组合
 */
