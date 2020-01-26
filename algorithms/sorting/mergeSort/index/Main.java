// Time: Worst O(n * log n), Best O(n * log n), Average O(n * log n)
// Space: O(N)
class MergeSort {

    // merge function take two intervals
    // one from start to mid
    // second from mid+1, to end
    // and merge them in sorted order
    private void merge(int arr[], int start, int mid, int end) {
        int[] tmpArr = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                tmpArr[k++] = arr[i++];
            } else {
                tmpArr[k++] = arr[j++];
            }
        }
        while(i <= mid) {
            tmpArr[k++] = arr[i++];
        }
        while(j <= end) {
            tmpArr[k++] = arr[j++];
        }
        for(i = start; i <= end; i++) {
            arr[i] = tmpArr[i - start];
        }
    }

    public void sort(int arr[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        int[] arr = {2,4,1,6,8,5,3,7};
        MergeSort s = new MergeSort();
        s.sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
