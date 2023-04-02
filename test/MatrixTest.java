import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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
        assertEquals(actual_m, expected_m);


    }
}