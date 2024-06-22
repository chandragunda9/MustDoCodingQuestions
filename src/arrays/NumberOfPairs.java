package arrays;

import java.util.Arrays;

public class NumberOfPairs {
    public static void main(String[] args) {
        int[] x = {2, 1, 6};
        int[] y = {1, 5};
        System.out.println(countPairs(x, y, x.length, y.length));
    }

    static long countPairs(int x[], int y[], int M, int N) {
        Arrays.sort(y);
        long totalPairs = 0;
        for (int i = 0; i < M; i++) {
            totalPairs += countXInY(x[i], y);
        }
        return totalPairs;
    }

    static long countXInY(int xe, int[] sortedY) {
        if (xe == 1)
            return 0;
        long totalPairs = sortedY.length - upperBound(sortedY, xe);
        int countY1 = countOccurrences(sortedY, 1);
        totalPairs += countY1;
        if (xe == 2) {
            int countY3 = countOccurrences(sortedY, 3);
            int countY4 = countOccurrences(sortedY, 4);
            totalPairs -= (countY3 + countY4);
        }
        if (xe == 3) {
            int countY2 = countOccurrences(sortedY, 2);
            totalPairs += countY2;
        }
        return totalPairs;
    }

    static int countOccurrences(int[] arr, int val) {
        int lb = lowerBound(arr, val);
        int ub = upperBound(arr, val);
        return ub - lb;
    }

    static int lowerBound(int[] arr, int ele) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= ele) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int upperBound(int[] arr, int ele) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > ele) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
