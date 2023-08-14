package Structures;

public class Node<T extends Comparable<?>> {
    public Node<T> left, right;
    public T val;

    public Node(T val) {
        this.val = val;
    }
    public Node(T val, Node<T> left, Node<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}