package Solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution204Test {

    Solution204 s = new Solution204();
    @Test
    void countPrimes() {
        int n1= 10;
        int expect1 = 4;//There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
        int actual1 = s.countPrimes(n1);


        int n2= 0;
        int expect2 = 0;
        int actual2 = s.countPrimes(n2);

        int n3= 1;
        int expect3 = 0;
        int actual3 = s.countPrimes(n3);


        assertAll(
                () -> Assertions.assertEquals(expect1, actual1),
                () -> Assertions.assertEquals(expect2, actual2),
                () -> Assertions.assertEquals(expect3, actual3)
        );
    }
}