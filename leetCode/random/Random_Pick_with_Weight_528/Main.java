import java.util.Random;

class Solution {
    private int totalWeight;
    private Random rand;
    private int[] weights;

    public Solution(int[] w) {
        this.weights = w;
        this.totalWeight = 0;
        for (int i: w) {
            this.totalWeight += i;
        }
        rand = new Random();
    }
    
    public int pickIndex() {
        int position = rand.nextInt(this.totalWeight);
        for (int i = 0; i < this.weights.length; i++) {
            if(this.weights[i] > position) {
                return i;
            }
            position -= this.weights[i];
        }
        return null;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */