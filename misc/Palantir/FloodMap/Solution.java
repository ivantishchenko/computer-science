import java.util.*;

import static java.util.Map.Entry.comparingByValue;

public class Solution {
    private static int[][] memo;
    private static int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private static int sinkMarker;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dim = scan.nextInt();
        int[][] map = new int[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                map[i][j] = scan.nextInt();
            }
        }
        memo = new int[dim][dim];

        printBasins(map);
        scan.close();
    }

    private static int bfs(int i, int j, int[][] map) {
        Queue<int[]> cellQueue = new LinkedList<>();
        cellQueue.offer(new int[]{i, j});
        while(!cellQueue.isEmpty()) {
            int[] cell = cellQueue.poll();
            int x = cell[0];
            int y = cell[1];

            if(memo[x][y] != 0) return memo[x][y];
            if(isSink(x, y, map)) {
                sinkMarker++;
                memo[x][y] = sinkMarker;
                cellQueue.offer(new int[]{x, y});
            }

            // min flow
            int minX = cell[0];
            int minY = cell[1];
            int min = map[minX][minY];
            for (int[] move: moves) {
                int nextX = cell[0] + move[0];
                int nextY = cell[1] + move[1];
                if(isInside(nextX, nextY, map.length, map[0].length) && map[nextX][nextY] < min) {
                    min = map[nextX][nextY];
                    minX = nextX;
                    minY = nextY;
                }
            }
            cellQueue.offer(new int[]{minX, minY});
        }
        return -1;
    }

    private static int dfs(int i, int j, int[][] map) {
        if(memo[i][j] != 0) return memo[i][j];
        if(isSink(i, j, map)) {
            sinkMarker++;
            memo[i][j] = sinkMarker;
            return memo[i][j];
        }
        // min flow
        int minX = i;
        int minY = j;
        int min = map[i][j];
        for (int[] move: moves) {
            int nextX = i + move[0];
            int nextY = j + move[1];
            if(isInside(nextX, nextY, map.length, map[0].length) && map[nextX][nextY] < min) {
                min = map[nextX][nextY];
                minX = nextX;
                minY = nextY;
            }
        }
        return dfs(minX, minY, map);
    }

    private static void printBasins(int[][] map) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int sinkKey = bfs(i, j, map);
                // update counters
                if(countMap.containsKey(sinkKey)) countMap.put(sinkKey, countMap.get(sinkKey) + 1);
                else countMap.put(sinkKey, 1);
            }
        }
        // sort vals in rev
        countMap.entrySet().stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .map(Map.Entry::getValue)
                .forEach(b -> System.out.print(b + " "));
    }

    private static boolean isSink(int i, int j, int[][] map) {
        int m = map.length;
        int n = map[0].length;

        for (int[] move: moves) {
            int nextX = i + move[0];
            int nextY = j + move[1];
            if(isInside(nextX, nextY, m, n) && map[i][j] > map[nextX][nextY]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isInside(int i, int j, int m, int n) {
        return !(i >= m || j >= n || j < 0 || i < 0);
    }

}
