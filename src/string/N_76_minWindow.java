package string;

import javax.xml.stream.events.StartDocument;
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

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }


        int left = 0, right = 0;
        int leftBest = 0, rightBest = 0;
        int minLength = Integer.MAX_VALUE;
        int valid = 0;
        while (right < s.length()) {
            char rc = s.charAt(right);
            right++;
            if (need.containsKey(rc)) {
                window.put(rc, window.getOrDefault(rc, 0) + 1);
                if (window.get(rc).intValue() == need.get(rc).intValue()) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < minLength) {
                    minLength = right - left;
                    leftBest = left;
                    rightBest = right;
                }
                char lc = s.charAt(left);
                left++;
                if (need.containsKey(lc)) {
                    if (window.get(lc).intValue() == need.get(lc).intValue()) {
                        valid--;
                    }
                    window.put(lc, window.get(lc) - 1);
                }
            }
        }

        return minLength==Integer.MAX_VALUE ? "" : s.substring(leftBest, rightBest);
    }


    public static void main(String[] args) {
        N_76_minWindow bean = new N_76_minWindow();
        System.out.println(bean.minWindow("aa", "aa"));

    }
}
