package arrays;

public class LowerBound {
    public static void main(String[] args) {
        int[] arr = {4, 6, 10, 12, 18, 18, 20, 20, 30, 45};
        int key = 44;
        System.out.println(lowerBound(arr, key));
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
}
