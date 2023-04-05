package Solutions;

import Utils.Matrix;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */
class Solution48 {
    /**
     * 现将矩阵转置, 再将矩阵按中垂线翻转.
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        Matrix m = new Matrix(matrix);
        m.transpose();
        m.reverse_by_perpendicular();
    }

    public Matrix _rotate(int[][] matrix) {
        Matrix m = new Matrix(matrix);
        m.transpose();
        m.reverse_by_perpendicular();
        return m;
    }

    public static void main(String[] args)
    {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println( new Solution48()._rotate(matrix));
    }

}
