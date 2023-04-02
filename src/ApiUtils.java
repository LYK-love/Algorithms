import io.vavr.Tuple;
import io.vavr.Tuple2;

public class ApiUtils {

    /**
     * swap value a,b
     * @param a
     * @param b
     * @return
     */
    public static Tuple2<Integer, Integer> swap(int a, int b)
    {
        int tmp = a;
        a = b;
        b = tmp;
        return Tuple.of(a,b);
    }

}
