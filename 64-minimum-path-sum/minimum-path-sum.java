// class Solution {
//     int dp[][];
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         dp = new int[m + 1][n + 1];
//         for(int[] row : dp)
//             Arrays.fill(row, -1);

//         return helper(0, 0, m, n, grid);
//     }
    
//     public int helper(int r, int c, int m, int n, int[][] grid){
//         if(r == m || c == n)
//             return Integer.MAX_VALUE;
//         if(r == m - 1 && c == n - 1) 
//             return grid[r][c];
//         if(dp[r][c] != -1) return dp[r][c];
//         return dp[r][c] = grid[r][c] + Math.min(helper(r + 1, c, m, n, grid), helper(r, c + 1, m, n, grid));
//     }
// }


class Solution {
    public int minPathSum(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length; 

        int[][] dp=new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],-1); 
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int one=Integer.MAX_VALUE; 
                int two=Integer.MAX_VALUE;
                if(i==0 && j==0){
                    dp[0][0]=grid[0][0];
                    continue; 
                }
                if(i>0) one=dp[i-1][j]+grid[i][j];
                if(j>0) two=dp[i][j-1]+grid[i][j];

                dp[i][j]=Math.min(one,two);
            }
        }

        return dp[m-1][n-1];

    }
}