import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] interval = new int[2];
        interval[0] = -1;
        interval[1] = -1;
        if (nums.length == 0) return interval;
        // pointers
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2; 
            if(nums[mid] > target) {
                high = mid; 
            } else if (nums[mid] < target) {
                low = mid;
            } else {
                if(nums[low] != target) {
                    low++;
                }
                if(nums[high] != target) {
                    high--;
                }
                if(nums[low] == target && nums[high] == target) {
                    interval[0] = low;
                    interval[1] = high;
                    return interval;
                }
            }
        }
        // 2 candidates left
        // End Condition: left + 1 == right
        if(nums[low] == target && nums[high] == target) {
            interval[0] = low;
            interval[1] = high;
            return interval;
        } else {
            if(nums[low] == target) {
                interval[0] = low;
                interval[1] = low;
            } 
            if(nums[high] == target) {
                interval[0] = high;
                interval[1] = high;
            }
        }
        return interval;
    }
}

public class Main {
    public static void main(String arrgs[]) {
        var s = new Solution();
        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(s.searchRange(arr,3)));
    }
}