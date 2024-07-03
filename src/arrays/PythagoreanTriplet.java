package arrays;

import java.util.Arrays;

public class PythagoreanTriplet {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 6, 5};
        System.out.println(checkTriplet(arr, arr.length));
        System.out.println(method1(arr, arr.length));
    }

    static boolean method1(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] * arr[i];
        }
        Arrays.sort(arr);
        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (arr[i] + arr[j] == arr[k]) {
                    return true;
                } else if (arr[i] + arr[j] > arr[k]) {
                    j--;
                } else
                    i++;
            }
        }
        return false;
    }

    static boolean checkTriplet(int[] arr, int n) {
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, arr[i]);
        }
        int[] has = new int[maxValue + 1];
        Arrays.fill(has, 0);
        for (int i = 0; i < n; i++) {
            has[arr[i]]++;
        }

        for (int i = 1; i <= maxValue; i++) {
            if (has[i] == 0)
                continue;
            for (int j = 1; j <= maxValue; j++) {
                if (has[j] == 0 || (i == j && has[i] == 1))
                    continue;

                int c = (int) Math.sqrt(i * i + j * j);
                if (c * c != i * i + j * j)
                    continue;

                if (c > maxValue)
                    continue;

                if (has[c] >= 1)
                    return true;
            }
        }
        return false;
    }
}
