package Amazon;
import java.util.Arrays;
class Solution {
    int[][][] dp;

    public int maxProfit(int k, int[] prices) {
        dp = new int[prices.length][k + 1][2];
        for (int[][] arr2d : dp) {
            for (int[] arr1d : arr2d) {
                Arrays.fill(arr1d, -1);
            }
        }
        return f(prices, 0, k, false);
    }

    public int f(int[] v, int i, int k, boolean on) {
        
        if (i >= v.length || k == 0) return 0;

        if (dp[i][k][on ? 1 : 0] != -1) return dp[i][k][on ? 1 : 0];

        int profit = 0;
        profit = Math.max(profit, f(v, i + 1, k, on));

        if (on) {
            profit = Math.max(profit, v[i] + f(v, i + 1, k - 1, false));
        } else {
            profit = Math.max(profit, f(v, i + 1, k, true) - v[i]);
        }
        return dp[i][k][on ? 1 : 0] = profit;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;
        System.out.println("Max Profit: " + sol.maxProfit(k, prices)); 
    }
}

