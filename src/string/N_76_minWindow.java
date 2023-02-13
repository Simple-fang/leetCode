package string;

import java.util.*;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 * ·对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量
 * ·如果 s 中存在这样的子串，我们保证它是唯一的答案
 */
public class N_76_minWindow {

    //s:ADOBECODEBANC t:ABC
    //res:BANC
    private String minWindow(String s, String t){
        String res = "";
        if (s == null || t == null || s.length() < t.length()) {
            return res;
        }

        // 构造欠债表
        HashMap<Character, Integer> debt = new HashMap<>();
        for (char c : t.toCharArray()) {
            debt.put(c, debt.getOrDefault(c, 0) + 1);
        }
        // 欠债总数
        int all = t.length();

        int l = 0;
        int r = 0;
        int minLen = Integer.MAX_VALUE;
        int leftBest = -1;
        int rightBest = -1;
        while (r < s.length()) {
            // r 进入窗口
            char c = s.charAt(r);
            if (debt.containsKey(c)) {
                // 有效还款
                if (debt.get(c) > 0) {
                    all--;
                }
                debt.put(c, debt.get(c) - 1);
            }

            // 满足条件时， 缩小窗口， l右移
            while (all == 0) {
                // 更新最优结果
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    leftBest = l;
                    rightBest = r;
                }

                // l 右移
                char cl = s.charAt(l);
                if (debt.containsKey(cl)) {
                    if (debt.get(cl) >= 0) {
                        all++;
                    }
                    debt.put(cl, debt.get(cl) + 1);
                }
                l++;
            }
            r++;
        }


        return minLen == Integer.MAX_VALUE ? "" : s.substring(leftBest, rightBest + 1);

    }


    public static void main(String[] args) {
        N_76_minWindow bean = new N_76_minWindow();
        System.out.println(bean.minWindow("a", "a"));

    }
}
