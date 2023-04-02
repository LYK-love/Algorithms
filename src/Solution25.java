import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {

        int len = get_len(head);

        int cnt = 1;
        while( k*cnt <= len )
        {
            int start = k*(cnt-1) + 1;
            int last = k*cnt;
            head = ListNode.reverseBetween(head,start, last);
            cnt++;
        }
        return head;
    }


    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    /**
     * 给一个索引区间 [m, n]（索引从 1 开始），仅仅反转区间中的链表元素。
     * @param head
     * @param m
     * @param n
     * @return
     */
    ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    int get_len(ListNode head)
    {
        int step = 0;
        while( head != null)
        {
            head = head.next;
            step++;
        }
        return step;
    }

    public static void main(String[] args)
    {
        List<Integer> para = new ArrayList<>(Arrays.asList(1,9,4));
//        List<Integer> para_copy = new ArrayList<>(para.size());
//        System.arraycopy(para,0,para_copy,0,para.size());
        ListNode head = ListNode.build_linked_list(para);
        int k = 2;


        Solution25 solution25 = new Solution25();
        ListNode res_head = solution25.reverseKGroup(head, k);
        System.out.println(res_head);



    }


}