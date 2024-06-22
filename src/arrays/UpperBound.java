package arrays;

public class UpperBound {
    public static void main(String[] args) {
        int[] arr = {4, 6, 10, 12, 18, 18, 20, 20, 30, 45};
        int key = 50;
        System.out.println(upperBound(arr, key));
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
