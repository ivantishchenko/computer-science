import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] inputArr = {0,0,1,1,1,2,2,3,3,4};
        int size = solution.removeDuplicates(inputArr);
        System.out.println(Arrays.toString(inputArr));
        System.out.println(size);
    }
}
