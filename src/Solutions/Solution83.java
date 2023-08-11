package Solutions;

import Utils.ListNode;

class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {

        //[1,1,2,3,3]
        //1,1,1,1,1
        ListNode iter = head;
        while(iter != null && iter.next != null)
        {
            int cur_val = iter.val;
            int next_val = iter.next.val;
            while( cur_val == next_val )
            {
                iter.next = iter.next.next;

                if(iter.next == null)
                    break;
                cur_val = iter.val;
                next_val = iter.next.val;
            }
            iter = iter.next;

        }
        return head;
    }

}
