class Solution {
    private final List<Integer[]> directions = List.of(
            new Integer[] {0, 1}, new Integer[] {0, -1},
            new Integer[] {1, 0}, new Integer[] {-1, 0}
    );

    public int longestIncreasingPath(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) 
            for (int j = 0; j < matrix[0].length; j++) 
                max = Math.max(max, slv(i, j, -1, matrix, memo));
        return max;
    }

    private int slv(int i, int j, int prev, int[][] matrix, int[][] memo) {
        if (isInvalid(i, j, matrix) || matrix[i][j] <= prev) return 0;
        if (memo[i][j] != 0) return memo[i][j];
        int max = 1;
        for (Integer[] direction: directions) {
            int x = i + direction[0], y = j + direction[1];
            max = Math.max(max, 1 + slv(x, y, matrix[i][j], matrix, memo));
        }
        return memo[i][j] = max;
    }

    private boolean isInvalid(int i, int j, int[][] matrix) {
        return i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length;
    }
}