package Utils;

import Utils.Matrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixTest {

    @Test
    void transpose() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] expected_matrix = {{1,4,7}, {2,5,8}, {3,6,9}};

        Matrix m = new Matrix(matrix);
        Matrix expected_m = new Matrix(expected_matrix);

        m.transpose();

        assertEquals(expected_m.toString(), m.toString() );

    }

    @Test
    void reverse_by_perpendicular() {
        int[][] matrix = {{1,4,7}, {2,5,8}, {3,6,9}};
        int[][] expected_matrix = {{7,4,1},{8,5,2},{9,6,3}};

        Matrix m = new Matrix(matrix);
        Matrix expected_m = new Matrix(expected_matrix);

        m.reverse_by_perpendicular();

        assertEquals(expected_m.toString(), m.toString());

    }

    @Test
    void testToString() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Matrix m = new Matrix(matrix);
        String actual_m = m.toString();
        String expected_m = "1 2 3" + '\n' + "4 5 6" + '\n' + "7 8 9" + '\n';
        assertEquals(expected_m, actual_m );


    }

    @Test
    void get_m() {
    }

    @Test
    void testTranspose() {
    }

    @Test
    void testReverse_by_perpendicular() {
    }


    @Test
    void test_spiral_order() {
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};


        Matrix m1 = new Matrix(matrix1);
        Matrix m2 = new Matrix(matrix2);


        assertAll(
                () -> assertEquals("[1, 2, 3, 6, 9, 8, 7, 4, 5]", m1.spiral_order().toString()),
                () -> assertEquals("[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]", m2.spiral_order().toString())
        );
    }
}