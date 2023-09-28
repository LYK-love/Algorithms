package Solutions;

import Utils.ListNode;

public class Solution206 {

    /**
     * Given the head of a singly linked list, reverse the list, and return the head of the reversed list.
     * @return     */
    public ListNode reverseList(ListNode head) {

        /**
         * head == null: 输入的linked list本身就为空.
         * head.next == null: head is the last node of the list.
         */
        if(head == null || head.next == null)
            return head;
        ListNode last = reverseList(head.next);// reverse the sub-list, whose head will be returned.
        head.next.next = head;
        head.next = null;
        return last;
    }
}
