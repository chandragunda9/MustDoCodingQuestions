package arrays;

public class CountOfInversions {
    public static void main(String[] args) {
        long[] arr = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr, arr.length));
    }

    static long inversionCount(long arr[], int n) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    static long merge(long[] arr, int l, int mid, int r) {
        long count = 0;
        int m = mid - l + 1, n = r - mid;
        long[] lhalf = new long[mid - l + 1], rhalf = new long[r - mid];
        for (int i = 0; i < m; i++) {
            lhalf[i] = arr[l + i];
        }
        for (int i = 0; i < n; i++) {
            rhalf[i] = arr[mid + 1 + i];
        }
        int k = l, i = 0, j = 0;
        while (i < m && j < n) {
            if (lhalf[i] <= rhalf[j]) {
                arr[k++] = lhalf[i++];
            } else {
                arr[k++] = rhalf[j++];
                count += (m - i);
            }
        }
        while (i < m) {
            arr[k++] = lhalf[i++];
        }
        while (j < n) {
            arr[k++] = rhalf[j++];
        }
        return count;
    }

    static long mergeSort(long[] arr, int l, int r) {
        long count = 0;
        if (l < r) {
            int mid = (l + r) / 2;
            count += mergeSort(arr, l, mid);
            count += mergeSort(arr, mid + 1, r);
            count += merge(arr, l, mid, r);
        }
        return count;
    }
}
