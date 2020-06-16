import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int i : nums) {
            if(numSet.contains(i)) {
                return true;
            }
            numSet.add(i);
        }
        return false;
    }
}