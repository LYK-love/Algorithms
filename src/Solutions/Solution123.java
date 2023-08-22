package Solutions;

public class Solution123 {
    public int maxProfit(int[] prices) {
        int K = 3;
        Integer[][][] memo = new Integer[prices.length][2][K];//memo[i][j][k]: 在i_{th}天能达到的最大利润. j={0,1}:当天是否持有股票.题目规定每天只能同时持有最大1支股票. k={0,1,2}: 最大交易次数. 题目规定为3
        int max = dp(memo, prices.length-1, 0, 2, prices);//在最后一天(i=len-1)且当天不持有股票的(j=0)情况下能达到的最大利润.
        return max;
    }

    /**
     * 使用动态规划.
     * 返回[0,...,day]这段时间内, 在第{day}天持有股票状态为{hasStock}, 且最大交易次数为{numOfMaxTransactions}的情况下, 能得到的最大利润.
     */
    private Integer dp(Integer[][][] memo, int day, int hasStock, int numOfMaxTransactions, int[] prices)
    {
        //Initial condition
        if(day==0)
        {
            for( int k = 0; k <= numOfMaxTransactions; k++ )
            {
                memo[day][0][k] = 0;

                if(k >=1)
                    memo[day][1][k] = -prices[day];
                else
                    memo[day][1][k] = null; //在最多只能进行0次交易的情况下的情况下居然持有股票, 这是不可能的.
            }
        }
        else if(numOfMaxTransactions == 0 && hasStock == 1)//在最多只能进行0次交易的情况下的情况下居然持有股票, 这是不可能的, 因此memo[day][1][1] = null.
            ;

        //DP process
        else if( memo[day][hasStock][numOfMaxTransactions] == null)
        {
            if(  numOfMaxTransactions == 0)//[0,...,day-1]的最大交易次数为0, 这说明在`[0,...,day]`不会进行任何一次buy, 因此在第day天不可能sell
                memo[day][0][numOfMaxTransactions] = dp(memo, day-1, 0, numOfMaxTransactions, prices); //此时的 dp[i-1][1][k] == null
            else
                memo[day][0][numOfMaxTransactions] = Math.max(dp(memo, day-1, 0, numOfMaxTransactions, prices), dp(memo, day-1, 1, numOfMaxTransactions,prices) + prices[day]);

            if(numOfMaxTransactions == 0)//[0,...,day-1]的最大交易次数为0, 这说明在`[0,...,day]`不会进行任何一次buy, 因此在第day天不可能buy
                memo[day][1][numOfMaxTransactions] = dp(memo,day-1,1,numOfMaxTransactions, prices);//此时的 dp[i-1][1][k-1] == null
            else
                memo[day][1][numOfMaxTransactions] = Math.max(dp(memo,day-1, 0, numOfMaxTransactions-1, prices) - prices[day], dp(memo,day-1,1,numOfMaxTransactions, prices));
        }
        else
            ;
        return memo[day][hasStock][numOfMaxTransactions];
    }
}
