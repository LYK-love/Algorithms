package Solutions;


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


class Solution116 {
    public Node connect(Node root) {
        horizontalPopulate(root, null);
        return root;
    }

    /**
     *
     * @param node 以node为根节点的树.
     * @param rightBrother node的右兄弟(可能为位于不同子树), 可能为null.
     * 给定node和node的右兄弟, 设定node的next为rightBrother. 并给node的两个children设置好其右兄弟, 对children递归.
     *
     */
    private void horizontalPopulate(Node node, Node rightBrother)
    {
        if(node == null)
            return;

        node.next = rightBrother;

        //对于node.left, 它的右兄弟就是node.right
        horizontalPopulate(node.left, node.right);

        //对于node.right, 其右兄弟就是node的右兄弟的左child. 如果rightBrother==null

        if(rightBrother == null) //如果node的右兄弟为null, 则后者不可能有左child了.
            horizontalPopulate(node.right, null);
        else
            horizontalPopulate(node.right, rightBrother.left);
    }
}
