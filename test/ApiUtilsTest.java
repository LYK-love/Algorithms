import io.vavr.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiUtilsTest {
    ApiUtils apiUtils = new ApiUtils();

    @Test
    @DisplayName("swap two values")
    void swap()
    {
        assertEquals(new Tuple2<Integer,Integer>(3,1), ApiUtils.swap(1,3));
    }

}

