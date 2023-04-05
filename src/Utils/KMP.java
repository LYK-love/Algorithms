package Utils;

/**
 * Knuth-Morris-Pratt Algorithm for pattern matching
 * This is a DFA implementation for string pattern matching. Using DFA is to simplify the understanding.
 *
 * Def:
 *  Pattern of length: $M$
 *  Text of length: $N$
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(MN)
 *
 * It supposes that the input tokens are all ASCII characters, so the module of possible token set is 256.
 * So for this implementation, the space complexity is actually $O(256M) = O(M)$
 *
 *
 */
public class KMP {
    private int[][] dfa;

    //pattern string to be matched
    private String pat;

    public KMP(String pat)
    {
        this.pat = pat;


        //dfa的初始状态为0, 终止状态为pattern.length - 1
        //因此: dfa的状态数量 = pattern串长度
        int M = pat.length();

        //dfa接受的token集合的模. 因为输入的是ASCII字符, 所以总共有256种可能的token
        int R = 256;

        //dfa下个状态 = dfa[token][当前状态]
        dfa = new int[R][M];

        // base case
        dfa[pat.charAt(0)][0] = 1;

        //backup state X, 初始为 0
        int X = 0;

        //// 当前状态 j 从 1 开始
        for( int j = 1; j < M; j++ )
        {
            //ch即在当前状态可能遇到的token, 它必定是ascii字符, 我们按照{0, ..., 255}的整数处理
            for(int ch = 0; ch < R; ch++ )
            {
                //遇到的token与pat[j]一致
                if( pat.charAt(j) == ch)
                    dfa[pat.charAt(j)][j] = j+1;

                //遇到的token与pat[j]不一致, 则回退到backup state X
                else
                    dfa[ch][j] = dfa[ch][X];
            }

            //update backup state
            X = dfa[pat.charAt(j)][X];
        }
    }

    /**
     * Searching the pattern in the given text, returns the index of the  first occurrence of pattern in text, or -1 if pattern is not part of text.
     * @param text
     * @return
     */
    public int search(String text)
    {
        int M = pat.length();
        int N = text.length();
        int j = 0;
        for(int i = 0; i < N; i++ )
        {
            // 计算 pat 的下一个状态
            int ch = text.charAt(i);
            j = dfa[ ch ][j];

            // 到达终止态，返回结果
            if( j == M  )
                return i - M + 1;
        }

        // 没到达终止态，匹配失败
        return -1;
    }
}


