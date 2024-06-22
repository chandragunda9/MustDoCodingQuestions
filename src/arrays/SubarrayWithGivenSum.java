package arrays;

import java.util.ArrayList;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        int sum = 12;
        System.out.println(method1(arr, arr.length, sum));
        System.out.println(subarraySum(arr, arr.length, sum));
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        //By using sliding window technique
        ArrayList<Integer> ans = new ArrayList<>();
        int l = 0, r = 0;
        int sum = 0;
        while (r < n) {
            sum += arr[r];
            while (sum > s && l < r) {
                sum -= arr[l];
                l++;
            }
            if (sum == s) {
                ans.add(l + 1);
                ans.add(r + 1);
                return ans;
            }
            r++;
        }
        ans.add(-1);
        return ans;
    }

    static ArrayList<Integer> method1(int[] arr, int n, int s) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == s) {
                    ans.add(i + 1);
                    ans.add(j + 1);
                    return ans;
                }
            }
        }
        ans.add(-1);
        return ans;
    }
}
