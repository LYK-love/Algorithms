package Utils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListUtils {

    /**
     * convert a 1-D array to 1-D list
     * @param arr
     * @return
     */
    public static List<Integer> convertToList(int[] arr)
    {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return list;
    }

    /**
     * convert a 2-D array to 2-D list
     * @param arr
     * @return
     */
    public static List<List<Integer>> convertToList(int[][] arr)
    {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++)
            list.add(convertToList(arr[i]));
        return list;
    }

    /**
     * Sort a 2-D list by the value at the First Dimension in ascending order
     *
     * @param pair_list
     * @return
     */
    public static void sortByFirstDimension(List<List<Integer>> pair_list)
    {

        Collections.sort(pair_list, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int left = o1.get(0); //the value at the First Dimension
                int right = o2.get(0);
                if( left == right ) return 0;
                else return left > right? 1: -1; //从小到大
            }
        });
    }

    /**
     * Get the string representation of the List with the same format in Java Standard.
     * Note the null element will be represented as "null".
     * e.g.:
     * [1,null,2,null,3] -> "[1,null,2,null,3]"
     * [[1,null,2,null,3],[1,null,3,2],[2,1,3]] -> "[[1,null,2,null,3],[1,null,3,2],[2,1,3]]"
     * @param list
     * @param toStringFunc
     * @return
     * @param <T>
     */
    public static<T> String toStringAsFormat(List<T> list, Function<T, String> toStringFunc)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0 ; i < list.size(); i++)
        {
            T element = list.get(i);

            if(element == null)
                sb.append("null");
            else
                sb.append(toStringFunc.apply(element));

            if(i!= list.size()-1)
                sb.append(", ");
        }
        sb.append("]");
        String res = sb.toString();
        return res;
    }
}
