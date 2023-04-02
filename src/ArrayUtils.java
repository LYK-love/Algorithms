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

    /**
     * Create an array copy of nums, this copy removes the first occurrence of the specified element from this array.
     * @param nums
     * @param element
     * @return
     */
    public static int[] remove(int[] nums, int element)
    {
        int[] new_arr = new int[nums.length-1];
        for(int i = 0, j = 0; i < new_arr.length; j++)
        {
            if(nums[j] == element)
            {
                continue;
            }

            new_arr[i] = nums[j];
            i++;
        }
        return new_arr;
    }

    /**
     * Create an array copy of nums, this copy removes the element of  given index
     * @param nums
     * @param index
     * @return
     */
    public static int[] remove_with_index(int[] nums, int index)
    {
        int[] new_arr = new int[nums.length-1];
        for(int i = 0, j = 0; i < new_arr.length; j++)
        {
            if(j == index)
            {
                continue;
            }

            new_arr[i] = nums[j];
            i++;
        }
        return new_arr;
    }

    /**
     * Create an array copy of nums, this copy inserts the specified element at the specified position in this list.
     * @param nums
     * @param index
     * @param element
     * @return
     */
    public static int[] add(int[] nums, int index, int element)
    {
        int origin_len = nums.length;
        int[] new_arr = new int[origin_len+1];
        for(int i = 0, j=0; i < new_arr.length; i++)
        {
            if( i == index )
            {
                new_arr[i] = element;
                continue;
            }

            new_arr[i] = nums[j];
            j++;
        }
        return new_arr;
    }

    /**
     * compare two 2-d arrays
     * @param a
     * @param a2
     * @return
     */
    public static boolean equals(int[] a, int[] a2) {
        if (a==a2)
            return true;   //1.如果名字相同，返回true
        if (a==null || a2==null)
            return false;  //2.如果其中一个为空，返回false

        int length = a.length;
        if (a2.length != length)
            return false;  //3.如果两个数组长度不同，返回false

        for (int i=0; i<length; i++)
            if (a[i] != a2[i])
                return false;  //4.每一个元素进行对比，如果有一个不同，返回false

        return true;       //5.走到这一步就说明数组中每个元素都相等，返回true
    }

}
