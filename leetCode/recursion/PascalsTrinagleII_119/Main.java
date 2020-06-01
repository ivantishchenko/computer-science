import java.util.ArrayList;
import java.util.List;

class Solution {

    private int computeCell(int i, int j, int[][] memo) {
        // base case
        if(i == j || j == 0) {
            return 1;
        }

        if (memo[i][j] == 0) {
            memo[i][j] = computeCell(i - 1, j, memo) + computeCell(i - 1, j - 1, memo);
        }

        return memo[i][j];
    }

    public List<Integer> getRow(int rowIndex) {
        // base case
        List<Integer> res = new ArrayList<>();

        int[][] memo = new int[rowIndex + 1][rowIndex + 1];
        
        for (int i = 0; i < rowIndex + 1; i++) {
            res.add(computeCell(rowIndex, i, memo));
        }
        
        return res;
    }
}