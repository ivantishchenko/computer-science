import java.util.HashSet;

class Solution {
    public int singleNumberSpaceN(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!numSet.contains(nums[i])) {
                numSet.add(nums[i]);
            }
            else {
                numSet.remove(nums[i]);
            }
        }
        return numSet.iterator().next();
    }
    public int singleNumber(int[] nums) {
        int checker = 0;
        for (int i = 0; i < nums.length; i++) {
            checker ^= nums[i];
        }
        return checker;
    }
}

public class Main {
    public static void main(String[] args) {
        var s = new Solution();
        int[] arr = {4,1,2,1,2};
        System.out.println(s.singleNumber(arr));
    }
}