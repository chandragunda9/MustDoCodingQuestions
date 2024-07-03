package arrays;

public class LeftSmallerAndRightGreater {
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 7};
        System.out.println(findElement(arr, arr.length));
    }

    public static int findElement(int arr[], int n) {
        int[] leftMax = new int[n], rightMin = new int[n];
        leftMax[0] = arr[0];
        rightMin[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] >= leftMax[i] && arr[i] <= rightMin[i])
                return arr[i];
        }
        return -1;
    }
}
