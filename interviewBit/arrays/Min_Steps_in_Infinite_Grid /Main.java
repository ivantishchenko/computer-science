class Solution {
    public int coverPoints(int[] A, int[] B) {
        int count = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int xDistance = Math.abs(A[i + 1] - A[i]);
            int yDistance = Math.abs(B[i + 1] - B[i]);
            count += Math.max(xDistance, yDistance);
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] A = {0 ,1 ,1};
        int[] B = {0, 1, 2};
        Solution s = new Solution();
        System.out.println(s.coverPoints(A, B));
    }
}

