package Solutions;

import java.util.HashMap;

/**
 * Given two strings t and s, return true if s contains a permutation of t, or false otherwise.
 *
 * In other words, return true if one of t's permutations is the substring of s.
 */
public class Solution567 {
    public boolean checkInclusion(String t, String s) {
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();

        for(Character ch: t.toCharArray())
            need.put(ch, need.getOrDefault(ch,0) + 1);

        int valid = 0;

        int left = 0, right = 0;
        while(right < s.length()) {
            Character chToAdd = s.charAt(right);
            window.put(chToAdd, window.getOrDefault(chToAdd, 0) + 1);
            right++;

            //Java 的 Integer，String 等类型判定相等应该用 equals 方法而不能直接用等号 ==，这是 Java 包装类的一个隐晦细节。所以在缩小窗口更新数据的时候，不能直接改写为 window.get(d) == need.get(d)
            if (need.containsKey(chToAdd) && need.get(chToAdd).equals(window.get(chToAdd)))
                valid++;

            //窗口首先扩大到t.length(). 接着判断其valid == need.size().
            //如果不是, 则窗口左边界缩小一次, 然后扩大又边界, 此时窗口大小依然是t.length(), 继续判断valid == need.size(). 重复此过程.
            while (right - left == t.length())
            {
                if(valid == need.size())//当我们发现某个字符在 window 的数量满足了 need 的需要，就要更新 valid，表示有一个字符已经满足要求
                    return true;

                char chToRemove = s.charAt(left);
                left++;

                if(need.containsKey(chToRemove) && need.get(chToRemove).equals(window.get(chToRemove)))
                    valid--;
                window.put(chToRemove, window.get(chToRemove)-1);
            }
        }
        return false;
    }
}
