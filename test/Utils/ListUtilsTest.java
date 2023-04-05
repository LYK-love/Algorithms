package Utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListUtilsTest {


    @Test
    void convertToList() {
    }

    @Test
    void testConvertToList() {
    }

    @Test
    void sortByFirstDimension() {
        List<List<Integer>> pair_list = new ArrayList<>();
        pair_list.add(new ArrayList<>(Arrays.asList(8,3)));
        pair_list.add(new ArrayList<>(Arrays.asList(3,1)));
        pair_list.add(new ArrayList<>(Arrays.asList(43,2)));
        pair_list.add(new ArrayList<>(Arrays.asList(4,2)));
        pair_list.add(new ArrayList<>(Arrays.asList(7,4)));

        ListUtils.sortByFirstDimension(pair_list);
        String s1 = String.valueOf(pair_list);


        List<List<Integer>> expected_sorted_pair_list = new ArrayList<>();
        expected_sorted_pair_list.add(new ArrayList<>(Arrays.asList(3,1)));
        expected_sorted_pair_list.add(new ArrayList<>(Arrays.asList(4,2)));
        expected_sorted_pair_list.add(new ArrayList<>(Arrays.asList(7,4)));
        expected_sorted_pair_list.add(new ArrayList<>(Arrays.asList(8,3)));
        expected_sorted_pair_list.add(new ArrayList<>(Arrays.asList(43,2)));

        String expected_s1 = String.valueOf(expected_sorted_pair_list);


        assertEquals(String.valueOf(expected_sorted_pair_list), String.valueOf(pair_list));


    }
}