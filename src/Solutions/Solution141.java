package Solutions;

import Utils.ListNode;

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while( fast!=null && fast.next !=null)// 快指针走到末尾时停止
        {
            // 快指针走两步, 慢指针走一步
            fast = fast.next.next;
            slow = slow.next;

            // 快慢指针相遇, 说明含有环
            if(fast == slow)
                return true;
        }
        return false;
    }
}
