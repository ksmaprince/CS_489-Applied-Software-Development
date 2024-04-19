import edu.miu.cs489.lab11.ArrayFlattener;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class ArrayFlattenerTest {
    @Test
    public void testFlattenArrayLegitInput() {
        int[][] inputArray = {{1, 3}, {0}, {4, 5, 9}};
        int[] expectedOutput = {1, 3, 0, 4, 5, 9};
        assertArrayEquals(expectedOutput, ArrayFlattener.flattenArray(inputArray));
    }

    @Test
    public void testFlattenArrayNullInput() {
        int[][] inputArray = null;
        assertNull(ArrayFlattener.flattenArray(inputArray));
    }
}
