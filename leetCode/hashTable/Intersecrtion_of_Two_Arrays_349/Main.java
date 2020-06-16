import java.util.List;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> s2 = new HashSet<Integer>();
        for (int i : nums1) {
            s1.add(i);
        }
        for (int i : nums2) {
            s2.add(i);
        }
        for (Integer num : s1) {
            if(s2.contains(num)) {
                res.add(num);
            }
        }
        int size = res.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}