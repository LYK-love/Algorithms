import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array `nums`, find the subarray with the largest sum, and return its sum.
 */
class Solution53 {


    /**
     * DP. DP数组定义: memo[i] = 以nums[i]为结尾的具有最大和的子数组的最大和.
     * 因此对于nums[i], 要么选择拼接上以nums[i-1]为结尾的具有最大和的子数组, 要么不与前面的子数组连接, 自己成为一个新子数组的开头.
     * 因此memo[i] = max(memo[i-1] + nums[i], nums[i])
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        dp(nums,memo,nums.length-1);//recursion

        //现在memo数组已经被构建完毕, 只需遍历memo数组, 找出最大的memo[i]
        int[] arr = Arrays.stream(memo).mapToInt(Integer::intValue).toArray();
        int res = ArrayUtils.get_max(arr);
        return res;
    }

    void dp(int[] nums, Integer[] memo, int i )
    {
        if(i==0)
        {
            memo[i] = nums[i];
            return;
        }

        if( memo[i-1] == null )
            dp(nums,memo,i-1);
        memo[i] = Math.max( nums[i] + memo[i-1], nums[i] );
    }

    public static void main(String[] args)
    {
        Solution53 s = new Solution53();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        int res  = s.maxSubArray(nums);
        System.out.print(res);


    }

}