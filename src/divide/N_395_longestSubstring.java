package divide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 * 关键找出分治时可以把问题拆分时的判断。如果某个字符出现次数小于k，它一定不在符合要求的子串中，可以基于此将字符串拆分
 */
public class N_395_longestSubstring {

    public int longestSubstring(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        int res = 0;
        for(int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i))<k){
                int left = longestSubstring(s.substring(0,i), k);
                int right = longestSubstring(s.substring(i+1), k);
                res = Math.max(left, right);
                return res;
            }
        }
        return s.length();
    }


    public static void main(String[] args) {

    }
}
