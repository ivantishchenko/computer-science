import java.util.Enumeration;
import java.util.HashMap;

class Solution {
    public int[] twoSum1(int[] nums, int target) {
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

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(m.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = m.get(target - nums[i]);
                return res;
            }
            m.put(nums[i], i);
        }
        return res;
    }

}