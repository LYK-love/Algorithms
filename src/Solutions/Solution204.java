package Solutions;

import Utils.ArrayUtils;

import java.util.Arrays;

public class Solution204 {
    public int countPrimes(int n) {
        Boolean[] isPrime = new Boolean[n];
        Arrays.fill(isPrime, true);

        //Remove all composite numbers that are multiples of p and less than n.
        //Since we always have p <= \sqrt{n}, we just iterate p to  \sqrt{n}.
        for(int p = 2; p * p < n; p++)
            if(isPrime[p])
                for(int m = p * p; m < n; m+=p)
                    isPrime[m] = false;

        int cnt = 0;
        for(int i = 2; i < n; i++)
        {
            if(isPrime[i]) cnt++;
        }
        return cnt;
    }
}
