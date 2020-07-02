import java.util.Arrays;

class Solution {
    int[][] dp;

    public int getCellPath(int i, int j, int m, int n) {
        if(i == 0 && j == 0) return dp[i][j] = 1;
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        return dp[i][j] = getCellPath(i - 1, j, m, n) + getCellPath(i, j - 1, m, n);
    }

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        return getCellPath(m - 1, n - 1, m, n);
    }

    public int uniquePathsIter(int m, int n) {
        int [][] dp = new int[m][n];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 1);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}