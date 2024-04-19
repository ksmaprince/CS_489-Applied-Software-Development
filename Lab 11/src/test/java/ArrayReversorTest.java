import edu.miu.cs489.lab11.ArrayFlattenerService;
import edu.miu.cs489.lab11.ArrayReversor;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayReversorTest {

    @Test
    public void testReverseArrayLegitInput() {
        int[][] inputArray = {{1, 3}, {0}, {4, 5, 9}};
        int[] expectedOutput = {9, 5, 4, 0, 3, 1};

        ArrayFlattenerService mockService = new ArrayFlattenerService();
        int[] flattenedArray = mockService.flattenArray(inputArray);

        assertNotNull(flattenedArray);

        int[] actualOutput = ArrayReversor.reverseArray(inputArray);

        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testReverseArrayNullInput() {
        int[][] inputArray = null;
        assertNull(ArrayReversor.reverseArray(inputArray));
    }
}
