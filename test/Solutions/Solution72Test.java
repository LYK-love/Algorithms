package Solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution72Test {
    Solution72 s = new Solution72();

    @Test
    void minDistance() {
        String word1_a = "horse", word2_a = "ros";
        int expected_min_distance_a = 3;
        int actual_min_distance_a = s.minDistance(word1_a,word2_a);

        String word1_b = "intention", word2_b = "execution";
        int expected_min_distance_b = 5;
        int actual_min_distance_b = s.minDistance(word1_b,word2_b);


        assertAll(
                () -> Assertions.assertEquals(expected_min_distance_a, actual_min_distance_a),
                () -> Assertions.assertEquals(expected_min_distance_b, actual_min_distance_b)
        );
    }
}