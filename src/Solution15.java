import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * i,j不能相等， 但nums[i], nums[j]可以相等.
 *
 * 先以twoSum作为base case，当n>2时，nSum就不断地递归到n-1 Sum, 最后到twoSum
 */
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        init(nums);
        List<List<Integer>> res = nSum(nums,0,3,0);
        return res;
    }

    private void init(int[] nums) {
        Arrays.sort(nums);
    }

    private static int[] removeDuplicates(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
    }

    /**
     *
     * @param nums 必须是从小到大的有序数组， 允许元素重复
     * @param start
     * @param n
     * @param target nSum要达到的和
     * @return
     */
    public List<List<Integer>> nSum(int[] nums, int start, int n, int target) {

        List<List<Integer>> res = new ArrayList<>();

        //at least twuSum, and n must not greater than nums.length
        if( n < 2 || n > nums.length ) return res;

        //base case
        if( n == 2 )
        {
            int left = start;
            int right = nums.length - 1;

            while(left < right)
            {
                int two_sum = nums[left] + nums[right];
                if(two_sum > target)
                    right--;
                else if(two_sum < target )
                    left++;
                else
                {
                    res.add( new ArrayList<Integer>(Arrays.asList(nums[left], nums[right])));

                    //在twoSum中， 多次迭代的nums[left]和nums[right]不能重复
                    // 假设nums = {-1,-1, 2}, 前一步已经将i = 0, j = 2 放入res了， 那么k = 1 (nums[1])就不用计算了，否则res中就会有[[-1,2], [-1,2]]
                    //因此移动left和right， 使得多次迭代的nums[left]和nums[right]不重复
                    while( left + 1 < right && nums[left] == nums[left+1] ) left++;
                    while( right - 1 > left && nums[right] == nums[right-1] ) right--;
                }
            }
            return res;
        }
        else
        {
            //n > 2 时，递归计算 (n-1)Sum 的结果

            for( int i = start; i < nums.length; i++ )
            {
                int partial_target = target - nums[i];
                List<List<Integer>> res_of_partial_sum = nSum(nums, i+ 1, n - 1, partial_target);
                for( List<Integer> item: res_of_partial_sum )
                {
                    //// (n-1)Sum 加上 nums[i] 就是 nSum
                    item.add(nums[i]);
                    res.add(item);
                }
                while( i + 1 < nums.length && nums[i] == nums[i+1] ) i++;
            }
            return res;
        }
    }

    public static void main(String[] args)
    {
        Solution15 solution = new Solution15();
        int[] nums = {-1,0,1,2,-1,-4};


        System.out.println(solution.threeSum(nums));
    }

}