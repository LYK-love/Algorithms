package Utils;

import java.util.Arrays;
import java.util.List;

public class ArrayUtils {

    /**
     * Deep copy 2-dimension array, the src and dest array must be M * N arrays
     * @param src
     * @param srcPos
     * @param dest
     * @param destPos
     * @param M lines
     * @param N cols
     */
    public static void matrix_deep_copy(char[][] src, int  srcPos,
                                        char[][] dest, int destPos,
                                        int M, int N)
    {
        for( int k = 0; k < M; k++)
            System.arraycopy(src[k],0, dest[k],0, N);
    }


    /**
     * Deep copy a M*N sub-matrix(2-dimension array) from src to dest.
     * @param src the source matrix.
     * @param src_line_pos starting line position in the source matrix.
     * @param src_element_pos starting col position in the source matrix.
     * @param dest the destination matrix.
     * @param dest_line_pos starting line position in the destination data.
     * @param dest_element_pos starting col position in the destination data.
     * @param M the number of lines to be copied.
     * @param N the number of cols to be copied.
     */
    public static void matrix_deep_copy(int[][] src, int src_line_pos, int  src_element_pos,
                                        int[][] dest, int dest_line_pos, int dest_element_pos,
                                        int M, int N)
    {
        for( int k = src_line_pos, q = dest_line_pos ; k < src_line_pos + M; k++, q++ )
            System.arraycopy(src[k],src_element_pos, dest[q],dest_element_pos, N);
    }

    public static int[] mapToIntArray(List<Integer> list)
    {
        int[] primitive = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return primitive;
    }

    public static int[][] mapToIntArray_2D(List<List<Integer>> two_dimension_list)
    {
        int M = two_dimension_list.size();
        int N = two_dimension_list.get(0).size();

        int[][] res = new int[M][N];

        for(int i = 0; i < M; i++)
        {
            res[i] = mapToIntArray(two_dimension_list.get(i));
        }

        return res;
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
     * compare two 1-d arrays
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

    /**
     * Get the String representation of 2-D array. The result is the same as the String representation of its List<> version,
     * E.g:
     * 1. {{1,6},{8,10},{15,18}} -> "[[1, 6], [8, 10], [15, 18]]"
     * 2. {{1, 5}} -> "[[1, 5]]"
     * 3. {{}} -> "[[]]"
     * @param arr
     * @return
     */
    public static String toString(int[][] arr)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        if(arr.length == 0)
        {
            sb.append("[]");
        }
        else
        {
            for (int i = 0; i < arr.length; i++)
            {
                sb.append("[");
                for (int j = 0; j < arr[i].length; j++) {
                    sb.append(arr[i][j]);

                    if( j != arr[i].length - 1)
                        sb.append(", ");
                }
                sb.append("]");
                if(i != arr.length - 1)
                {
                    sb.append(", ");
                }
            }
            sb.append("]");
        }

        return sb.toString();
    }

    /**
     * Sort a 2-D array by the value at the First Dimension
     * @param arr
     * @return
     */
    public static void sortByFirstDimension(int[][] arr)
    {
        List<List<Integer>> pair_list = ListUtils.convertToList(arr);
        ListUtils.sortByFirstDimension(pair_list);
        int[][] res_arr = mapToIntArray_2D(pair_list);
        matrix_deep_copy(res_arr,0,0,arr,0,0, arr.length, arr[0].length);
    }
}
