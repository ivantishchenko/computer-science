// 	Best: O(n) Average: O(n^2)  Worst: O(n^2)
public class Main {
    public static void main(String []args) {
        int array[] = {2,7,4,1,5,3};
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            Boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j]= array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
        for (int i = 0; i < n; i++) System.out.println(array[i]);
    }
  }