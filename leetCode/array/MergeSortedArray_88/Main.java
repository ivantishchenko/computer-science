import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; 
        int j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            if(i < 0) {
                nums1[k] = nums2[j--];
            } else if(j < 0) {
                nums1[k] = nums1[i--];
            } else {
                if(nums1[i] > nums2[j]) {
                    nums1[k] = nums1[i--];
                }
                else {
                    nums1[k] = nums2[j--];
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {4,0,0,0,0,0};
        int[] b = {1,2,3,5,6};
        s.merge(a, 1, b, 5);
        System.out.println(Arrays.toString(a));
    }
}