class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement = 0;
        for (int i = 0; i < 32; i++) {
            int radixOneCount = 0;
            for (int number : nums) {
                radixOneCount += (number >> i) & 1;
            }
            if (radixOneCount > nums.length / 2) {
                majorityElement |= (1 << i);
            }
        }
        return majorityElement;
    }
}

public class Main {
    public static void main(String[] args) {
        var s = new Solution();
        int[] arr = {3,2,-1,-1,-1};
        System.out.println(s.majorityElement(arr));
    }
}