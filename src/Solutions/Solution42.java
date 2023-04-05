package Solutions;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/trapping-rain-water/submissions/912486410/
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */
class Solution42 {

    //dp数组, memo_left_max[i]: 位置i的柱子左侧(不含i)的最高的柱子的高度
    Integer[] memo_left_max;

    //dp数组, memo_right_max[i]: 位置i的柱子右侧(不含i)的最高的柱子的高度
    Integer[] memo_right_max;

    //water_bar_array[i]: 位置i的柱子能接的水的数量
    int[] water_bar_array;


    /**
     * 位置i的柱子能接的水的数量, 取决于自身的高度, 以及左右两侧(不含i)的最高的柱子的高度中的最小值。
     * 例如: height = {3,1,2}, i = 1. 则柱子i接水后能达到的高度是2， 因为左侧最高柱子高度为3, 右侧最高柱子高度为2, 柱子i接水后最高能达到高度2
     * 但是, height = {3,4,2}, i = 1. 则由于左右两侧最高柱子高度的最小值是2, 而柱子i自身高度为3, 即没有形成"凹槽", 则柱子i接不了水
     *
     *
     * The max height of the bars left to bar i:
     *  int max_height_left = dp_left_max(height, i);
     *
     * The max height of the bars right to bar i:
     *  int max_height_right = dp_right_max(height, i);
     *
     * The min height between ( the max height of the bars left to the bar i ) and ( the max height of the bars right to the bar i ):
     *  int min_between_lmax_and_rmax = Math.min( max_height_left, max_height_right )
     *
     * 对于位置 i，能够装的水为：
     *  water_bar_array[i] = min_between_lmax_and_rmax > height[i] ? min_between_lmax_and_rmax - height[i] : 0;
     *
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        memo_left_max = new Integer[height.length];
        memo_right_max = new Integer[height.length];

        water_bar_array = new int[height.length];


        for( int i = 0; i < water_bar_array.length; i++ )
        {
            // 找到位置i的柱子的左右两侧(不含i)的最高的柱子的高度中的最小值
            int max_height_left = dp_left_max(height, i);
            int max_height_right = dp_right_max(height, i);

            //The min height between ( the max height of the bars left to the bar i ) and ( the max height of the bars right to the bar i )
            int min_between_lmax_and_rmax = Math.min( max_height_left, max_height_right );

            //如果左右两侧最高柱子的高度的最小值小于等于柱子i的高度, 那柱子i也接不了雨水
            water_bar_array[i] = min_between_lmax_and_rmax > height[i] ? min_between_lmax_and_rmax - height[i] : 0;
        }

        return Arrays.stream(water_bar_array).sum();

    }

    /**
     * Build memo array.
     *
     * @param height
     * @param i the i_th bar
     * @return the max height of the bars left to bar i.
     */
    int dp_left_max(int[] height, int i)
    {
        if(memo_left_max[i] != null )
            return memo_left_max[i];

        int res;

        if( i == 0 )
            res =  0;
        else
        {
            //第i个柱子左侧的最高的柱子的高度, 就等于这二者中的最大值:
            //1. 第i-1个柱子的高度
            //2. 第i-1个柱子左侧的最高的柱子的高度, 即进入递归
            res = Math.max(height[i-1], dp_left_max(height, i - 1));
        }
        memo_left_max[i] = res;
        return res;

    }

    /**
     * Build memo array.
     *
     * @param height
     * @param i the i_th bar
     * @return the max height of the bars right to bar i.
     */
    int dp_right_max(int[] height, int i)
    {
        if(memo_right_max[i] != null )
            return memo_right_max[i];

        int res;

        if( i == height.length - 1 )
            res = 0;
        else
        {
            //第i个柱子右侧的最高的柱子的高度, 就等于这二者中的最大值:
            //1. 第i+1个柱子的高度
            //2. 第i+1个柱子右侧的最高的柱子的高度, 即进入递归
            res = Math.max(height[i+1], dp_right_max(height, i + 1));
        }
        memo_right_max[i] = res;
        return res;
    }
}
