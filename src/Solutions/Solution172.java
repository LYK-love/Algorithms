package Solutions;

public class Solution172 {
    public int trailingZeroes(int n) {
        int res = 0;
        int divisor = 5;

        while( divisor <= n)
        {
            res += (n / divisor);
            divisor *= 5;
        }
        return res;
    }

}
