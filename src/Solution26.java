/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
class Solution26 {
    /**
     * 这道题本可以用Stack来解决， 但由于限定了O(1)的额外空间复杂度， 就不能用额外的数据结构了。
     * 我们用快慢指针来解决。 fast指针每次前进一步，如果fast指针指向的值和slow的值不一样， 则slow指针移动， 并将slow指针的值更改为fast指向的值（即新的值）； 否则slow指针不移动
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;

        while(fast != nums.length)
        {
            if(nums[fast] != nums[slow])
            {
                slow++;
                nums[slow] = nums[fast];
            }
            else
                ;
            fast++;
        }
        return slow+1;

    }
}