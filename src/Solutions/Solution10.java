package Solutions;

/**
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 *
 * 思路：
 *  '.'很好处理， 它和任意的字符都匹配。
 *  '*'比较麻烦， 它有两种情况:
 *  1. '*'和它前面的字符连起来， 不匹配任何字符. 例如s = "aa", p = "b*"
 *  2. '*'和它前面的字符连起来, 可以匹配任意次它前面字符的重复组成的序列, 例如s = "aa", p = "a*"
 *
 *  我的做法是： 对于所有可能出现的情况，全部穷举一遍，只要有一种情况可以完成匹配，就认为 p 可以匹配 s
 *
 *  我们采用dp， 用两个指针i，j分别指向s和p中的字符。 dp[i][j]表示s[i:]和p[j:]相匹配
 *
 *  如果p[j+1] == '*':
 *  1. 对于情况1, 如果当前位置的字符已经匹配， 那么dp[i][j]自然就取决于dp[i][j+2], 也就是说递归地处理dp[i][j+2]
 *  2. 对于情况2, 如果当前位置的字符已经匹配, 那么dp[i][j]的值取决于dp[i+1][j]的值
 *
 *  只要上面两种情况的任意一种返回true， dp[i][j]就是true
 *
 *  当然了, 如果p[j+1] != '*', 那情况就简单多了， dp[i][j] = 当前位置的字符已经匹配 && dp[i+1][j+1]
 */
public class Solution10 {

    //
    Boolean[][] memo;

    public boolean isMatch(String s, String p) {

        //由于dp在边界情况下会检查i==s.length() + 1 和 j == p.length() + 1
        //因此数组大小也要扩大为[s.length() + 1][p.length() + 1]
        memo = new Boolean[s.length() + 1][p.length() + 1];

        return dp(s,p,0, 0);

    }

    private boolean isSingleCharMatch(char a, char ch_in_pattern)
    {
        return ( a == ch_in_pattern) || (ch_in_pattern == '.' );
    }

    /**
     * To avoid redundant computation, we can use memoization to store the previously computed results of dp(i, j) in a memo dictionary.
     * 1. The recursive function first checks if the result is already computed in the memo dictionary and returns it if so.
     *
     * 2. If j reaches the end of p, the function returns true if and only if i also reaches the end of s.
     *
     * 3. If the next character in p is followed by a '*', the function can match zero or more occurrences of the preceding character. The function recursively tries two cases:
     *  1. either skip the preceding character and the '*', or match the preceding character and recursively try to match the remaining part of s and p. The function returns true if either case succeeds.
     *  2. Otherwise, the function simply checks if the next character in p matches the next character in s or is a dot character ('.') that matches any character. If so, the function recursively tries to match the remaining part of s and p. The function returns true if both cases succeed.
     *
     * 4. Note that we have 2 corner cases:
     *  1. i == p.length. This is processed in step (2)
     *  2. i < p.length, but i == s.length. We find out that the matching can continue if and only if p[j+1] == '*'. And if this is true, we then recursively process dp(s,p,i+2, j)
     *
     * 5. After the process, we store the value in memo.
     * @param s
     * @param p
     * @param i
     * @param j
     * @return whether the substring s[i:] matches the pattern p[j:].
     */
    private boolean dp(String s, String p, int i, int j)
    {
        boolean ans_for_cur_idx;

        //Base case:
        //****************************
        if( memo[i][j] != null )
            return memo[i][j];

        //If j reaches the end of p, the function returns true if and only if i also reaches the end of s.
        if( j == p.length())
            ans_for_cur_idx =  i == s.length();

        //If j < p.length() && i == s.length(),then:
        //1. if p[j+1] != '*', the matching fails
        //2. if p[j+1] == '*', then we the matching can only success iff dp(s,p, i, j+2) successes.
            // Note that we don't need to consider dp(s,p, i+1, j) now because i hs already reached the end
        else if ( i == s.length() )
        {
            if( j + 1 < p.length() && p.charAt(j+1) == '*')
            {
                ans_for_cur_idx = dp(s,p, i, j+2);
            }
            else
                ans_for_cur_idx = false;
        }
        //***************************
        else
        {
            char ch_in_str = s.charAt(i);
            char ch_in_pattern = p.charAt(j);


            boolean cur_chars_match = isSingleCharMatch(ch_in_str,ch_in_pattern);

            //注意到， 如果p[j+1] == '*'， 此时i和j+1都已经是数组的合法下标,接下去我会计算dp[i][j+2]和和dp[i+1][j]，
            //因此i最大可以为s.length() , 因此j最大可以为p.length().
            //如果i = s.length()或p.length()就会被前面的逻辑特判， 因此不会出现i和j不会更大了。
            //也因此， memo的大小为 (s.length() + 1) *  (p.length() + 1)
            if( j + 1 < p.length() && p.charAt(j+1) == '*')
            {
                ans_for_cur_idx = dp(s,p,i,j+2) || ( cur_chars_match && dp(s,p, i+1, j) );
            }
            else
            {
                ans_for_cur_idx = cur_chars_match && dp(s,p,i+1,j+1);
            }
        }

        memo[i][j] = ans_for_cur_idx;
        return ans_for_cur_idx;


    }

    public static void main(String[] args)
    {
        Solution10 solution = new Solution10();
        String s = "aa";
        String p = "a*";

        System.out.println(solution.isMatch(s,p));
    }
}
