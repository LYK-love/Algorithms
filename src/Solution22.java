import java.util.ArrayList;
import java.util.List;

class Solution22 {
    public List<String> generateParenthesis(int n) {

        // 记录所有合法的括号组合
        List<String> res = new ArrayList<>();

        //回溯过程中的路径
        String track = "";

        //可用的左括号和右括号数量初始化为 n
        backtrack(n,n, track, res);
        return res;

    }

    /**
     * 回溯算法， 穷举得到所有合法的括号组合， 并放入res中
     * 可用的左括号数量为 left 个，可用的右括号数量为 right 个
     * 可以通过合法括号串的如下性质来减少不必要的枚举：
     * 1.  一个「合法」括号组合的左括号数量一定等于右括号数量.
     * 2. 对于一个「合法」的括号字符串组合 p，必然对于任何 0 <= i < len(p) 都有：子串 p[0..i] 中左括号的数量都大于或等于右括号的数量。
        * 因此对于回溯过程中的track， 其左括号数量必然大于等于右括号数量
     * @param left num_of_available_left_parenthesis
     * @param right
     * @param track 回溯过程中的路径
     * @param res
     */
    private void backtrack(int left, int right, String track, List<String> res)
    {
        //若左括号剩下的多，说明track中右括号数量大于左括号， 这样的track不合法
        if(left > right)
            return;

        //剩余的左右括号数量都不能<0
        if( left <0 || right < 0)
            return;

        //当所有括号都恰好用完（并且没有匹配前两个情况）时，track就是一个合法的括号组合
        if( left == 0 && right == 0)
        {
            res.add(track);
            return;
        }

        // 尝试放一个左括号
        track += '(';
        backtrack(left-1,right,track,res);
        track = track.substring( 0, track.length()-1 );// 撤消选择

        // 尝试放一个右括号
        track += ')';
        backtrack(left,right-1,track,res);
        track = track.substring( 0, track.length()-1 );// 撤消选择


    }
}