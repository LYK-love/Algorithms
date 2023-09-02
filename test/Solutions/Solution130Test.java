package Solutions;

import Utils.WrapperValueComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static Utils.ArrayUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class Solution130Test {

    Solution130 s = new Solution130();
    @Test
    void solve() {
        Character[][] board1 = new Character[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };

        char[][] b1 = convertToCharArray(board1);
        s.solve(b1);

        Character[][] actual1 = convertToCharacterArray(b1);

        Character[][] res1 = new Character[][]{
                {'X','X','X','X'},
                {'X','X','X','X'},
                {'X','X','X','X'},
                {'X','O','X','X'}
        };



        Character[][] board2 = new Character[][]{
                {'X'}
        };
        char[][] b2 = convertToCharArray(board2);

        s.solve(b2);

        Character[][] actual2 = convertToCharacterArray(b2);

        Character[][] res2 = new Character[][]{
                {'X'}
        };

        Character[][] board3 = new Character[][]{
                {'O','X','X','O','X'}, 
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}
        };


        char[][] b3 = convertToCharArray(board3);

        s.solve(b3);

        Character[][] actual3 = convertToCharacterArray(b3);

        Character[][] res3 = new Character[][]{
                {'O','X','X','O','X'},
                {'X','X','X','X','O'},
                {'X','X','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}
        };


        for(char[] line: b3)
            System.out.println(line);


        assertAll(
                ()-> Assertions.assertTrue( equalsFor2D(res1, actual1, new WrapperValueComparator() ) ),
                ()-> Assertions.assertTrue( equalsFor2D(res2, actual2, new WrapperValueComparator() ) ),
                ()-> Assertions.assertTrue( equalsFor2D(res3, actual3, new WrapperValueComparator()) )

        );



        
    }
}