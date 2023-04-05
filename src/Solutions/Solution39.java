package Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 *  of at least one of the chosen numbers is different.
 *
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
class Solution39{

    /**
     * Use backtrack
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();

        backtrack(candidates,target, 0, res, track);

        return res;


    }

    /**
     *
     * @param candidates
     * @param target 目标和
     * @param start
     * @param res
     * @param track 记录回溯的路径
     */
    private void backtrack(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> track)
    {
        if( target == 0 )
        {
            res.add(new ArrayList<Integer>(track));// deep copy list
            return;
        }
        else if( target < 0 )
            return;
        else
        {
            for(int i = start; i < candidates.length; i++ )
            {
                track.add(candidates[i]);//try
                backtrack(candidates,target-candidates[i],i,res,track);//candidates 中的同一元素可以复用多次
                track.remove(track.size() - 1);//undo
            }
            return;
        }
    }

    public static void main(String[] args)
    {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        Solution39 s = new Solution39();
        List<List<Integer>> res = s.combinationSum(candidates,target);
        for( List<Integer> itemList: res )
        {
            System.out.println(itemList);
        }
    }

}
