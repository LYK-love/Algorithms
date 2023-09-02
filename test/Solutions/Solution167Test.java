package Solutions;

import Utils.ArrayUtils;
import Utils.WrapperValueComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution167Test {
    Solution167 s = new Solution167();

    @Test
    void twoSum() {
        int[] numbers1 = new int[]{2,7,11,15};
        int target1 = 9;
        Integer[] exp1 = new Integer[]{1,2};
        Integer[] actual1 =  ArrayUtils.toWrapperArray(s.twoSum(numbers1,target1), Integer.class);


        int[] numbers2 = new int[]{2,3,4};
        int target2 = 6;
        Integer[] exp2 = new Integer[]{1,3};
        Integer[] actual2 =  ArrayUtils.toWrapperArray(s.twoSum(numbers2,target2), Integer.class);



        assertAll(
                ()-> Assertions.assertTrue(ArrayUtils.equalsFor1D(exp1,actual1, new WrapperValueComparator())),
                ()-> Assertions.assertTrue(ArrayUtils.equalsFor1D(exp2,actual2, new WrapperValueComparator()))
                );
    }
}