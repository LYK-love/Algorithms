package Solutions;

public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;

        int sum = 0;
        for( int i = 0; i < N; i++ )
            sum += gas[i] - cost[i];
        if(sum < 0) // 总油量小于总的消耗，无解
            return -1;

        int start = 0;
        int tank = 0;
        for( int i = 0; i < N; i++ )
        {
            tank += gas[i] - cost[i];
            if(tank < 0)
            {
                //
                // 所以可能的起点应该是 i + 1
                start = i+1;
                tank=0;

                if( start == N-1 )
                    start = 0; //无法从 start 走到 N-1, 下一个可能的起点是N. 由于路线是循环的, 站点N也就是站点0.
            }
        }
        return start;
    }
}
