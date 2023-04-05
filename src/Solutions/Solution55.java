package Solutions;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 */
class Solution55 {
    public boolean canJump(int[] nums) {
        Boolean[] memo = new Boolean[nums.length];
        dp(nums,memo,0);
        return memo[0];
    }

    /**
     * memo[i] = 从nums[i]能否跳到终点。
     *
     * Base case: 如果从memo[i]可以直接跳到终点, 即idx+jump_scope >= nums.length-1, 则memo[i] = true.
     * 否则, memo[i]依赖于它后面的状态, 即从memo[i]能跳到的位置中, 存不存在一个位置可以跳到终点.
     * 即memo[i] = memo[i+1] || memo[i+2] || ... || memo[i+jump_scope]
     * @param nums
     * @param memo
     * @param idx
     */
    void dp(int[] nums, Boolean[] memo, int idx)
    {
        int jump_scope = nums[idx];

        if(idx+jump_scope >= nums.length-1)
        {
            memo[idx] = true;
            return;
        }
        else
        {
            Boolean can_reach_end = false;
            for(int i=idx+1; i <= idx + jump_scope && i < memo.length; i++)
            {
                if( memo[i] == null )
                {
                    dp(nums,memo,i);
                }

                if( memo[i] == true)
                {
                    can_reach_end = true;
                    break;
                }
            }

            memo[idx] = can_reach_end;
            return;
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {3,2,1,0,4};
//                {2,3,1,1,4};
        boolean res = new Solution55().canJump(nums);
        System.out.println(res);
    }
}