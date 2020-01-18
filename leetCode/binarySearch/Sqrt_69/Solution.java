class Solution {
    public int mySqrtCheck(int x) {
        return (int) Math.sqrt(x);
    }

    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        long square;
        int mid, l = 2, r = x / 2;
        while (l <= r) {
            mid = l + (r - l) / 2;
            square = (long) mid * mid;
            if(square > x) {
                r = mid - 1;
            }
            else if(square < x) {
                 l = mid + 1;
            }
            else {
                return mid;
            }
        }
        return r;
    }
}