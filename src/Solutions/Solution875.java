package Solutions;

import java.util.Arrays;


/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 */
class Solution875 {

    /**
     * 要满足总时间<h, 速度k肯定是越快越好, 但是koko要吃的最慢， 因此就是要找k的最小上界
     * 最普通的方法是将k从能取的最小值(k=1)到最大值( k = 最大堆的香蕉数量 就足够了) 遍历一遍, 取其中可行的最小值
     * 为了提升速度, 我使用了使用二分查找
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {

        int k_left = 1;
        int k_right = get_max_value(piles);

        while( k_left < k_right )
        {
            int k_mid = ( k_left + k_right ) / 2;

            if( hours_needed_with_given_speed(piles,k_mid) <= h)
            {
                k_right = k_mid;
            }
            else
            {
                k_left = k_mid + 1;
            }
        }
        return k_left;
    }

    /**
     * given speed k, return the time needed for koko to eat all the banana in piles.
     * @param piles
     * @param k
     * @return
     */
    private int hours_needed_with_given_speed(int[] piles, int k)
    {
        //deep copy, because we can't change content of piles
        int[] local_piles = new int[piles.length];
        System.arraycopy(piles,0,local_piles,0,piles.length);

        int hours_for_all_piles=0;
        for(int i = 0; i < local_piles.length; i++ )
        {
            hours_for_all_piles += local_piles[i] / k;
            if(local_piles[i] % k > 0)
                hours_for_all_piles++;
        }
        return hours_for_all_piles;
    }

    private int get_max_value(int[] piles)
    {
        int max_value = Arrays.stream(piles).max().getAsInt();
        return max_value;
    }
}
