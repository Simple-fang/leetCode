package stack;

import java.util.Stack;

/**
 * 给你一个数组 T，这个数组存放的是近几天的天气气温，你返回一个等长的数组，
 * 计算：对于每一天，你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0。
 */
public class N_739_dailyTemperature {

    /*
    这个问题本质上还是寻找数组中下一个更大数，只不过结果不是下一个更大数是多少，而是距当前元素的距离
     */
    private static int[] solution(int[] temp) {
        int[] res = new int[temp.length];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[stack.peek()] < temp[i]){
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] temp1 = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] res1 = solution(temp1);
        for (int i : res1) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
