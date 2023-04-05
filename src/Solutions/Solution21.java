package Solutions;

import Utils.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution21 {
    /**
     * 双指针
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;

        ListNode dummy = new ListNode(-1);
        ListNode p3 = dummy;//dummy head

        while( p1!= null && p2!= null )
        {
            if(p2.val >= p1.val)
            {
                p3.next = new ListNode(p1.val);
                p3 = p3.next;
                p1 = p1.next;
            }
            else
            {
                p3.next = new ListNode(p2.val);
                p3 = p3.next;

                p2 = p2.next;
            }
        }

        if( p1 != null )
            p3.next = p1;
        else
            p3.next = p2;

        return dummy.next;
    }
}
