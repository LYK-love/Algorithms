package Solutions;

import Utils.ArrayUtils;

import java.util.Arrays;

public class Solution204 {
    public int countPrimes(int n) {
        Boolean[] isPrime = new Boolean[n];
        Arrays.fill(isPrime, true);

        for(int i = 2; i * i < n; i++)
        {
            if(isPrime[i])
            {
                for(int j = i * i; j < n; j+=i)
                {
                    isPrime[j] = false;
                }
            }
        }

        int cnt = 0;
        for(int i = 2; i < n; i++)
        {
            if(isPrime[i]) cnt++;
        }
        return cnt;
    }
}
