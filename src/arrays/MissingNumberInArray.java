package arrays;

public class MissingNumberInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        int n = 5;
        System.out.println(missingNumber(n, arr));
    }

    static int missingNumber(int n, int arr[]) {
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        for (int i = 0; i < n - 1; i++) {
            xor ^= arr[i];
        }
        return xor;
    }
}
