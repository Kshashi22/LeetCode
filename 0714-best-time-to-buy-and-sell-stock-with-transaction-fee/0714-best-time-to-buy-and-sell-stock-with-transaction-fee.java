class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for(int i=0;i<n;i++) Arrays.fill(dp[i], -1);

        return helper(0, 1, prices, fee, dp);
    }

    private int helper(int idx, int canBuy, int[] prices, int fee, int[][] dp){
        if(idx >= prices.length) return 0;

        if(dp[idx][canBuy] != -1) return dp[idx][canBuy];

        int profit = 0;

        if(canBuy == 1){
            profit = Math.max(-prices[idx] + helper(idx+1, 0, prices, fee, dp), 0 + helper(idx+1, 1, prices, fee, dp));
        }
        else{
            profit = Math.max(prices[idx] + helper(idx+1, 1, prices, fee, dp) - fee, 0 + helper(idx+1, 0, prices, fee, dp));
        }

        return dp[idx][canBuy] = profit;
    }
}