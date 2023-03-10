/**
 *
 * https://leetcode.com/problems/container-with-most-water/
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 */
public class Solution11 {

    /**
     * use double-pointer method, the area between the left and right pointers is:
     *  min(height[left], height[right]) * (right - left)
     *
     *  Note that for each iteration, we need to move the pointer with the lower height. This is because the area depends on:
     *  1. (right - left)
     *  2. min(height[left], height[right])
     *
     *  For each iteration, (right - left) keeps decreasing. So in order to get maximized area, we need to pay attention to min(height[left], height[right]),
     *  because it only depends on the min value, we must move the lower side.
     *
     *  Explanation:
     *  If we move the higher side, the area will never be larger( the new side may be higher or unchanged, but since the min value is just the same, and (right - left) decreases, the area is smaller.
     *  Or the new side may be less, then the area is smaller too. ).
     *  But if we  move the lower side, and if the new height becomes higher, then the area can be larger.
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int res = 0;

        while(left<right)
        {
            int cur_area = Math.min( height[left], height[right]) * ( right - left );
            res = res < cur_area ? cur_area: res;

            if( height[left] < height[right])
                left++;
            else
                right--;
        }
        return res;
    }
}
