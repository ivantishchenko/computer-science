class Solution {
    public int reverse(int x) {
        int sign = (int) Math.signum(x);
        x = Math.abs(x);
        long res = 0;
        while (x > 0) {
            int digit = x % 10;
            res = res * 10 + digit;
            x /= 10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res * sign;
    }
}