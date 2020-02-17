// prevent overlow on high+low
// int mid = low + (high - low) / 2 
class BinarySearch {
    // Time O(log n)
    // Space O(1)
    // Template1
    public int binarySearch1(int[] arr, int x) {
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

    // Gurantees Search Space is at least 2 in size at each step
    public int binarySearch2(int[] nums, int target) {
        int left = 0, right = nums.length;
        while(left < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) { 
                left = mid + 1; 
            }
            else { 
                right = mid;   
            }
        }
      
        // Post-processing:
        // End Condition: left == right
        if(left != nums.length && nums[left] == target) return left;
        return -1;
    }

    // Gurantees Search Space is at least 3 in size at each step
    public int binarySearch3(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
    
        // Post-processing:
        // End Condition: left + 1 == right
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
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
        System.out.println(bs.binarySearch3(arr, 8));
    }
}