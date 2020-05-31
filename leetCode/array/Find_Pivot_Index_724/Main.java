import java.util.Arrays;

class Solution {
    public int pivotIndexN(int[] nums) {
        if (nums.length == 0) return -1;
        int[] sumsArr = new int[nums.length + 1];
        Arrays.fill(sumsArr, 0);
        for(int i = 0; i < nums.length; i++) {
            sumsArr[i + 1] = sumsArr[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int left = sumsArr[i - 1];
            int right = sumsArr[sumsArr.length - 1] - left - nums[i];
            if(left == right) {
                return i;
            }
        }
        return -1;
    }

    public int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;
        int sum = 0;
        int left = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int right = sum - left - nums[i];
            if(left == right) return i;
            left += nums[i];
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {-1,-1,-1,-1,0,1};
        int res = s.pivotIndex(a);
        System.out.println(res);
    }
}