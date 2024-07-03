package dynamic_programming;

import java.util.Arrays;

public class BuyAndSellStockII {
    public static void main(String[] args) {
//        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        int[] prices = {4, 2, 2, 2, 4};
        System.out.println(stockBuySell(prices, prices.length));
    }

    static Integer stockBuySell(int[] prices, int n) {
        int[][] dp = new int[n][2];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 1, prices, dp);
    }

    static int f(int ind, int canBuy, int[] prices, int[][] dp) {
        if (ind == prices.length) return 0;
        if (dp[ind][canBuy] != -1) return dp[ind][canBuy];
        int profit;
        if (canBuy == 1) {
            //buy case
            profit = -prices[ind] + f(ind + 1, 0, prices, dp);
            //not buy case
            profit = Math.max(profit, 0 + f(ind + 1, 1, prices, dp));
        } else {
            //sell case
            profit = prices[ind] + f(ind + 1, 1, prices, dp);
            //not sell case
            profit = Math.max(profit, 0 + f(ind + 1, 0, prices, dp));
        }
        return dp[ind][canBuy] = profit;
    }
}
