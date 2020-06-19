import java.util.*;

class Solution {
    public int numSquares(int n) {
        if(n == 0) return 0;
        if(Math.sqrt(n) % 1 == 0) return 1;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(0);
        int numEdges = 1;
        int upperBound = (int) Math.sqrt(n);
        while(!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int curr = q.poll();
                if(visited.contains(curr)) continue;
                visited.add(curr);
                for(int j = 1; j <= upperBound; j++) {
                    int next = curr + j * j;
                    if(next < n) q.offer(next);
                    else if(next == n) return numEdges;
                }
            }
            numEdges++;
        }
        return numEdges;
    }
}

public class Main {
    public static void main(String[] args) {
        var s = new Solution();
        s.numSquares(12);
    }
}