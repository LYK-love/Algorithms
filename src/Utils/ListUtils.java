package Utils;

import java.util.*;
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
}
