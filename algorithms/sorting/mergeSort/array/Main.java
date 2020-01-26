// Time: Worst O(n * log n), Best O(n * log n), Average O(n * log n)
// Space: O(N)
class MergeSort {

    private void merge(int[] A, int[] L, int[] R) {
        int i = 0, j = 0, k = 0;
        while (i < L.length && j < R.length) {
            if(L[i] <= R[j]) {
                A[k++] = L[i++];
            }
            else {
                A[k++] = R[j++];
            }
        }
        while(i < L.length) {
            A[k++] = L[i++];
        }
        while (j < R.length) {
            A[k++] = R[j++];
        }
    }

    public void sort(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = arr[i];
        }
        sort(l);
        sort(r);
        merge(arr, l, r);
    }
}

public class Main {

    public static void main(String[] args) {
        int[] arr = {2,4,1,6,8,5,3,7};
        MergeSort s = new MergeSort();
        s.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
