package Solutions;

/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 */
class Solution72 {
    //用两个指针 i, j 分别指向两个字符串的最后，然后一步步往前移动，缩小问题的规模。
    public int minDistance(String s1, String s2) {
        int M = s1.length(), N = s2.length();
        Integer[][] memo = new Integer[M+1][N+1]; //定义：s1[0, .., M-1] 和 s2[0, .., N-1] 的最小编辑距离是 memo[M][N]
        return dp(M,N, memo, s1,s2);
    }

    /**
     * memo[m][n]: m位的s1 和 n位的s2 的最小编辑距离.
     * m = s1.length()
     * n = s2.length()
     */
    private int dp(int m, int n, Integer[][] memo, String s1, String s2)
    {
        if(memo[m][n] != null)
            ;
        else
        {
            if(m==0)//s1.length() == 0
                memo[m][n] = n; // insert * n
            else if (n==0)//s2.length() == 0
                memo[m][n] = m; // remove * m
            else
            {
                if( s1.charAt(m-1) == s2.charAt(n-1) )
                    memo[m][n] = dp(m-1,n-1,memo,s1,s2); //skip
                else
                {
                    //m,n是字符串长度, 因此在用于索引字符时要-1.
                    memo[m][n] = min(
                            dp(m,n-1,memo,s1,s2),//insert
                            dp(m-1,n, memo, s1,s2),//remove
                            dp(m-1,n-1,memo,s1,s2)//replace
                    )+1;
                }
            }
        }
        return memo[m][n];
    }

    int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}