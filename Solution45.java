/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 */
class Solution45 {
    int jump(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }

    //[2,3,0,9,4]
    public int _jump(int[] nums) {
        int N = nums.length;

        int p = 0;
        int count = 0;

        while( p != N-1 )
        {
            if(p + nums[p] >= N-1)
            {
                count++;
                break;
            }

            int[] elements_in_jump_scope = get_elements_in_jump_scope(nums,p);
            int idx_of_max_element_in_jump_scope_elements = get_index_of_the_last_occurrence_of_max_element(elements_in_jump_scope);
            int idx_of_max_element_in_jump_scope = idx_of_max_element_in_jump_scope_elements + p + 1;
            p = idx_of_max_element_in_jump_scope;
            count++;

        }
        return count;
    }

    /**
     *
     * @param nums positive integer array
     * @param p current position
     * @return
     */
    private int[] get_elements_in_jump_scope(int[] nums, int p)
    {
        int jump_scope_from_p=nums[p];

        int[] elements_in_jump_scope = new int[jump_scope_from_p];

        for( int i = p+1, idx = 0; i <= p + jump_scope_from_p && i < nums.length; i++, idx++)
        {
            elements_in_jump_scope[idx] = nums[i];
        }
        return elements_in_jump_scope;
    }

    private int get_index_of_max_element(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return -1;

        int max_val = nums[0];
        int idx_of_max_val = 0;
        for(int i = 1; i < nums.length; i++)
        {
            if( max_val < nums[i])
            {
                max_val = nums[i];
                idx_of_max_val = i;
            }
        }
        return idx_of_max_val;
    }

    private int get_index_of_the_last_occurrence_of_max_element(int[] nums)
    {
        int idx_of_the_first_occurrence_of_max_element = get_index_of_max_element(nums);
        int p = idx_of_the_first_occurrence_of_max_element;
        while( p + 1 < nums.length && nums[p+1] == nums[p])
            p++;
        return p;
    }

    public static void main(String[] args)
    {
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        int res = new Solution45().jump(nums);
        System.out.println(res);
    }
}