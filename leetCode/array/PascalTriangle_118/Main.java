import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> layer = new ArrayList<>();
        if(numRows == 0) return triangle;
        layer.add(1);
        triangle.add(layer);
        if(numRows == 1) return triangle;
        List<Integer> prevLayer = layer;
        for (int i = 1; i < numRows; i++) {
            layer = new ArrayList<>();
            layer.add(1);
            for (int j = 1; j < i; j++) {
                int element = prevLayer.get(j - 1) + prevLayer.get(j);
                layer.add(element);
            }
            layer.add(1);
            triangle.add(layer);
            prevLayer = layer;
        }     
        return triangle;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        var triangle = solution.generate(5);
    }
}