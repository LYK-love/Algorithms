## Trapping Rain Water

对于柱子下标$i$, 下雨后能接的水等于:

1. 先将左右两边柱子高度最大值的最小值减去柱子$i$的高度. 
2. 结果为非负则返回.
3. 如果结果为负, 说明$i$比两边所有柱子都高, 因此$i$也接不了雨水, 结果为0.

即:

```java
water_bar_array[i] = min_between_lmax_and_rmax > height[i] ? min_between_lmax_and_rmax - height[i] : 0;
```



我们可以使用dp, 计算柱子$i$的左右两边柱子高度的最大值的最小值.

可以使用双指针来进一步提高速度:

[Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/submissions/912486410/)的[双指针解法](https://labuladong.github.io/algo/di-san-zha-24031/jing-dian--a94a0/ru-he-gao--0d5eb/):

用两个指针`l_max` 和 `r_max` 代表`height[0..left]` 和 `height[right..end]` 的最高柱子高度.

则有:

```java
int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int l_max = 0, r_max = 0;

    int res = 0;
    while (left < right) {
        l_max = Math.max(l_max, height[left]);
        r_max = Math.max(r_max, height[right]);

        // res += min(l_max, r_max) - height[i]
        if (l_max < r_max) {
            res += l_max - height[left];
            left++;
        } else {
            res += r_max - height[right];
            right--;
        }
    }
    return res;
}

```



假设left.leftmax < right.rightmax, 那么双指针算法就是要对left赋值, 也就相当于令i = left.





我们看到, i的leftmax就是left的leftmax, 但i的rightmax却未必就是right的rightmax, 因为left和right之间还有可能有更高的柱子j.



但这不重要了, 因为即使有更高的柱子H[j] > right.rightmax, 我们其实只关心 min( i.leftmax, i. rightmax), 

而right.rightmax是i右侧的某个值, 

在已知

i.leftmax < right.rightmax, 即i.leftmax <i右侧的某个值之后, i.leftmax是必定小于i.rightmax的.



因此只需要取i.leftmax.

> 此时的 `l_max` 是 `left` 指针左边的最高柱子，但是 `r_max` 并不一定是 `left` 指针右边最高的柱子，这真的可以得到正确答案吗？
>
> 其实这个问题要这么思考，我们只在乎 `min(l_max, r_max)`。**对于上图的情况，我们已经知道 `l_max < r_max` 了，至于这个 `r_max` 是不是右边最大的，不重要。重要的是 `height[i]` 能够装的水只和较低的 `l_max` 之差有关**

