package Solutions;

import Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

class Solution56 {

    /**
     * 思路是用指针idx_end指向下一个要比较的interval.
     *
     * 每次循环末尾都idx_end++
     * 如果idx_end指向的interval和当前interval是分离的, 那么就把当前interval放入结果集合中. 再令idx_end指向的interval为当前interval.
     * 如果idx_end指向的interval和当前interval可以合并, 则进行合并.
     * 对于最后一次循环, 即当前interval已经到了数组末尾, idx_end == intervals.length, 此时要将当前interval放入结果集合中.
     *
     * 当然, 如果intervals只有一个元素, 即只有一个interval, 那么就不需要用idx_end指针了(用了会越界), 直接将当前interval放入结果集合中返回即可.
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        ArrayUtils.sortByFirstDimension(intervals);
        List<List<Integer>> merge_res = new ArrayList<>();

        List<Integer> interval = new ArrayList<>();

        int N = intervals.length;


        int start =intervals[0][0];
        int end = intervals[0][1];


        if( N == 1 )//intervals只有一个元素
        {
            interval.add(start);
            interval.add(end);
            merge_res.add(interval);
            interval = new ArrayList<>();
        }

        else//用指针idx_end指向下一个要比较的interval.
        {
            int next_start, next_end;
            int idx_start = 0;
            int idx_end = 1;

            while(idx_end <= N-1)
            {
                next_start = intervals[idx_end][0];
                next_end = intervals[idx_end][1];

                if(end >= next_start) //idx_end指向的interval和当前interval可以合并
                {
                    idx_end++;

                    //合并. 注意: 存在当前interval = [1,4], next interval = [2,3]的情况. 因此当前的end要和next interval的end相比较, 取较大的值.
                    if(end <= next_end)
                        end = next_end;

                }
                else//idx_end指向的interval和当前interval是分离的
                {
                    //把当前interval放入结果集合中. 再令idx_end指向的interval为当前interval.

                    interval.add(start);
                    interval.add(end);
                    merge_res.add(interval);
                    interval = new ArrayList<>();

                    start = next_start;
                    end = next_end;

                    idx_start = idx_end;
                    idx_end++;
                }

                //最后一次循环, 此时需要把当前interval收入结果集合中
                if( idx_end == N )
                {
                    interval.add(start);
                    interval.add(end);
                    merge_res.add(interval);
                    interval = new ArrayList<>();
                    break;
                }
            }
        }
        return ArrayUtils.mapToIntArray_2D(merge_res);
    }


}