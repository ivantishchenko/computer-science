class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int pivot;
        while (l < r) {
            pivot = (l + r) / 2;
            if (target > nums[pivot]) {
                l = pivot + 1;
            }
            else if(target < nums[pivot]) {
                r = pivot - 1;
            }
            else {
                return pivot;
            }
        }
        // MEMORIZE THIS
        return target > nums[l]? l + 1: l;
    }
}