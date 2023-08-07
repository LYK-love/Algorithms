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
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        Integer[][] memo = new Integer[m][n]; //定义：word1[0..i] 和 word2[0..j] 的最小编辑距离是 memo[i][j]
        return dp(word1,word2,m-1,n-1, memo);
    }

    /**
     * rok
     *
     * abcros
     * horse
     * @param word1
     * @param word2
     * @param i
     * @param j
     * @param memo
     * @return
     */
    private int dp(String word1, String word2, int i, int j,  Integer[][] memo)
    {
        if(i == -1)
            return j + 1;
        else if( j == -1 )
            return i + 1;

        if(memo[i][j] != null)
            return memo[i][j];

        if( word1.charAt(i) == word2.charAt(j) )
        {
            memo[i][j] = dp(word1,word2, i-1, j-1, memo);
        }
        else
        {
            memo[i][j] = min(
                    dp(word1,word2, i, j-1, memo)+1, //insert
                    dp(word1,word2, i-1, j, memo)+1,//delete
                    dp(word1,word2, i-1, j-1, memo)+1 //replace
                    );
        }

    return memo[i][j];
    }

    int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}