class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList();
        for(int i = 0; i < n; i++){
            for(int j =0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        if(fresh == 0) return 0;
        int min = 0;
        
        int[] move = {-1, 0, 1, 0, -1};
         
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] fo = q.poll();
                for(int j = 0; j < 4; j++){
                    int r = fo[0] + move[j];
                    int c = fo[1] + move[j + 1];
                    if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1)
                    {
                        q.add(new int[]{r, c});
                        grid[r][c] = 2;
                        fresh--;
                    }
                }
            }
            min++;
        }
        return fresh == 0 ? min - 1 : -1;
    }
}