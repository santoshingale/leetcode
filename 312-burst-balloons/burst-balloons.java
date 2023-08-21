class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len+2];
        int[][] dp = new int[len+2][len+2];
        arr[0] = arr[len+1] = 1;
        for(int i = 1; i <= len; i++){
            arr[i] = nums[i-1];
        }
        for(int i = len; i > 0; i--){
            for(int j = i; j <= len; j++){
                int max = Integer.MIN_VALUE;
                for(int ind = i; ind <= j ; ind++){                    
                    int coins = (arr[i-1] * arr[ind] * arr[j+1]) + dp[i][ind - 1] + dp[ind + 1][j];
                    max = Math.max(max, coins);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][len];
    }
}