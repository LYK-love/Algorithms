package Utils;

/**
 * 在图的遍历过程中,节点会经历三种状态:
 * 白色: 节点尚未被遍历到.
 *
 * 灰色: 节点已经被遍历到, 但对于它的遍历尚未结束.
 *
 * 黑色: 节点自身的遍历已经结束.
 */
public enum Color {
    WHITE,
    GREY,
    BLACK
}