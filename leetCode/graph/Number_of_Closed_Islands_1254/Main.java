class Solution {
    private boolean[][] visited;

    private boolean isInside(int i, int j, int m, int n) {
        return !(i < 0 || i >= m || j < 0 || j >= n);
    }

    private boolean dfs(int i, int j, int[][] grid) {
        if(!isInside(i, j, grid.length, grid[0].length)) return false;
        if(grid[i][j] == 1) return true;
        // visited
        grid[i][j] = 1;
        return dfs(i + 1, j, grid) & dfs(i - 1, j, grid) & dfs(i, j + 1, grid) & dfs(i, j - 1, grid);
    }

    public int closedIsland(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0 && dfs(i, j, grid)) {
                    res++;
                }
            }
        }
        return res;           
    }
}