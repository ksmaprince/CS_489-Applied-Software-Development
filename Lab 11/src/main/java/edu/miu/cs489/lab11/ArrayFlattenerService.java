package edu.miu.cs489.lab11;

import java.util.ArrayList;
import java.util.List;

public class ArrayFlattenerService {
    public static int[] flattenArray(int[][] inputArray) {
        if (inputArray == null) {
            return null;
        }

        List<Integer> flattenedList = new ArrayList<>();

        for (int[] subArray : inputArray) {
            for (int num : subArray) {
                flattenedList.add(num);
            }
        }

        // Convert List<Integer> to int[]
        int[] flattenedArray = new int[flattenedList.size()];
        for (int i = 0; i < flattenedList.size(); i++) {
            flattenedArray[i] = flattenedList.get(i);
        }

        return flattenedArray;
    }
}
