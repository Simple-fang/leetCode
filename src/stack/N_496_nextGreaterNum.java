package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 两个 没有重复元素 的数组nums1 和nums2，其中nums1是nums2的子集。
 *
 * 请你找出 nums1中每个元素在nums2中的下一个比其大的值。如果不存在，对应位置输出 -1
 */
public class N_496_nextGreaterNum {

    /*
    1.暴力解法：遍历num2，找到当前数在num2的位置，向后查找更大的数 O（N*M）
    2.单调栈：用来解决下一个更大/小元素问题。
    对于查找更大，从栈顶到栈底单调不递减。当前元素大于栈顶时，pop直到栈顶大于当前元素或栈为空，同时记录pop元素的下一更大元素为当前元素
    当前元素小于栈顶时，push入栈
     */
    private static int[] nextGreaterNum(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();    //存储元素->更大元素映射
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                int e = stack.pop();
                map.put(e, num);
            }
            stack.push(num);
        }

        int[] res = new int[nums1.length];
        for (int i=0 ; i<nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 4, 3, 5, 9};
        int[] nums2 = new int[]{1, 5, 4, 7, 3, 9};

        int[] res = nextGreaterNum(nums1, nums2);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
