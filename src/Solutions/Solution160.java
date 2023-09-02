package Solutions;

import Utils.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;

        //比较对象的内存地址
        while(p1 != p2)
        {
            //这段代码十分trivial. 当p1, p2没有走到last(即最后一个节点), 则p1, p2在每次迭代中前进一步.
            //而如果p1, p2走到了last, 则不会在当次迭代中前进, 而是变成null, 在下一次迭代时再前进(从last前进到另一条链表的head).
            //这意味着, 如果两条链表不相交(即z=0), 那么在x+y次迭代后, p1=null; 此时p2也经历了y+x次迭代, 因此p2=null. 在下次循环开始前就有p1=p2, 因此循环会退出, 函数返回null.
            if(p1 == null) p1 = headB;
            else    p1 = p1.next;

            if (p2 == null) p2 = headA;
            else    p2 = p2.next;
        }

        return p1;
    }
}
