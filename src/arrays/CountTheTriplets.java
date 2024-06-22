package arrays;

import java.util.Arrays;

public class CountTheTriplets {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2};
        System.out.println(countTriplet(arr, arr.length));
        int[] arr1 = {1, 5, 3, 2};
        System.out.println(method1(arr1, arr1.length));
    }

    static int countTriplet(int arr[], int n) {
        Arrays.sort(arr);
        int count = 0;
        if (n <= 2)
            return 0;
        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (arr[i] + arr[j] == arr[k]) {
                    count++;
                    i++;
                    j--;
                } else if (arr[i] + arr[j] > arr[k]) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }

    static int method1(int[] arr, int n) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] == arr[k] ||
                            arr[i] + arr[k] == arr[j] || arr[j] + arr[k] == arr[i]) {
                        ans += 1;
                    }
                }
            }
        }
        return ans;
    }
}
