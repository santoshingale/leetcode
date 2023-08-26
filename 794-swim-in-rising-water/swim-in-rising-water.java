class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int l=grid[0][0];
        int r=n*n-1;
        while(l<r)
        {
            int m= l+(r-l)/2;
            boolean v[][]=new boolean[n][n];
            if(dfs(grid,0,0,v,m)==true)
                r=m;
            else l=m+1;
        }
        return l;
    }
    public boolean dfs(int g[][],int r, int c, boolean v[][],int t)
    {
        int n=g.length;
        if(r<0 || r>=n || c<0 || c>=n || v[r][c]==true || g[r][c]>t) return false;
        v[r][c]=true;
        if(r==n-1 && c==n-1) return true;
        if(dfs(g,r-1,c,v,t) || dfs(g,r+1,c,v,t) || dfs(g,r,c-1,v,t) || dfs(g,r,c+1,v,t))return true;
        else return false;
    }
}