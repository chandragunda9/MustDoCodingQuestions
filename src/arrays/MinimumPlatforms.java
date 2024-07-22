package arrays;

import java.util.Arrays;

public class MinimumPlatforms {
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(method1(arr, dep, arr.length));
        System.out.println(method2(arr, dep, arr.length));
        System.out.println(findPlatform(arr, dep, arr.length));
    }

    static int method2(int arr[], int dep[], int n) {
        int[] time = new int[2360];
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= dep[i]; j++) {
                time[j]++;
            }
        }
        int minPlatforms = 1;
        for (int i = 0; i < 2360; i++) {
            minPlatforms = Math.max(minPlatforms, time[i]);
        }
        return minPlatforms;
    }

    static int method1(int arr[], int dep[], int n) {
        int maxCount = 1;
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (arr[i] >= arr[j] && dep[j] >= arr[i]) count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int count = 0, maxCount = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
