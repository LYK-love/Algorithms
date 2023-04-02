public class StandardAlgorithms {

    /**
     * [5,7,7,8,8,10]
     *
     * search the first occurrence of the given value in a sorted array.
     * 二分查找很简单, 但查找二分查找左侧边界需要一些更细致的判断
     * The time complexity is O(log N)
     * @param nums sorted array, length = N
     * @param target given value
     * @return the index of the first occurrence of the given value, or -1 if the given value doesn't exist in the array
     */
    public static int binary_search_for_first_occurrence(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length-1;

        //searching space: [left, right]. At each iteration we shrink the searching space.

        //In beginning of the last iteration, the searching space = [left, right], left == right. Then mid = left = right. So we only have to compare only one element( nums[left == right == mid]) with `target`
        //During the last iteration:
        //1. If search hit( we find the target, and due to our special design `right = mid - 1`, which will be explained laterm we can ensure the target is the leftmost occurrence),
        //  we have nums[mid = left = right] = target, then we execute `right = mid - 1;`. So after the searching process, we get searching space[left, left -1].
        //2. If target is not in the array and nums[0] < target < nums[nums.length-1]. It's possible that nums[mid] < or > target. So we get searching space[left, left -1] or [left+1,left]

        //3. If the target value is larger than all values of nums, we have mid == left == right == nums.length - 1, then we execute `left = mid+1;`, so we get the searching space[left, right] = [nums.length, nums.length-1].
        //4. If the target value is less than all values of nums, we have mid == left == right == 0, then we execute `right = mid-1;`, so we get the searching space[left, right] = [0, -1].
        //
        //In all cases, after the iterations, the searching space is null ( left bound > right bound ), which indicates that the search is over.
        //这也是循环条件为`left <= right`而非`left < right`的原因. 对于前者, 当搜索空间为空时循环终止; 对于后者, 循环终止后搜索空间还会剩下一个元素, 还需要特盘。

        //If case 1, then left is the index of the first occurrence of target.
        // And it's possible that left = 0, right = -1, nums[left] == target. In this case we have answer = 0.
        // But it's impossible that `left = nums.length`. Because if answer  = have left = nums.length - 1, right = nums.length - 2, nums[left] == target. So if
        //  `left = nums.length`, it must not be case 1. We can just return -1.
        //If case 2, then nums[left] != target, return -1
        //If case 3, then we have left = nums.length, right = nums.length-1, return -1
        //If case 4, then we have left == 0, right == -1, nums[left] != target, return -1.
        //  From former sentences, we know that it's possible in case 1 that left == 0, right == -1. So in order to identify case 4, we have to get `nums[left] != target`

        //To sum, we will return -1 if:
        // 1. `left = nums.length`, it's case 3.
        // 2. `left == 0, right == -1` and `nums[left] != target`, it's case 4
        // 3. `nums[left] != target`, it's case 2
        //This logic is presented by `if(left == nums.length || nums[left] != target )`
        while(left <= right)
        {
            int mid = (left + right) / 2;

            //Because we want to find the leftmost occurrence of target, if during one iteration we get nums[mid] == target, we can't just return.
            //To improve understanding, we mark some constants MID, LEFT, RIGHT. So that MID, LEFT, RIGHT = mid, left, right.
            //Then must shrink the right bound to further search in [LEFT, MID) to see if any other target occurs in [LEFT, MID).

            //During the further iterations:
            //case A: if the target doesn't exist in [LEFT, MID), which means that nums[MID] is indeed the fist occurrence, then the iterations will end with [MID, MID), left = MID, so the pointer `left` is still the right answer
            //  e.g: {0,1,2,3,4}
            //case B: If duplicated targets do exist in [LEFT, MID), then we iterate the shrinking until case A happens.
            //  e.g: //{0,1,2,2,2,5,6}
            if(nums[mid] == target){
                right = mid - 1;
            }
            //由于搜索空间是个闭区间, 所以在已知nums[mid]不匹配的情况下, 后面的搜索空间中就不需要包括mid了. 只需搜索[left, mid-1] or [mid+1, right]
            else if(nums[mid] > target)
            {
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }

        //process case 2,3,4
        if(left == nums.length || nums[left] != target )
            return -1;
        //process case 1 (nums[left] == target)
        else
            return left;
    }
}
