class Solution {
    public int islandPerimeter(int[][] grid) {
        int numOfIsland = 0;
        int numOfNeigh = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    numOfIsland++;
                    if(i > 0 && grid[i - 1][j] == 1)
                        numOfNeigh++;
                    if(j > 0 && grid[i][j - 1] == 1)
                        numOfNeigh++;
                }
            }
        }
        return (numOfIsland * 4) - (numOfNeigh * 2);
    }
}