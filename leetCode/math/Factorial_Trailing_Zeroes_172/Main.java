// https://www.youtube.com/watch?v=wdz_KouqHx4
// http://mathforum.org/library/drmath/sets/select/dm_factorial_list.html

class Solution {
    public int trailingZeroes(int n) {
        if (n < 5) return 0;
        int zeroCount = 0;
        while (n != 0) {
            n /= 5;
            zeroCount += n; 
        }
        return zeroCount;
    }
}

public class Main {
    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.trailingZeroes(19));
    }
}