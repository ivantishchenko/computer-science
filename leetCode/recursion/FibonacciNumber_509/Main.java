import java.util.HashMap;

class Solution {

    private static HashMap<Integer, Integer> memo = new HashMap<>();

    public int fib(int N) {
        if (N < 2) {
            return N;
        }

        if(!memo.containsKey(N)) {
            memo.put(N, fib(N - 1) + fib(N - 2));
        }

        return memo.get(N);
    }
}