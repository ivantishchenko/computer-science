import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


// Input:
// [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

// Output:
// [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0]?a[1] - b[1]:b[0] - a[0]);
        List<int[]> resPeople = new ArrayList<>();

        for (int[] p : people) {
            resPeople.add(p[1], p);
        }

        return resPeople.toArray(new int[resPeople.size()][]);
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] a = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        var s = new Solution();
        int[][] res = s.reconstructQueue(a);
        int b = 4;
    }
}