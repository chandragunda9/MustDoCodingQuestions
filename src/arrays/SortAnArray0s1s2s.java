package arrays;

import java.util.Arrays;

public class SortAnArray0s1s2s {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 2, 0};
        sort012(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort012(int a[], int n) {
        // By using dutch national flag algorithm
        int l = 0, m = 0, r = n - 1;
        while (m <= r) {
            if (a[m] == 0) {
                swap(a, l, m);
                l++;
                m++;
            } else if (a[m] == 1) {
                m++;
            } else {
                swap(a, m, r);
                r--;
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
