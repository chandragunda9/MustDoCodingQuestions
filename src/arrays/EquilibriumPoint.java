package arrays;

public class EquilibriumPoint {
    public static void main(String[] args) {
        long[] arr = {1, 3, 5, 2, 2};
        System.out.println(equilibriumPoint(arr, arr.length));
    }

    public static int equilibriumPoint(long arr[], int n) {
        long rSum = 0;
        for (int i = 0; i < n; i++) {
            rSum += arr[i];
        }
        long lSum = 0;
        for (int i = 0; i < n; i++) {
            rSum -= arr[i];
            if (lSum == rSum)
                return i;
            lSum += arr[i];
        }
        return -1;
    }
}
