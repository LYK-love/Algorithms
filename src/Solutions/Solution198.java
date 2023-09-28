package Solutions;

public class Solution198 {
    public int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length];// memo[i]: 从第i间房子开始, 能抢到的最大值.
        return dp(0,memo,nums);
    }

    private int dp(int start, Integer[] memo, int[] nums)
    {
        if(memo[start] != null)
            ;
        else
        {
            if(start == nums.length - 1)
                memo[start] = nums[start];
            else if( start == nums.length-2)
                memo[start] = Math.max(dp(start+1,memo, nums), nums[start]);
            else
                memo[start] = Math.max(dp(start+1,memo, nums), nums[start] + dp(start+2, memo, nums));
        }
        return memo[start];
    }
}
