class Solution {
    public void dfs(int[][] image, int sr, int sc, int newColor, int prevColor) {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        if(image[sr][sc] == newColor || image[sr][sc] != prevColor) return;

        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, newColor, prevColor);
        dfs(image, sr - 1, sc, newColor, prevColor);
        dfs(image, sr, sc + 1, newColor, prevColor);
        dfs(image, sr, sc - 1, newColor, prevColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
}