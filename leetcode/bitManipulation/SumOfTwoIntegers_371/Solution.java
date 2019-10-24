class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carryFlag = a & b;
            a = a ^ b;
            b = carryFlag << 1;
        }
        return a;
    }
}