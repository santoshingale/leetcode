class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[ n + 1][amount + 1];
        // Arrays.fill(dp[0], 0);
        for(int[] d : dp){
            d[0] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int c = 1; c <= amount; c++){
                if(c >= coins[i - 1])
                    dp[i][c] = dp[i][c - coins[i - 1]] + dp[i - 1][c];
                else
                    dp[i][c] = dp[i - 1][c];
            }
        }
        return dp[n][amount];
        
    }
}