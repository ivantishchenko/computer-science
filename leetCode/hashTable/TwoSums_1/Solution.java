import java.util.Enumeration;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            // check if complement of a number exists
            int complement = target - nums[i];
            if(indexMap.containsKey(complement) && indexMap.get(complement) != i) {
                res[0] = i;
                res[1] = indexMap.get(complement);
                return res;
            }
        }
        return null;
    }

    public int[] twoSum_i(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(indexMap.containsKey(complement)) {
                return new int[] {i, indexMap.get(complement)};
            }
            indexMap.put(nums[i], i);
        }
        return null;
    }

}