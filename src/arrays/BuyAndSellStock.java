package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(stockBuySell(arr, arr.length));
    }

    static ArrayList<ArrayList<Integer>> stockBuySell(int[] A, int n) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                ans.add(new ArrayList<Integer>(Arrays.asList(i - 1, i)));
            }
        }
        return ans;
    }
}
