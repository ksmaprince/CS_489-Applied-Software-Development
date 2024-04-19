package edu.miu.cs489.lab11;

public class ArrayReversor {
    public static int[] reverseArray(int[][] inputArray) {
        // Flatten the input array using ArrayFlattenerService
        int[] flattenedArray = ArrayFlattenerService.flattenArray(inputArray);

        // Reverse the flattened array
        int n = flattenedArray.length;
        int[] reversedArray = new int[n];
        for (int i = 0; i < n; i++) {
            reversedArray[i] = flattenedArray[n - 1 - i];
        }

        return reversedArray;
    }
}
