/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Note that the `n` here  actually starts from 1. That is, the end node is the last ONE node from the end node itself.
 * So this 'n'  actually equals `k+1` in findNthNodeFromEnd.
 */
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //统一符号, 这里的k即findKthNodeFromEnd的k, 一个节点和本身的距离为k=0 (或者说n=1)
        //题目要删除倒数第n个节点， 这是将一个节点和本身的距离看作n=1了.
        // 如果使用k, 那题目就转换成了要删除倒数第k-1个节点
        int k = n - 1;


        //创建一个dummy节点, 使其作为新的head节点, 这是为了避免空指针.
        //考虑不使用dummy节点的情况:
        //假设linked list = [1], k = 0 (n=1). 我们要删除倒数第0个节点, 则要找到倒数第1个节点, 即findKthNodeFromEnd(head, 1)
        //fast指针会先走1步, 使得fast == null, 接着会进行while(fast.next != null)的判断, 但此时fast == null, 没有next方法, 因此会抛出空指针异常
        //采用dummy后, 我们调用的是findKthNodeFromEnd(dummy, 1). 按照上述步骤, fast先走1步, 使得fast == head(原来的head节点), 接着进行判断时就不会产生空指针异常

        ListNode dummy = new ListNode(0, head );


        //为了删除倒数第k个节点, 我们要找到倒数第k+1个节点
        ListNode x = findKthNodeFromEnd(dummy, k+1);
        x.next = x.next.next;

        //不能return head. 如果linked list = [1], k = 0, 则实际上会删除head节点, 在linked list中删除一个节点是通过使其无法被前面的node.next访问所实现的
        //因此会有dummy.next == head.next == null. 但是, 如果返回了head, 则无疑使得head节点又能被访问了. 因此应该返回dummy.next
        return dummy.next;
    }

    /**
     * get Kth node from the end node of the linked list
     * Note that if List is [1,4,2], then the end node is 2, and if K = 0, then we get the end node.
     * If K = 1, then we get the 1th node from the end node, which is 4.
     * @param head
     * @param k
     * @return
     */
    private ListNode findKthNodeFromEnd(ListNode head, int k)
    {
        ListNode fast = head;
        ListNode slow = head;

        for(int i =0; i < k; i++ )
        {
            fast = fast.next;
        }

        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

