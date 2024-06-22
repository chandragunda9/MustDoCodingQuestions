package arrays;

import java.util.ArrayList;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println(leaders(arr.length, arr));
    }

    static ArrayList<Integer> leaders(int n, int arr[]) {
        int rightMax = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= rightMax) {
                rightMax = arr[i];
                ans.add(0, arr[i]);
            }
        }
        return ans;
    }
}
