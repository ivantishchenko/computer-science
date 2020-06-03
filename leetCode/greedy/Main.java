import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(x -> x[0] - x[1]));

        int cost = 0;
        for (int i = 0; i < costs.length; i++) {
            if(i < costs.length / 2) cost += costs[i][0];
            else cost += costs[i][1];
        }

        return cost;
    }
}

public class Main {

    public static void main(String[] args) {
        var s = new Solution();
        int[][] costs = {
            {10, 20},
            {30, 200},
            {400, 50},
            {30, 20}
        };
        s.twoCitySchedCost(costs);

    }

}