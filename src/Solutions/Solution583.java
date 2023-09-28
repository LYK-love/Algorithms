package Solutions;

/**
 * Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
 *
 * In one step, you can delete exactly one character in either string.
 */
public class Solution583 {
    /**
     * 怎么样让两个字符串相同？直接全删成空串，肯定是相等了，但是题目又要求删除次数要尽可能少。
     *
     * 那怎么删？就是删成最长公共子序列嘛，换句话说，只要计算出最长公共子序列的长度，就能算出最少的删除次数了。
     *
     * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
     * @param s1
     * @param s2
     * @return
     */
    public int minDistance(String s1, String s2) {

        int M = s1.length(), N =  s2.length();
        int lcs = longestCommonSubsequence(s1,s2);

        int res = (M - lcs) + (N - lcs);
        return res;
    }

    /**
     * ongest Common Subsequence(最长共同子序列)和 [72. 编辑距离](https://leetcode.com/problems/edit-distance) 同为经典的双字符串动态规划问题.
     * 两个指针 `i, j` 在两个字符串上游走, 这就是"状态";
     * 字符串中的每个字符都有两种"选择", 要么在 `lcs` 中, 要么不在.
     */
    int longestCommonSubsequence(String s1, String s2)
    {
        int M = s1.length(), N =  s2.length();
        if(M==0 || N==0) return 0;

        Integer[][] memo = new Integer[M+1][N+1]; //memo[m][n]: s1[0,1,...,m-1]和 s2[0,1,...,n-1]的lcs的长度.
        return dp(M, N, memo, s1, s2);
    }

    private int dp(int m, int n, Integer[][] memo, String s1, String s2)
    {
        if(memo[m][n] != null)
            ;
        else
        {
            if(m==0 || n ==0)
                memo[m][n] = 0;//如果s1或者s2长度为0, 则lcs长度自然就是0
            else
            {
                //m,n是字符串长度, 因此在用于索引字符时要-1.
                if(s1.charAt(m-1) == s2.charAt(n-1))//如果末尾字符s1[m-1]和s2[n-1]相等, 那么s1[m-1]和s2[n-1]必然在lcs中
                    memo[m][n] = dp(m-1,n-1,memo,s1,s2) + 1;
                else
                    memo[m][n] = Math.max(
                            dp(m-1,n,memo,s1,s2),
                            dp(m,n-1,memo,s1,s2)
                    );//如果末尾字符s1[m-1]和s2[n-1]相等, 那么s1[m-1]和s2[n-1]至少有一个不在lcs中
            }
        }

        return memo[m][n];
    }
}
