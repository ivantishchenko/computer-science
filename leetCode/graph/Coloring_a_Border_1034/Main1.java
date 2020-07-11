class Solution {
    private boolean[][] visited;

    private boolean isInside(int i, int j, int m, int n) {
        return !(i < 0 || i >= m || j < 0 || j >= n);
    }

    public void dfs(int i, int j, int[][] grid, int target, int prev) {
        if(!isInside(i, j, grid.length, grid[0].length) || visited[i][j]) return;
        if(grid[i][j] != prev) return;

        visited[i][j] = true;

        boolean isBorderCell = (
            i == 0 || j == 0 || j == grid[0].length - 1 || i == grid.length - 1 ||
            grid[i + 1][j] != prev ||  
            grid[i - 1][j] != prev || 
            grid[i][j - 1] != prev || 
            grid[i][j + 1] != prev
        );

        dfs(i + 1, j, grid, target, prev);
        dfs(i - 1, j, grid, target, prev);
        dfs(i, j + 1, grid, target, prev);
        dfs(i, j - 1, grid, target, prev);

        if(isBorderCell) grid[i][j] = target;
    }

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        visited = new boolean[grid.length][grid[0].length];
        dfs(r0, c0, grid, color, grid[r0][c0]);
        return grid;
    }
}