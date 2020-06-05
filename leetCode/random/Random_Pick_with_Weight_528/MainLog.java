import java.util.Random;

class Solution {
    private Random rand;
    private int[] weights;

    public Solution(int[] w) {
        this.rand = new Random();
        this.weights = w;
        for (int i = 1; i < w.length; i++) {
            this.weights[i] = this.weights[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        int idx = rand.nextInt(this.weights[this.weights.length - 1]) + 1;
        int left = 0;
        int right = this.weights.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (this.weights[mid] == idx) {
                return mid;
            }
            else if(this.weights[mid] < idx) {
                left = mid + 1;
            } else {
               right = mid - 1; 
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */