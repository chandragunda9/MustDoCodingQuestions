package arrays;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr, arr.length));
    }

    static int maxProfit(int[] prices, int n) {
//        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            minPrice = Math.min(minPrice, prices[i]);
//            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
//        }
//        return maxProfit;

        int maxProfit = 0, minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
