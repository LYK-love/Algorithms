package Utils;

import Utils.Matrix;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @Test
    void test_initialize_by_nums_in_spiral_order() {

        int n1 = 3;
        int n2 = 4;

        Matrix m1 = new Matrix(n1,n1); //n * n integer matrix
        int nums_len1 = n1 * n1;
        List<Integer> list1 = IntStream.range(1, nums_len1 + 1)
                .boxed()
                .collect(Collectors.toList());

        m1.initialize_by_nums_in_spiral_order(list1);
        String res_m1 = "" +
                "1 2 3\n" +
                "8 9 4\n" +
                "7 6 5\n";

        Matrix m2 = new Matrix(n2,n2); //n * n integer matrix
        int nums_len2 = n2 * n2;
        List<Integer> list2 = IntStream.range(1, nums_len2 + 1)
                .boxed()
                .collect(Collectors.toList());

        m2.initialize_by_nums_in_spiral_order(list2);
        String res_m2 = "" +
                "1 2 3 4\n" +
                "12 13 14 5\n" +
                "11 16 15 6\n" +
                "10 9 8 7\n";

        assertAll(
                () -> assertEquals(res_m1, m1.toString()),
                () -> assertEquals(res_m2, m2.toString())
        );

    }
}