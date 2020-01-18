class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revert = 0;
        int input = x;
        while (input > 0) {
            revert = revert * 10 + input % 10;
            input /= 10;
        }
        return revert == x;
    }
}