class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2; 
            if (nums[mid] > target) {
                high = mid - 1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        var s = new Solution();
        int[] arr = {-1,0,3,5,9,12};
        System.out.println(s.search(arr, 2));
    }
}