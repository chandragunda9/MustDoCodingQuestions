package arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {3, 0, 0, 2, 0, 4};
        System.out.println(optimal1(arr, arr.length));
        System.out.println(trappingWater(arr, arr.length));
    }

    static long optimal1(int arr[], int n) {
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = arr[0];
        rightMax[n - 1] = arr[n - 1];
        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }
        long trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += (Math.min(leftMax[i], rightMax[i]) - arr[i]);
        }
        return trappedWater;
    }

    static long trappingWater(int arr[], int n) {
        int leftMax = 0, rightMax = 0;
        int l = 0, r = n - 1;
        long trapped = 0;
        while (l <= r) {
            if (arr[l] <= arr[r]) {
                if (arr[l] > leftMax)
                    leftMax = arr[l];
                else
                    trapped += (leftMax - arr[l]);
                l++;
            } else {
                if (arr[r] > rightMax)
                    rightMax = arr[r];
                else
                    trapped += (rightMax - arr[r]);
                r--;
            }
        }
        return trapped;
    }
}
