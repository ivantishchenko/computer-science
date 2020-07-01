class Solution {
    int [][] memo;

    public int cellCost(int i, int j, int[][] grid) {
        if(i == 0 && j == 0) return grid[i][j];
        if(i < 0 || j < 0) return Integer.MAX_VALUE;
        if(memo[i][j] != 0) return memo[i][j];

        memo[i][j] = grid[i][j] + Math.min(cellCost(i - 1, j, grid), cellCost(i, j - 1, grid));
        return memo[i][j];
    }

    public int minPathSumRecursion(int[][] grid) {
        memo = new int[grid.length][grid[0].length];
        return cellCost(grid.length - 1, grid[0].length - 1, grid);
    }


    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j] , dp[i][j - 1]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}