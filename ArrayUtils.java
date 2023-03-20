public class ArrayUtils {

    /**
     * Deep copy 2-dimension array, the src and dest array must be M * N arrays
     * @param src
     * @param srcPos
     * @param dest
     * @param destPos
     * @param M
     * @param N
     */
    public static void two_dimensions_array_deep_copy(char[][] src,  int  srcPos,
                                  char[][] dest, int destPos,
                                  int M, int N)
    {
        for( int k = 0; k < M; k++)
            System.arraycopy(src[k],0, dest[k],0, N);
    }

}
