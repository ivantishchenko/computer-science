class Solution {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n % 2 == 0) {
            int res = myPow(x, n / 2);
            return res * res;
        }
        if(n < 0) {
            return 1 / (x * myPow(x, Math.abs(n) -1));
        } else {
            return x * myPow(x, n - 1);
        }
    }
}