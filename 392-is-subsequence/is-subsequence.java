class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n + 1][m + 1];
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[n][m]);
        return n == dp[n][m];
    }
}

// 1 2