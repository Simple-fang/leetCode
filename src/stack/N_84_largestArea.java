package stack;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class N_84_largestArea {

    /*
    暴力解法：每个位置可形成最大矩形面积：即是向左右查找到第一个小于该矩形高度位置
     */
    private static int solution_1(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int left = i;
            for (; left-1 >= 0; left--) {
                if(height[left-1] < height[i])
                    break;
            }
            int right = i;
            for (; right+1 < height.length; right++) {
                if(height[right+1] < height[i])
                    break;
            }

            if(left<=right)
                res = Math.max(res, height[i] * (right - left + 1));

        }
        return res;
    }

    /*
    可看到计算每个位置最大面积关键是找到前后较小值，可以考虑使用单调栈
    栈顶到栈底单调递减，当栈顶元素大于当前元素时，即可找到前后较小值
     */
    private static int solution_2(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();

        //左右边界添加最小值,避免边界值判断
        int[] newHeight = new int[height.length + 2];
        for (int i = 1; i <= height.length; i++) {
            newHeight[i] = height[i - 1];
        }


        for (int i = 0; i < newHeight.length; i++) {
            while (!stack.isEmpty() && newHeight[stack.peek()] > newHeight[i]) {
                int h = newHeight[stack.pop()];
                int right = i;
                int left = stack.peek();

                res = Math.max(res, h * (right - left - 1));
            }
            stack.push(i);
        }

        return res;
    }


    public static void main(String[] args) {
        int[] height = new int[]{2, 1, 5, 6, 2, 3};
        int res_1 = solution_1(height);
        System.out.println(res_1);

        int res_2 = solution_2(height);
        System.out.println(res_2);
    }
}
