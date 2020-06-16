import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> sumSet = new HashSet<>();
        while(true) {
            int squareSum = 0; 
            while(n > 0) {
                int digit = n % 10;
                squareSum += digit * digit;
                n /= 10;
            }
            if(squareSum == 1) return true;
            if(sumSet.contains(squareSum)) return false;

            sumSet.add(squareSum);
            n = squareSum;
        }
    }
}