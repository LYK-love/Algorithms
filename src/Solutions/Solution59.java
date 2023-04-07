package Solutions;

import Utils.Matrix;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 */
class Solution59 {
    public int[][] generateMatrix(int n) {
        Matrix m = new Matrix(n,n); //n * n integer matrix
        int nums_len = n * n;
        List<Integer> list = IntStream.range(1, nums_len + 1)
                .boxed()
                .collect(Collectors.toList());

        m.initialize_by_nums_in_spiral_order(list);
        return m.get_m();
    }

    public Matrix _generateMatrix(int n) {
        Matrix m = new Matrix(n,n); //n * n integer matrix
        int nums_len = n * n;
        List<Integer> list = IntStream.range(1, nums_len + 1)
                .boxed()
                .collect(Collectors.toList());

        m.initialize_by_nums_in_spiral_order(list);
        return m;
    }


}