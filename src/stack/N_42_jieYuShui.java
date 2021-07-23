package stack;

import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class N_42_jieYuShui {

    /*
    首先想到计算接水总量，分别计算每个柱子可接水量（按列）
    1。暴力解法，每个位置接水量可找出前后高位置中较小值，减去该位置柱子高度，即是该列可接水量
     */
    private static int solution_1(int[] arr) {

        int[] left_max = new int[arr.length];   //存放各位置左边最大值
        int[] right_max = new int[arr.length];  //存放各位置右边最大值
        left_max[0] = arr[0];
        for (int i = 1 ; i < arr.length ; i++) {
            left_max[i] = Math.max(arr[i], left_max[i - 1]);
        }
        right_max[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            right_max[i] = Math.max((arr[i]), right_max[i+1]);
        }

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += Math.min(left_max[i], right_max[i]) - arr[i];
        }
        return res;
    }

    /*
    除了按列，按行也可得到总接水量总和
    可观察到，横向上每个可以接水量即是找到前后两个大值，其中较小值减去当前高度即为当前柱子可接水量，乘以两最大值之前间距，即是横向按行可接水量
    关键是找到前后两个最大值，可以考虑使用单调栈，栈底到栈顶单调递减，当栈中至少有两个元素，当前元素大于栈顶元素，即可得到栈顶前后两个大值
     */
    private static int solution_2(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if(stack.isEmpty())
                    break;
                int left = stack.peek();
                res += (Math.min(height[i], height[left]) - height[top]) * (i - left - 1);
            }

            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution_1(height));

        int[] height_2 = new int[]{4,2,0,3,2,5};
        System.out.println(solution_2(height_2));
    }
}
