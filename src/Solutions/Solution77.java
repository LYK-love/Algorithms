package Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 */
class Solution77{
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> track = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(track, res,1,n,k);
        return res;

    }

    void backtrack(List<Integer> track, List<List<Integer>> res, int start, int N, int K)
    {
        if(track.size() == K)
        {
            res.add(new ArrayList<>(track));
            return;
        }

        for( int i = start; i < N+1; i++ ){
            track.add(Integer.valueOf(i));
            backtrack(track,res, i+1, N, K);
            track.remove(Integer.valueOf(i));
        }
        return;
    }
}
