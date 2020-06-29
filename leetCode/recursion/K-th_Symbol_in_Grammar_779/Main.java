class Solution {
    public int kthGrammar(int N, int K) {
        if(N == 1 && K == 1) return 0;
        int prevLayerSize = (int) Math.pow(2, N - 2);
        if(K <= prevLayerSize) {
            return kthGrammar(N - 1, K);
        } else {
            return kthGrammar(N - 1, K - prevLayerSize) ^ 1;
        }
    }
}