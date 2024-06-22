package arrays;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutUsingExtraSpace {
    public static void main(String[] args) {
        long[] arr1 = {1, 3, 5, 7};
        long[] arr2 = {0, 2, 6, 8, 9};
//        merge(arr1, arr2, arr1.length, arr2.length);
        optimal2(arr1, arr2, arr1.length, arr2.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void merge(long arr1[], long arr2[], int n, int m) {
        int left = n - 1, right = 0;
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                long t = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = t;
            }
            left--;
            right++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void optimal2(long arr1[], long arr2[], int n, int m) {
        //By using gap method
        int len = n + m;
        int gap = len / 2 + len % 2;
        while (gap > 0) {
            int left = 0, right = left + gap;
            while (right < len) {
                //if one is in arr1 and other is in arr2
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                //if both are in arr1
                else if (right < n) {
                    swapIfGreater(arr1, arr1, left, right);
                }
                //if both are in arr2
                else {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                left++;
                right++;
            }
            if (gap == 1)
                break;
            gap = gap / 2 + gap % 2;
        }
    }

    static void swapIfGreater(long[] arr1, long[] arr2, int i, int j) {
        if (arr1[i] > arr2[j]) {
            long t = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = t;
        }
    }
}
