package Solutions;

import java.util.Arrays;

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

    /**
     * @param nums
     * @return
     */
    int jump(int[] nums) {
        int N = nums.length;
        int[] memo = new int[N];

        Arrays.fill(memo, N);//备忘录都初始化为 N, 相当于 INT_MAX. 因为从 0 跳到 n - 1 最多 n - 1 步
        return dp(memo, nums, 0);
    }

    /**
     *
     * @param memo
     * @param nums
     * @param p 当前所在的数组元素下标
     * @return 从索引 p 跳到最后一格，至少需要的步数
     */
    private int dp(int[] memo, int[] nums, int p)
    {
        int N = nums.length;

        if(p >= N-1)
            return 0;

        //子问题已经计算过
        if( memo[p] != N )
            return memo[p];

        //nums[p]==0, 意味着从p无法跳到目标, 直接返回memo[p]的初始值( 为N, 表示不可达 )
        if( nums[p] == 0 )
            return memo[p];

        else
        {
            int jump_scope_from_p=nums[p];

            for( int i = 1; i <= jump_scope_from_p && i + p < nums.length; i++ )
            {
                //{5,9,3,2,1,0,2,3,3,1,0,0};
                //计算每一个子问题的结果, 取其中最小的作为最终结果
                memo[p] = Math.min( dp(memo, nums, i+p) + 1, memo[p]);
            }
        }
        return memo[p];
    }

    //[2,3,0,9,4]

    /**
     * get the subarray of nums. The subarray is formed by the elements in the jump scope of nums[p].
     * @param nums positive integer array
     * @param p current position
     * @return the slice array of elements in the jump scope of nums[p]
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



    public static void main(String[] args)
    {
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        int res = new Solution45().jump(nums);
        System.out.println(res);
    }
}