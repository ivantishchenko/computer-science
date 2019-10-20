class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0 ; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if(digits[i] != 0) {
                return digits;
            }
        }
        int[] expandedArray = new int[digits.length + 1];
        expandedArray[0] = 1;
        System.arraycopy(digits, 0, expandedArray, 1, digits.length);
        return expandedArray;
    }
}