import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    int[] arr = {0,1,2,2,3,0,4,2};
	    int res = solution.removeElement(arr, 2);
	    System.out.println(res);
	    System.out.println(Arrays.toString(arr));
    }
}
