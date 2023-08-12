package Solutions;

import Utils.ListNode;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution92 {
    /**
     * 1 2 3 4 5
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode nodeBeforeHead = new ListNode(0,head), nodeLast = new ListNode(0,head), nodeAfterLast = head;


        for( int i=1; i<= right; i++)
        {

            if( i < left )
                nodeBeforeHead = nodeBeforeHead.next;

            if( i <= right )
            {
                nodeLast = nodeLast.next;
                nodeAfterLast = nodeAfterLast.next;
            }
        }
        nodeLast.next = null;

        ListNode headForReverse = nodeBeforeHead.next;

//        System.out.println("Before reverse: " + headForReverse);

        ListNode headAfterReverse = reverse(headForReverse);

//        System.out.println("After reverse: " + headAfterReverse);

        nodeBeforeHead.next = headAfterReverse;
        headForReverse.next = nodeAfterLast;

        //如果head也在区间内，则head现在指向的是翻转后部分list的末尾， 因此需要充值head
        if( left == 1 )
            head = nodeBeforeHead.next;

        return head;
    }

    ListNode reverse(ListNode head)
    {
        if(head == null || head.next == null)
            return head;

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}