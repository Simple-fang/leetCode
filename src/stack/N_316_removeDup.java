package stack;

import java.util.Stack;

/**
 * 给定只包含小写字母的字符串，返回去重后字典序最小的字符串，要求不能打乱字符串中字符相对顺序
 */
public class N_316_removeDup {


    /*
    一般的去重，直接使用哈希即可；对于有序数组/链表，可使用快慢指针
    但本题要求返回字典序最小的结果，一般思路对去重后结果排序，但又要求了不能打乱相对顺序，似乎有些矛盾
    1 去重。 使用数组记录每个字符是否出现
    2 字典序最小&保持相对顺序。 使用单调栈
    3 只出现一次字符不可删除。 记录数组每个字符出现次数，当后面没有该字符，不再pop
     */
    private static String solution(String str) {
        boolean[] inStack = new boolean[256];
        int[] cnt = new int[256];
        for (char c : str.toCharArray()) {
            cnt[c]++;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            //每遍历字符，cnt--
            cnt[c]--;
            if(inStack[c])
                continue;

            while (!stack.isEmpty() && stack.peek() > c) {
                //如果后面字符不再存在，则停止pop
                if(cnt[stack.peek()]==0)
                    break;
                char e = stack.pop();
                inStack[e] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String res = solution("bcabc");
        System.out.println(res);
        String res2 = solution("cbacdcbc");
        System.out.println(res2);
    }
}
