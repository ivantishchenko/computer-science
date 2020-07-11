class Solution {
    private int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private boolean[][] visited;
    private boolean[][] isBorder;

    private boolean isInside(int i, int j, int m, int n) {
        return !(i < 0 || i >= m || j < 0 || j >= n);
    }

    public void colorCell(int i, int j, int[][] grid) {
        if(visited[i][j]) return;
        visited[i][j] = true;
        int m = grid.length;
        int n = grid[0].length;
        for (int[] mov : moves) {
            int nextX = i + mov[0];
            int nextY = j + mov[1];
            // if cell is a boader
            if(!isInside(nextX, nextY, m, n) || grid[nextX][nextY] != grid[i][j]) {
                isBorder[i][j] = true;
            } else {
                colorCell(nextX, nextY, grid);
            }
        }
    }

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        visited = new boolean[grid.length][grid[0].length];
        isBorder = new boolean[grid.length][grid[0].length];
        colorCell(r0, c0, grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(isBorder[i][j]) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
}