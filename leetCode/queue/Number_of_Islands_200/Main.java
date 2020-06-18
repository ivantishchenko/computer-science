import java.util.Queue;

class Solution {

    private int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    private boolean isInside(int i, int j, int m, int n) {
        return !(i >= m || j >= n || j < 0 || i < 0);
    }

    private void bfs(int i, int j, char[][] grid, boolean[][] visited) {
        Queue<int[]> cellQueue = new LinkedList<>();
        cellQueue.offer(new int[]{i, j});

        while(!cellQueue.isEmpty()) {
            int[] c = cellQueue.poll();
            visited[c[0]][c[1]] = true;
            for (int[] move : moves) {
                int x = c[0] + move[0];
                int y = c[1] + move[1];
                if(isInside(x, y, grid.length, grid[0].length) && 
                    grid[x][y] == '1' &&
                    !visited[x][y]) {
                    cellQueue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if(i >= grid.length || j >= grid[0].length || j < 0 || i < 0) {
            return;
        }
        if(visited[i][j]) return;
        if(grid[i][j] == '0') {
            visited[i][j] = true;
            return;
        }
        visited[i][j] = true;
        dfs(i - 1, j, grid, visited);
        dfs(i + 1, j, grid, visited);
        dfs(i, j + 1, grid, visited);
        dfs(i, j - 1, grid, visited);
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    // start BFS
                    bfs(i, j, grid, visited);
                    numIslands++;
                    // increment a counter
                }
            }
        }
        return numIslands;
    }
}

public class Main {
    public static void main(String[] args) {
        
    }
}