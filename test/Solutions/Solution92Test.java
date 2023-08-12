package Solutions;

import Utils.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Solution92Test {
    Solution92 s = new Solution92();
    @Test
    void reverseBetween() {
        List<Integer> list1 = Stream.of(1,2,3,4,5)
                .collect(Collectors.toList());
        ListNode head1 = ListNode.build_linked_list(list1);

        List<Integer> res1 = Stream.of(1,4,3,2,5)
                .collect(Collectors.toList());
        ListNode res1Head =  ListNode.build_linked_list(res1);


        List<Integer> list2 = Stream.of(3,4)
                .collect(Collectors.toList());
        ListNode head2 = ListNode.build_linked_list(list2);

        List<Integer> res2 = Stream.of(4,3)
                .collect(Collectors.toList());
        ListNode res2Head =  ListNode.build_linked_list(res2);

        assertAll(
                () -> Assertions.assertEquals(ListNode.toStringLikeList(res1Head), ListNode.toStringLikeList(s.reverseBetween(head1,2,4))),
                () -> Assertions.assertEquals(ListNode.toStringLikeList(res2Head), ListNode.toStringLikeList(s.reverseBetween(head2,1,2)))

        );
    }
}