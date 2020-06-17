import java.util.ArrayList;
import java.util.Map;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> m1 = new HashMap<>();
        for(int i = 0; i < list1.length; i++) {
            m1.put(list1[i], i);
        }
        int indexSum = Integer.MAX_VALUE;
        Map<Integer, ArrayList<String>> idxResMap = new HashMap<>();
        for(int i = 0; i < list2.length; i++) {
            if(m1.containsKey(list2[i])) {
                int j = m1.get(list2[i]);
                if(i + j <= indexSum) {
                    indexSum = i + j;
                    String resStr = list2[i];
                    if(!idxResMap.containsKey(indexSum)) {
                        ArrayList<String> initList = new ArrayList<>();
                        initList.add(resStr);
                        idxResMap.put(indexSum, initList);
                    } else {
                        idxResMap.get(indexSum).add(resStr);
                    }
                }
            }
        }
        return idxResMap.get(indexSum).toArray(new String[idxResMap.get(indexSum).size()]);
    }
}