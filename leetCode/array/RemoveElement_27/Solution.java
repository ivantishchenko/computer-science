class Solution {
    public int removeElement(int[] nums, int val) {
        // -1 means the pivot has not been intitialized
        int j = -1;
        for (int i = nums.length - 1; i >= 0 ; --i) {
            if (j == -1 && nums[i] != val) {
                j = i;
            }
            if(j != -1 && nums[i] == val) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j--;
            }
        }
        return j + 1;
    }

    public int removeElement_i(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int removeElement_ii(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

}