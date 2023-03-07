import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
class Solution {
    

    /**
     * using sliding window with hashmap
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;

        int left = 0;
        int right = 0;

        Map<Character, Integer> window = new HashMap<>();
        while(right < s.length())
        {
            //right shift the right frontier of the window,
            //which means add the forehead next element to it
            char ch_right = s.charAt(right);
            window.put(ch_right, window.getOrDefault(ch_right, 0) + 1);
            right++;

            //if there's duplicated element in the window, then left shift the left frontier of the window,
            //which means remove the lestmost element of it
            while( window.get(ch_right) > 1)
            {
                char ch_left = s.charAt(left);
                window.put(ch_left, window.get(ch_left) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
        

        
    }
}
