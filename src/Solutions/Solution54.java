package Solutions;

import Utils.Matrix;

import java.util.List;

class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        Matrix m = new Matrix(matrix);
        List<Integer> res = m.spiral_order();
        return res;

    }

    public static void main(String[] args)
    {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> res = new Solution54().spiralOrder(matrix);
        System.out.println(res);
    }
}