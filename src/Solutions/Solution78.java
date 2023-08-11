package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an integer array nums of unique elements, return all possible
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        List<Integer> nums_wrapper = Arrays.stream(nums).boxed().collect(Collectors.toList());

        for(int k=0; k <= nums.length; k++)
        {
            backtrack(res, subset, nums_wrapper, 0, k);
        }
        return res;
    }

    // 1 2 3 4
    void backtrack(List<List<Integer>> res, List<Integer> subset, List<Integer> nums_wrapper, int start, int K)
    {

        if(subset.size() == K)
        {
            res.add(new ArrayList<>(subset));
            return;
        }

        for(int i=start; i < nums_wrapper.size(); i++)
        {
            Integer element = nums_wrapper.get(i);

            subset.add(element);

            backtrack(res,subset,nums_wrapper,i+1, K);

            subset.remove(element);
        }


    }
}
