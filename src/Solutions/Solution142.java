package Solutions;

import Utils.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {

        ListNode current = head;

        //以引用所对应的java对象的hashcode作为key.
        Map<ListNode, Boolean> visited = new HashMap<>();

        while(current!=null)
        {
            current.hashCode();
            Boolean isVisited = ( visited.get(current) == null || visited.get(current) == false )? false: true;

            if( isVisited == true )
            {
                return current;
            }
            visited.put( current, true );
            current = current.next;
            if(current == null)//代表该链表无环, 返回null
                return null;
        }

        return null;//这一句永远无法被执行到.
    }

    private boolean hasCycle(ListNode head) {
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
