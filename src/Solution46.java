import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */
class Solution46 {

    /**
     * 这道题用回溯就可以轻易做出来。 难点在于如何在回溯的递归中保持原数组nums不变.
     *
     * 我当然可以每次new一个新的子数组使其用于递归, 但这样做会导致O(N^2)的空间复杂度, N为nums长度.
     * 证明：
     * 1. 我会拿出nums的一个元素X1， 将nums的剩余部分用于新建一个数组nums1，长度为N-1.
     * 2. 我会拿出nums1的一个元素X2， 将nums的剩余部分用于新建一个数组nums2，长度为N-2.
     * 3. ...
     * 4. 我会拿出nums1的一个元素X_N-1， 将nums的剩余部分用于新建一个数组nums_N-1，长度为1.
     * 5. 触发递归终止条件, 层层返回, 直到X1也被返回. 此时我们继续迭代nums的X1之后的下一个元素。
     *
     * 由上可知, 从X_{n}进入递归到X_{n}退出递归, 中间会开辟的新数组为： 长度为N-n的新数组 + 从X_{n+1}进入递归到X_{n+1}退出递归中间开辟的新数组
     *
     * 总空间在n = N-1时达到max, 为1+2+...+(N-1)+N = O(N^2)
     *
     * 因此, 为了不使用额外空间, 我在整个递归过程中只使用nums数组本身
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {

//        Set<Integer> nums_set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        List<Integer> track = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;

        Integer[] boxedArray = Arrays.stream(nums) // IntStream
                .boxed()                // Stream<Integer>
                .toArray(Integer[]::new);

        backtrack(new ArrayList<>(Arrays.asList(boxedArray)), len, track, res);
        return res;
    }

    //1 [2,3]  1
    //2 [3]   1,2
    //3 [] 1,2,3
    // --> 1,2,3
    //
    private void backtrack(ArrayList<Integer> nums, int LEN, List<Integer> track, List<List<Integer>> res)
    {
        if(track.size() == LEN )
        {
            res.add(new ArrayList<>(track));
            return;
        }

        //1 [2,3]
        //2 [3]
        //3 --> [1,2,3]
        //
        for(int i = 0; i < nums.size(); i++ )
        {
            Integer num = nums.get(i);

            track.add(num);

            //在回溯中保持nums不变
            nums.remove(num);
            backtrack(nums, LEN, track,res);
            nums.add(i,num);

            track.remove(track.size() - 1);
        }
    }
    
    public static void main(String[] args)
    {
        int[] nums = {2,3,1};
        List<List<Integer>> res = new Solution46().permute(nums);
        System.out.println(res);
    }

}