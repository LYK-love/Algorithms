/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int starting_position = StandardAlgorithms.binary_search_for_first_occurrence(nums, target);

        int p = starting_position;
        if( p == -1 )
        {
            ;
        }
        else
        {
            while( p + 1 < nums.length && nums[p+1] == target )
            {
                p++;
            }
        }

        int ending_position = p;

        int[] res = new int[]{starting_position,ending_position};
        return res;
    }
}
