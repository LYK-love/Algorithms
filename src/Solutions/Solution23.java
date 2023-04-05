package Solutions;

import Utils.ListNode;

import java.util.*;

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
class Solution23 {
    /**
     * 使用优先队列
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        int list_num = lists.length;

        //The PriorityQueue's constructor needs the initial capacity > 1, so must check list_num == 0 at first
        if(list_num == 0)
            return null;

        PriorityQueue<ListNode> node_queue = new PriorityQueue<>(list_num, (p1, p2) -> (p1.val- p2.val) );

        for( ListNode head: lists )
        {
            if(head != null)
                node_queue.add(head);
        }

        while(!node_queue.isEmpty())
        {
            ListNode node_with_min_val = node_queue.poll();

            p.next = new ListNode(node_with_min_val.val);
            p = p.next;

            if( node_with_min_val.next != null )
            {
                node_queue.add(node_with_min_val.next);
            }
        }

        return dummy.next;
    }

    /**
     * 一大堆没用的工具函数
     * @param p_arr
     * @return
     */
    private boolean none_null(ListNode[] p_arr)
    {
        for( ListNode p_i: p_arr )
        {
            if( p_i == null )
                return false;
        }
        return true;
    }

    /**
     * 一大堆没用的工具类
     * @param p_arr
     * @return
     */
    private List<VAL_IDX_PAIR> get_val_arr(ListNode[] p_arr)
    {
        int list_num = p_arr.length;

        List<VAL_IDX_PAIR> val_idx_arr = new ArrayList<>();

        for( int i = 0; i < list_num; i++ )
        {
            VAL_IDX_PAIR item = new VAL_IDX_PAIR(p_arr[i].val, i);
            val_idx_arr.add(item);
        }
        return val_idx_arr;
    }

}

class VAL_IDX_PAIR
{
    int val;
    int idx;
    public VAL_IDX_PAIR(int val, int idx)
    {
        this.val = val;
        this.idx = idx;
    }
}
class My_val_idx_comparator implements Comparator<VAL_IDX_PAIR>
{
    @Override
    public int compare(VAL_IDX_PAIR op1, VAL_IDX_PAIR op2)
    {
        return op1.val - op2.val;
    }
}