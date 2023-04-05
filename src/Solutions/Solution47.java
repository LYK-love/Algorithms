package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 */

class Solution47 {

    /**
     * 和其他permutation题的区别就是nums中会出现重复的元素, 对于重复的元素, 不让他们进行递归. 为此就要对递归剪枝.
     * 剪枝方法是: 先将所有元素排好序, 之后重复的元素就会排在一起. 对每次迭代, 如果当前元素和它的上一个元素相同, 就不让它进入递归. 由于所有的重复元素都会排在一起, 就不会有剪枝被遗漏.
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> track = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);


        Integer[] boxedArray = Arrays.stream(nums) // IntStream
                .boxed()                // Stream<Integer>
                .toArray(Integer[]::new);

        ArrayList<Integer> nums_list = new ArrayList<>(Arrays.asList(boxedArray));
        backtrack(nums_list, nums.length, track, res);

        return res;
    }

    private void backtrack(ArrayList<Integer> nums, int LEN, List<Integer> track, List<List<Integer>> res)
    {
        if( track.size() == LEN )
        {
            res.add(new ArrayList<>(track));
            return;
        }

        for(int i=0; i < nums.size(); i++)
        {

            if( i-1 >=0 && nums.get(i-1)== nums.get(i) )
                continue;

            int num = nums.get(i);

            track.add(num);

            nums.remove(i);
            backtrack(nums, LEN, track,res);
            nums.add(i,num);

            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {3,3,0,3};
        //0 3 3 3
        List<List<Integer>> res = new Solution47().permuteUnique(nums);
        System.out.println(res);
    }

}