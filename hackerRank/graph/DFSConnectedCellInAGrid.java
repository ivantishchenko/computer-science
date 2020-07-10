package main;

import lib.io.InputReader;
import lib.io.OutputWriter;

public class DFSConnectedCellInAGrid {
    private int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(dfs(i, j, grid), res);
            }
        }
        out.print(res);
    }

    private boolean isInside(int i, int j, int m, int n) {
        return !(i < 0 || i >= m || j < 0 || j >= n);
    }

    private int dfs(int i, int j, int[][] grid) {
        if(!isInside(i, j, grid.length, grid[0].length)) {
            return 0;
        }
        if(grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int cellSum = 1;
        for (int[] m: moves) {
            cellSum += dfs(i + m[0], j + m[1], grid);
        }
        return cellSum;
    }
}
