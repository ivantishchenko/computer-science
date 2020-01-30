// Time: Worst O(n ^ 2), Best O(n * log n), Average O(n * log n)
// Space: Best O(log n), Average O(log n), Worse O(n)
import java.util.*; 

class QuickSort {

    private int randomizedPartition(int arr[], int start, int end) {
        Random rand= new Random(); 
        // select [start, end]
        int randomIndex = rand.nextInt(end - start) + start;
        int tmp = arr[end];
        arr[end] = arr[randomIndex];
        arr[randomIndex] = tmp;
        return partition(arr, start, end);
    }

    private int partition(int arr[], int start, int end) {
        int pIndex = start;
        int pivot = arr[end];
        for (int i = start; i < end; i++) {
            if(arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
        int temp = arr[end];
        arr[end] = arr[pIndex];
        arr[pIndex] = temp;
        return pIndex;
    }

    public void sort(int[] arr, int start, int end) {
        if(start < end) {
            int pIndex = randomizedPartition(arr, start, end);
            sort(arr, start, pIndex - 1);
            sort(arr, pIndex + 1, end);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        int[] arr = {2,4,1,6,8,5,3,7};
        QuickSort s = new QuickSort();
        s.sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
