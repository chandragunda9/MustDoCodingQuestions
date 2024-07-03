package arrays;

import java.util.Arrays;

public class ArrayToZigZagFashion {
    public static void main(String[] args) {
        int[] arr = {4, 3, 7, 8, 6, 2, 1};
        zigZag(arr.length, arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void zigZag(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0 && arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            } else if (i % 2 != 0 && arr[i] < arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
