import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 */
class Solution40 {

    /**
     * 这道题和Solution39的区别在于: 本题的candidates 可能存在重复元素, 且其中的每个数字最多只能使用一次.
     * 如果按照Solution39的做法, 并仅仅确保每个数字最多被使用一次( 即for循环中新的回溯以i+1作为start)， 则在处理candidates存在重复元素的情况时， 无法确保combination是唯一的
     * 考虑如下情况：
     * candidates: [10,1,2,7,6,1,5], target = 8
     * 即, candidates[1]和candidates[5]的元素重复, 那么结果中就会有多个以1作为第0个元素的combination, e.g. [1,1,6]. 因为回溯算法在start=1和start=5时， 分别都会产生[1,1,6]这个结果并加到res中. 这就使得res中的combination
        无法唯一了.
     * 解决方法是先对candidates排序, 并且令在同一个for循环中, 如果两个相邻的candates[i]相等, 则只对其中之一进行回溯, 另一个则被"剪枝"
     * 例如, candidates排序后变为[1,1,2,6,5,7,10]
     * for循环中, i=0时我们选择candidates[0]进行回溯; 而i=1时, 由于candidates[1] = candidates[0], 就没必要对其回溯了, 直接跳过
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0, res, track);
        return res;
    }

    /**
     *
     * @param candidates must be sorted
     * @param target
     * @param start
     * @param res
     * @param track
     */
    private void backtrack(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> track)
    {
        if( target == 0)
        {
            res.add(new ArrayList<>(track));
            return;
        }
        else if(target < 0)
        {
            return;
        }
        else
        {
            for(int i=start; i < candidates.length; i++)
            {

                if( i > start && candidates[i] == candidates[i-1] )//剪枝
                    continue;
                track.add(candidates[i]);
                backtrack(candidates,target-candidates[i], i+1, res, track);
                track.remove(track.size()-1);
            }
        }
    }
}