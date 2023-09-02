package Utils;

import java.util.Comparator;

public class WrapperValueComparator<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        // 检查对象是否为空
        if (o1 == null && o2 == null) {
            return 0; // 两者都为空，认为它们相等
        } else if (o1 == null) {
            return -1; // o1为空，o2不为空，认为o1小于o2
        } else if (o2 == null) {
            return 1; // o2为空，o1不为空，认为o1大于o2
        }

        // 使用对象的value属性进行比较
        //https://chat.openai.com/c/e686765c-b0dc-4fd8-ada1-6592dedd193f
        return o1.compareTo(o2);
    }
}

