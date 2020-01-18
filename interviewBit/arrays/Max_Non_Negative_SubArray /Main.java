class Solution {
    public int[] maxset(int[] A) {
        long localSum = 0;
        long globalSum = 0;
        int begIdx = 0;
        int globalBegIdx = begIdx;
        int endIdx = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                localSum = -1;
                begIdx = i + 1;
                continue;
            } 
            localSum = Math.max(A[i], A[i] + localSum);
            if (localSum > globalSum) {
                globalBegIdx = begIdx;
                endIdx = i;
                globalSum = localSum;
            } else if (globalSum == localSum) {
                if (i - begIdx + 1 > endIdx - globalBegIdx + 1) {
                    globalBegIdx = begIdx;
                    endIdx = i;
                }
            }
        }

        if(globalBegIdx == 0 && A[globalBegIdx] < 0) {
            return new int[0];
        }

        int[] res = new int[endIdx - globalBegIdx + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = A[i + globalBegIdx];
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] A = {756898537, -1973594324, -2038664370, -184803526, 1424268980};
        Solution s = new Solution();
        int res[] = s.maxset(A);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

