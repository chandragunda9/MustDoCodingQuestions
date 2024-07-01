package arrays;

public class KthSmallestElement {
    public static void main(String[] args) {
        int k = 4;
        int[] arr = {7, 10, 4, 20, 15};
        System.out.println(kthSmallest(arr, 0, arr.length - 1, k));
    }

    static int partition(int[] arr, int low, int high) {
        int i = low, j = high;
        while (i < j) {
            while (arr[i] <= arr[low] && i < high) {
                i++;
            }
            while (arr[j] > arr[low] && j > low) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int kthSmallest(int[] arr, int l, int r, int k) {
        int pi = partition(arr, l, r);
        if (pi + 1 == k)
            return arr[pi];
        else if (k > pi + 1) {
            return kthSmallest(arr, pi + 1, r, k);
        } else
            return kthSmallest(arr, l, pi - 1, k);
    }
}
