package Solutions;

import Utils.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution56Test {

    Solution56 s = new Solution56();
    @Test
    void merge() {
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals2 = {{1,4},{4,5}};
        int[][] intervals3 = {{1,4},{0,4}};
        int[][] intervals4 = {{1,4},{2,3}};



        int[][] expected_output1 = {{1,6},{8,10},{15,18}};
        int[][] expected_output2 = {{1,5}};
        int[][] expected_output3 = {{0,4}};
        int[][] expected_output4 = {{1,4}};



        System.out.println(ArrayUtils.toString(expected_output1));
        System.out.println(ArrayUtils.toString(expected_output2));
        System.out.println(ArrayUtils.toString(expected_output3));
        System.out.println(ArrayUtils.toString(expected_output4));



        assertAll(
                () -> Assertions.assertEquals(ArrayUtils.toString(expected_output1), ArrayUtils.toString(s.merge(intervals1))),
                () -> Assertions.assertEquals(ArrayUtils.toString(expected_output2), ArrayUtils.toString(s.merge(intervals2))),
                () -> Assertions.assertEquals(ArrayUtils.toString(expected_output3), ArrayUtils.toString(s.merge(intervals3))),
                () -> Assertions.assertEquals(ArrayUtils.toString(expected_output4), ArrayUtils.toString(s.merge(intervals4)))


                );
    }
}