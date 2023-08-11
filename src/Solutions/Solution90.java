package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * nums的元素有重复，需要剪枝。
 *
 */
class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(nums);//先排序，使得要剪枝的元素位于相邻位置。
        List<Integer> nums_wrapper = Arrays.stream(nums).boxed().collect(Collectors.toList());

        for(int k=0; k <= nums.length; k++)
        {
            backtrack(res, subset, nums_wrapper, 0, k);
        }
        return res;
    }

    void backtrack(List<List<Integer>> res, List<Integer> subset, List<Integer> nums_wrapper, int start, int K)
    {

        if(subset.size() == K)
        {
            res.add(new ArrayList<>(subset));
            return;
        }

        //1,2,2
        for(int i=start; i < nums_wrapper.size(); i++)
        {
            //从当前节点出发的分支为: nums[start, ...]
            //剪掉其中重复的枝条
            //注意，对于start左边的节点(nums[start -1])， 它们并非从当前节点出发的分支， 而是回溯路径中之前已经选好的节点，不能被剪掉。
            if(i >= 1 && i - 1 >= start && nums_wrapper.get(i) == nums_wrapper.get(i-1))
                return;

            Integer element = nums_wrapper.get(i);

            subset.add(element);

            backtrack(res,subset,nums_wrapper,i+1, K);

            subset.remove(element);
        }

    }
}
