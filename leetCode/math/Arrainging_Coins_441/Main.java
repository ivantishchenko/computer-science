class Solution {
    public int arrangeCoins(int n) {
        int left = 0, right = n;
        int k, curr;        
        while(left <= right) {
            k = left + (right - left) / 2;           
            curr = k * (k + 1) / 2;
            if(curr == n) return k;
            if(n < curr) right = k + 1;
            else left = k + 1;
        }
        return left;
    }

    public int arrangeCoinsIter(int n) {
        if(n == 0 || n == 1) return n;
        int num = n;
        int res = -1;
        for (int i = 1; num >= 0; i++) {
            num -= i;
            res++;
        }
        return res;
    }
}