package Solutions;

import Structures.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class Solution136 {

    /**
     * Use hashmap.
     * If the value of the k-v pair is 1, return the corresponding key.
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for( int num: nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            if(entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }
}
