package Solutions;

public class Solution122 {
    public int maxProfit(int[] prices) {
        Integer[][] memo = new Integer[prices.length][2];//dp[i][j]: 在i_{th}天能达到的最大利润. j=1： 当天是否持有股票. 题目规定每天只能同时持有最大1支股票.
        return dp(memo, prices.length-1, 0, prices);//在最后一天(i=len-1)且当天不持有股票的(j=0)情况下能达到的最大利润.

    }
    private Integer dp(Integer[][] memo, int day, int hasStock, int[] prices)
    {
        if(day == 0)
        {
            memo[day][0] = 0;
            memo[day][1] = -prices[day];
        }
        else if( memo[day][hasStock] == null)
        {
            memo[day][0] = Math.max(dp(memo, day-1, 0, prices), dp(memo, day-1, 1, prices) + prices[day]);
            memo[day][1] = Math.max(dp(memo, day-1, 0, prices) - prices[day], dp(memo, day-1, 1, prices));
        }
        else
            ;

        return memo[day][hasStock];
    }
}
