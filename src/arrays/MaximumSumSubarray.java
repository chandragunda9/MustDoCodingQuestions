package arrays;

public class MaximumSumSubarray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};
        System.out.println(method1(arr, arr.length));
        System.out.println(maxSubarraySum(arr, arr.length));
    }

    static long maxSubarraySum(int[] arr, int n) {
        //By using kadane's algorithm
        long sum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    static long maxCrossingSum(int[] arr, int l, int m, int r) {
        long sum = 0;
        long maxLeftSum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum += arr[i];
            maxLeftSum = Math.max(maxLeftSum, sum);
        }

        sum = 0;
        long maxRightSum = Integer.MIN_VALUE;
        for (int i = m; i <= r; i++) {
            sum += arr[i];
            maxRightSum = Math.max(maxRightSum, sum);
        }
        return Math.max(maxLeftSum + maxRightSum - arr[m], Math.max(maxLeftSum, maxRightSum));
    }

    static long divideAndConquer(int[] arr, int l, int r) {
        if (l == r)
            return arr[l];
        if (l < r) {
            int m = (l + r) / 2;
            long leftSum = divideAndConquer(arr, l, m);
            long rightSum = divideAndConquer(arr, m + 1, r);
            long crossSum = maxCrossingSum(arr, l, m, r);
            return Math.max(crossSum, Math.max(leftSum, rightSum));
        }
        return Integer.MIN_VALUE;
    }

    static long method1(int[] arr, int n) {
        //By using divide and conquer
        int l = 0, r = n - 1;
        return divideAndConquer(arr, l, r);
    }
}
