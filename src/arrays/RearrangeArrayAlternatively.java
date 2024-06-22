package arrays;

import java.util.Arrays;

public class RearrangeArrayAlternatively {
    public static void main(String[] args) {
        long[] arr = {1, 2, 3, 4, 5, 6};
//        method1(arr, arr.length);
        rearrange(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(long arr[], int n) {
        long me = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            me = Math.max(me, arr[i]);
        }
        me++;
        int maxi = n - 1, mini = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i] + arr[maxi] % me * me;
                maxi--;
            } else {
                arr[i] = arr[i] + arr[mini] % me * me;
                mini++;
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / me;
        }
    }

    public static void method1(long arr[], int n) {
        long[] ans = new long[n];
        int l = 0, r = n - 1;
        int i = 0;
        while (l < r) {
            ans[i++] = arr[r];
            ans[i++] = arr[l];
            l++;
            r--;
        }
        System.out.println(Arrays.toString(ans));
    }
}
