// prevent overlow on high+low
// int mid = low + (high - low) / 2 
class BinarySearch {
    // Time O(log n)
    // Space O(1)
    public int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if(arr[mid] < x) {
                low = mid + 1; 
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // Time O(log n)
    // Space O(n)
    public int binarySearchRecursive(int[] arr, int x, int low, int high) {
        if(low > high) return -1; 
        int mid = (low + high) / 2;
        if(arr[mid] < x) {
            return binarySearchRecursive(arr, x, mid + 1, high);
        } else if (arr[mid] > x) {
            return binarySearchRecursive(arr, x, low, mid - 1);
        } else {
            return mid;
        }
    }   
}

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10,11};
        var bs = new BinarySearch();
        System.out.println(bs.binarySearchRecursive(arr, 8, 0, arr.length - 1));
    }
}