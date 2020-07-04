import java.util.Queue;
import java.util.Stack;

class Solution {
    int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    boolean isInside(int i, int j, int m, int n) {
        return !(i >= m || j >= n || j < 0 || i < 0);
    }

    public void dfs_recur(int[][] image, int sr, int sc, int newColor, int prevColor) {
        if(!isInside(sr, sc, image.length, image[0].length)) return;
        if(image[sr][sc] == newColor || image[sr][sc] != prevColor) return;

        image[sr][sc] = newColor;
        dfs_recur(image, sr + 1, sc, newColor, prevColor);
        dfs_recur(image, sr - 1, sc, newColor, prevColor);
        dfs_recur(image, sr, sc + 1, newColor, prevColor);
        dfs_recur(image, sr, sc - 1, newColor, prevColor);
    }

    public void dfs_iter(int[][] image, int sr, int sc, int newColor, int prevColor) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{sr, sc});
        while(!stack.isEmpty()) {
            int[] cell = stack.pop();
            sr = cell[0];
            sc = cell[1];

            if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) continue;
            if(image[sr][sc] == newColor || image[sr][sc] != prevColor) continue;
            
            image[sr][sc] = newColor;
            for (int[] move: moves) stack.push(new int[]{sr + move[0], sc + move[1]});
        }
    }

    public void bfs(int[][] image, int sr, int sc, int newColor, int prevColor) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            sr = cell[0];
            sc = cell[1];
            image[sr][sc] = newColor;
            for (int[] move: moves) {
                int nextX = sr + move[0];
                int nextY = sc + move[1];
                if(isInside(nextX, nextY, image.length, image[0].length) 
                    && image[nextX][nextY] != newColor 
                    && image[nextX][nextY] == prevColor) {
                        q.offer(new int[]{nextX, nextY});
                }
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        bfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
}