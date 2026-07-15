package ArraysEasy;
import java.util.Arrays;

public class rotateLeft {
    public static void rotateL(int[] nums,int k) {
        int n=nums.length;
        if(n==0) return;
        k=k%n;
        if(k==0) return;

        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
        reverse(nums, 0, n-1);

    }

    public static void reverse(int[] nums,int i,int j) {
        while(i<j) {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        rotateL(nums1, 2);
        System.out.println(Arrays.toString(nums1)); // [3, 4, 5, 6, 1, 2]

        int[] nums2 = {3, 4, 1, 5, 3, -5};
        rotateL(nums2, 8);
        System.out.println(Arrays.toString(nums2)); // [1, 5, 3, -5, 3, 4]
    }
}//O(n) time, O(1) extra space

// Example Dry Run
// nums = [1,2,3,4,5,6,7]
// k = 3
// n = 7
// k = k % n = 3

// Step 1: Reverse first k elements (0 to 2)
// [1,2,3,4,5,6,7]
// → [3,2,1,4,5,6,7]

// Step 2: Reverse remaining elements (3 to 6)
// [3,2,1,4,5,6,7]
// → [3,2,1,7,6,5,4]

// Step 3: Reverse whole array (0 to 6)
// [3,2,1,7,6,5,4]
// → [4,5,6,7,1,2,3]

// ✅ Final Output (Left Rotated by 3)
// [4,5,6,7,1,2,3]


// Reverse first k
// Reverse remaining
// Reverse whole array
