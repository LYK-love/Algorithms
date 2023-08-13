package Utils;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    /**
     * using given val sequence to build a linked list
     * @param val_arr
     * @return
     */
    public static ListNode build_linked_list(List<Integer> val_arr) {
        if(val_arr.isEmpty())
            return null;

        ListNode head = new ListNode(val_arr.get(0));
        val_arr.remove(0);
        head.next = build_linked_list(val_arr);
        return head;
    }

    @Override
    public String toString()
    {
        ListNode current = this;
        String res = String.valueOf(current.val);
        current = current.next;

        while(current != null) {
            res += (" " + current.val);
            current = current.next;
        }

        return res;
    }

    public static String toStringLikeList(ListNode head)
    {
        ListNode current = head;

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append(head.val);
        current = current.next;

        while( current != null )
        {
            sb.append(", " + current.val);
            current = current.next;
        }
        sb.append("]");

        return sb.toString();
    }


    /**
     * 输入一个单链表头结点，将该链表反转，返回新的头结点
     * @param head
     * @return the head node after the reverse
     *
     */
    private static ListNode reverse_linked_list(ListNode head)
    {
        if( head == null || head.next == null )
            return head;

        ListNode last = reverse_linked_list(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 反转链表的前 n 个节点
     * @param head
     * @param n
     * @return the head node after the reverse
     */
    public static ListNode reverse_foremost_N_nodes(ListNode head, int n)
    {
        ListNode successor = null; // 后驱节点, 即第n+1个节点

        return _reverse_foremost_N_nodes(head,n,successor).node;

    }

    private static ListNodeSuccessorPair _reverse_foremost_N_nodes(ListNode head, int n, ListNode successor)
    {
        if(n==1)
        {
            successor = head.next;
            return new ListNodeSuccessorPair(head, successor);
        }

        //这样实现是为了在不同的函数调用中保存successor的状态
        ListNodeSuccessorPair pair = _reverse_foremost_N_nodes(head.next, n-1, successor);
        ListNode last = pair.node;
        successor = pair.successor;

        head.next.next = head;
        head.next = successor;
        return new ListNodeSuccessorPair(last, successor);
    }
    private static class ListNodeSuccessorPair{
        ListNode node;
        ListNode successor;
        public ListNodeSuccessorPair(ListNode node, ListNode successor)
        {
            this.node = node;
            this.successor = successor;
        }

    }


    /**
     * 给定一个索引区间 [start, last] (索引从 1 开始), 仅仅反转区间中的链表元素.
     *
     * @param head
     * @param start
     * @param last
     * @return the head node after the reverse
     */
    public static ListNode reverseBetween(ListNode head, int start, int last)
    {
        //相当于反转前 n 个元素
        if(start == 1)
            return reverse_foremost_N_nodes(head,last);

        head.next = reverseBetween(head, start-1,last-1);
        return head;
    }

    public static int get_len(ListNode head)
    {
        int step = 0;
        while( head != null)
        {
            head = head.next;
            step++;
        }
        return step;
    }


}
