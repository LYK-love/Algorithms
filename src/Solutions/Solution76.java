package Solutions;

import java.util.*;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 *  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 */
class Solution76 {
    //

    /**
     * Sliding window:
     * 1. Right shift the right boundary of the window until the window satisfies the condition.
     * 2. If this window is better than last one( in this case, is the length smaller than thr last one), substitute the record with the better one.
     * A record includes the window's start position and length of the window.
     * 3.Then right shift the left boundary of the window until the condition breaks.
     * 4. Back to step (1).
     *
     * 对这道题而言， 由于t中的所有字符都要被包括在动态窗口中， 因此用hashmap来存储滑动窗口。 当条件被满足（t的所有字符都被包括在window中， 包括重复的字符， 如：t中如果有2个A， 则window中至少也要有2个A。）时就计算当前window长度，
     * 如果比上一个记录短， 则记录下当前window。然后不断缩小window的左边界直到条件不满足，接着继续循环。
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        Map<Character, Integer> window = new HashMap<>();


        int min_len = Integer.MAX_VALUE;
        int start = 0;

        int left = 0, right = 0;
        while(right < m){
            char ch = s.charAt(right);
            if( map.containsKey(ch) )
            {
                window.put(ch, window.getOrDefault(ch,0)+1);
            }
            right++;

            while(satisfy(map, window))
            {
                if(right - left < min_len)
                {
                    min_len = right - left;
                    start = left;
                }


                //Right shift the left boundary until the chars in window can't satisfy the map. which means breaking the while loop.
                char ch_drop = s.charAt(left);
                left++;

                if (window.get(ch_drop)==null)
                    ;
                else
                {
                    window.put(ch_drop,window.get(ch_drop)-1);
                    if (window.get(ch_drop) == 0)
                        window.remove(ch_drop);
                }
            }
        }

        //The window can't be created, thus the search is failed. Return "".
        if (min_len == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start+min_len);

    }

    /**
     * Make sure:
     * the number of key-value pairs of window and map are equal.
     * the occurrence of characters in window >= the occurrence of characters in map
     * @param map
     * @param window
     * @return
     */
    boolean satisfy(Map<Character, Integer> map, Map<Character, Integer> window)
    {
        if (map == window) return true;
        if (map == null || window == null) return false;
        if (map.size() != window.size()) return false;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (!window.containsKey(entry.getKey()) || entry.getValue() > window.get(entry.getKey())){
                return false;
            }
        }
        return true;
    }

}
