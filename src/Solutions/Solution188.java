package Solutions;

/**
 * 188. Best Time to Buy and Sell Stock IV
 */
public class Solution188 {
    public int maxProfit(int K, int[] prices) {

        /**
         * dp[i][j][k]: 在天数为[0,1,2,...,i]的这段时间内, 当天的持有股票状态为{j}, 且最大交易数为{k}的情况下, 能达到的最大利润.
         * i = {0, 1, ..., prices.length-1}
         * j = {0,1}, 表达当天是否持有股票. 0: 不持有, 1: 持有.
         * k = {0,1,2, ...., K}: 最大交易次数, 共有K+1种情况.
         */
        Integer[][][] dp = new Integer[prices.length][2][K+1];
        buildDP(dp, prices.length-1, K, prices);//得到memo[prices.length-1][0][K], 即在最后一天(i=len-1)且当天不持有股票的(j=0)情况下能达到的最大利润.
        int max = dp[prices.length-1][0][K];
        return max;
    }

    /**
     * 使用动态规划.
     * 对memo[i][0][k], memo[i][1][k]进行赋值.
     */
    private void buildDP(Integer[][][] memo, int i, int k, int[] prices)
    {
        if( i < 0 || k < 0 ) return; //k is the number of max transaction, k can't be negative. So is i.
        if(memo[i][0][k] != null ) return;

        if(i == 0)
        {

            //在当天不持有股票(i=0)的情况下, 无论k为多少, 利润都为0.
            memo[i][0][k] = 0;

            //
            //如果当天的最大交易次数k>0, 那么可以通过q次buy和q-1次sell来使得当天能够持有股票, q <= k. memo[i][1][k] = -prices[i].
            //如果当天的最大交易次数k=0, 那么说明在当天不允许任何交易, 因此当天不可能持有股票. memo[i][1][k] = null;
            memo[i][1][k] = k>0 ? -prices[i]: null;

        }
        else
        {
            //DP, 得到第i-1天, 最大交易次数为k, k-1时的最大利润.
            buildDP(memo, i-1, k, prices);
            buildDP(memo, i-1, k-1, prices);

            if(k==0)
            {
                //如果第i天(i>0)的k=0, 说明[0,1,2,...,i]这段时间内不允许发生任何交易, 因此不能发生任何一次buy(因此也就不能有任何的sell).
                //如果j=0, 则[0,1,2,...,i]的最大利润就是[0,1,2,...,i-1]的最大利润, 因为不可能发生sell. memo[i][0][0] 会一直递归到memo[0][0][0] = 0.
                //如果j=1, 说明第i天当天持有了股票, 由于这段时间内不可能发生buy, 所以这种情况不可能发生. memo[i][1][k] = null
                memo[i][0][k] = memo[i-1][0][k];
                memo[i][1][k] = null;
            }
            else
            {
                //如果第i天(i>0)天k>0, 那么在此期间可以发生buy和sell.

                //如果当天不持有股票(j=0), 有两种情况:
                // 1. 昨天没有持有, 且今天rest. rest不消耗交易次数, 所以昨天的k和今天的一样, 因此求memo[i-1][0][k]
                // 2. 昨天持有了股票, 今天sell了. sell不消耗交易次数, 所以昨天的k和今天的一样, 因此求memo[i-1][1][k] + prices[i]
                memo[i][0][k] = Math.max(memo[i-1][0][k], memo[i-1][1][k] + prices[i]);

                //如果当天持有股票(j=0), 有两种情况:
                // 1. 昨天持有了股票, 且今天rest. sell不消耗交易次数, 所以昨天的k和今天的一样, 因此求memo[i-1][1][k]
                // 2. 昨天没有持有, 今天buy了. buy消耗交易次数, 所以昨天的k比今天的少一次(截至今天最多交易k次, 今天要buy, 消耗一次, 所以截至昨天就只能最多交易k-1次), 因此求memo[i-1][0][k]
                memo[i][1][k] = Math.max(memo[i-1][1][k], memo[i-1][0][k-1] - prices[i]);
            }
        }
        return;
    }
}
