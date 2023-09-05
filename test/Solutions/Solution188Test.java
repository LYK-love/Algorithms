package Solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution188Test {
    Solution188 s = new Solution188();
    @Test
    void maxProfit() {
        int [] prices1 = new int[]{2,4,1};
        int K1 = 2;

        int exp1 = 2; //Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
        int actual1 = s.maxProfit(K1, prices1);

        int [] prices2 = new int[]{3,2,6,5,0,3};
        int K2 = 2;
        int exp2 = 7; //Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
        int actual2 = s.maxProfit(K2, prices2);


        assertAll(
                ()-> Assertions.assertEquals(exp1,actual1),
                ()-> Assertions.assertEquals(exp2,actual2)
//                ()-> Assertions.assertEquals(exp3,actual3)


        );
    }
}