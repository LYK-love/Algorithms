package Utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
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
     *
     * @param a
     * @param a2
     * @param comparator
     * @return
     */
    public static<T>  boolean equalsFor1D(T[] a, T[] a2, Comparator<T> comparator) {
        if (a==a2)
            return true;   //1.如果名字相同，返回true
        if (a==null || a2==null)
            return false;  //2.如果其中一个为空，返回false

        int length = a.length;
        if (a2.length != length)
            return false;  //3.如果两个数组长度不同，返回false

        for (int i=0; i<length; i++)
            if ( comparator.compare(a[i], a2[i]) != 0)
                return false;  //4.每一个元素进行对比，如果有一个不同，返回false

        return true;       //5.走到这一步就说明数组中每个元素都相等，返回true
    }

    public static<T>  boolean equalsFor2D(T[][] a, T[][] a2, Comparator<T> comparator) {
        if (a==a2)
            return true;   //1.如果名字相同，返回true
        if (a==null || a2==null)
            return false;  //2.如果其中一个为空，返回false

        int length = a.length;
        if (a2.length != length)
            return false;  //3.如果两个数组长度不同，返回false

        for (int i=0; i<length; i++)
            if ( !equalsFor1D(a[i], a2[i], comparator))
                return false;

        return true;       //5.走到这一步就说明数组中每个元素都相等，返回true
    }

    /**
     * 将基本数据类型数组转换为包装类型数组。
     * @param array 要转换的基本数据类型数组
     * @param wrapperType 包装类型的 Class 对象
     * @return
     * @param <T>
     */
    public static <T> T[] toWrapperArray(Object array, Class<T> wrapperType) {
        int length = Array.getLength(array);
        T[] result = (T[]) Array.newInstance(wrapperType, length);

        for (int i = 0; i < length; i++) {
            Array.set(result, i, Array.get(array, i));
        }

        return result;
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

    public static Character[][] convertToCharacterArray(char[][] charArray) {
        int rows = charArray.length;
        int cols = charArray[0].length;

        Character[][] characterArray = new Character[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                characterArray[i][j] = charArray[i][j]; // Autoboxing
            }
        }

        return characterArray;
    }

    public static char[][] convertToCharArray(Character[][] characterArray) {
        int rows = characterArray.length;
        int cols = characterArray[0].length;

        char[][] charArray = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                charArray[i][j] = characterArray[i][j]; // Autoboxing
            }
        }

        return charArray;
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

    /**
     * Converse a 2-D array into 1-D. The elements will be inserted by row.
     * E.g, [[1,2][3,4]] -> [1,2,3,4]
     */
    public static int[] flattenArray(int[][] twoDArray)
    {
        // Calculate the total number of elements in the 2D array
        int totalElements = 0;
        for (int[] row : twoDArray) {
            totalElements += row.length;
        }

        // Create a 1D array to hold all elements
        int[] oneDArray = new int[totalElements];

        // Copy elements from the 2D array to the 1D array
        int index = 0;
        for (int[] row : twoDArray) {
            for (int element : row) {
                oneDArray[index] = element;
                index++;
            }
        }

        return oneDArray;
    }

    public static int[] removeDuplicatesFromArray(int[] originalArray)
    {
        // Use a HashSet to store unique elements
        HashSet<Integer> uniqueElements = new HashSet<>();

        // Iterate through the original array and add unique elements to the HashSet
        for (int element : originalArray) {
            uniqueElements.add(element);
        }

        // Create a new array to hold the unique elements
        int[] uniqueArray = new int[uniqueElements.size()];

        // Copy elements from the HashSet to the new array
        int index = 0;
        for (int element : uniqueElements) {
            uniqueArray[index] = element;
            index++;
        }
        return uniqueArray;
    }
}
