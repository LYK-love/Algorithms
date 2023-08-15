package Solutions;

import java.util.LinkedList;
import java.util.List;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int[] maxArray = new int[prices.length];//maxArray[i] = 从第i天开始的当天最高价格.

        for(int i = prices.length - 1; i >= 0; i--)
        {
            if(i == prices.length - 1)
            {
                maxArray[i] = prices[i];
                continue;
            }
            maxArray[i] = Math.max(prices[i], maxArray[i+1]);
        }

        int[] profits = new int[prices.length];//profits[i] = 从第i天当日能达到的最高利润.
        for(int i = prices.length - 1; i >= 0; i--)
        {
            profits[i] = maxArray[i] - prices[i];
            if( profits[i] < 0) profits[i] = 0;
        }
        return getMax(profits);

    }
    private int getMax(int[] arr)
    {
        int max = arr[arr.length - 1];
        for(int i = arr.length - 1 - 1; i >= 0; i--)
        {
            max = Math.max(arr[i], max);
        }
        return max;
    }

}
