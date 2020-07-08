class Solution {
    private boolean[][] visited;

    private boolean isInside(int i, int j, int m, int n) {
        return !(i < 0 || i >= m || j < 0 || j >= n);
    }

    private int dfs(int i, int j, int[][] grid) {
        if(!isInside(i, j, grid.length, grid[0].length) || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        if(grid[i][j] == 0) return 0;
        
        return 1 + dfs(i - 1, j, grid) + dfs(i + 1, j, grid) + dfs(i, j + 1, grid) + dfs(i, j - 1, grid);
    }

    public int maxAreaOfIsland(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }
        return maxArea;    
    }
}