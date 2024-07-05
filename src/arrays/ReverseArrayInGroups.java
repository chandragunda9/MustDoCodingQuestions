package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseArrayInGroups {
    static void reverse(int[] arr, int n, int k) {
        if (k == 1)
            return;
        for (int i = 0; i < n; i += k) {
            int start = i;
            int end = Math.min(n - 1, i + k - 1);
            while (start < end) {
                int t = arr[start];
                arr[start] = arr[end];
                arr[end] = t;
                start++;
                end--;
            }
        }
    }

    void reverseInGroups(ArrayList<Long> arr, int k) {
        if (k == 1)
            return;
        int n = arr.size();
        for (int i = 0; i < n; i += k) {
            int start = i;
            int end = Math.min(n - 1, i + k - 1);
            while (start < end) {
                Long t = arr.get(start);
                arr.set(start, arr.get(end));
                arr.set(end, t);
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 5;
        reverse(arr, arr.length, k);
        System.out.println(Arrays.toString(arr));
    }
}
