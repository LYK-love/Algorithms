import java.util.Arrays;

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

    public static int get_index_of_the_first_occurrence_of_max_element(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return -1;

        int max_val = nums[0];
        int idx_of_max_val = 0;
        for(int i = 1; i < nums.length; i++)
        {
            if( max_val < nums[i])
            {
                max_val = nums[i];
                idx_of_max_val = i;
            }
        }
        return idx_of_max_val;
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int get_index_of_the_last_occurrence_of_max_element(int[] nums)
    {
        int idx_of_the_first_occurrence_of_max_element = get_index_of_the_first_occurrence_of_max_element(nums);
        int p = idx_of_the_first_occurrence_of_max_element;//得到要找到的元素的最左边界, 然后指针不断右移
        while( p + 1 < nums.length && nums[p+1] == nums[p])
            p++;
        return p;
    }
    public static int get_max( int[] nums )
    {
        int max = Arrays.stream(nums).max().getAsInt();
        return max;
    }

    public static int get_min( int[] nums )
    {
        int min = Arrays.stream(nums).min().getAsInt();
        return min;
    }


}
