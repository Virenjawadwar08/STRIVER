package ArraysEasy;
public class rotateArray {
    public void rotate(int[] nums,int k) {
        k=k%nums.length;
        int n=nums.length;
        reverseNum(nums, 0, n-1);
        reverseNum(nums, 0, k-1);
        reverseNum(nums, k, n-1);
        
    }

    public void reverseNum(int[]nums,int start,int end) {
        while(start<end) {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
        
    }
}
//tc-O(1)


// nums = [1,2,3,4,5,6,7]
// k = 3
// n = 7
// k = k % n = 3
// Step 1: Reverse whole array
// [1,2,3,4,5,6,7]
// → [7,6,5,4,3,2,1]
// Step 2: Reverse first k elements (0 to 2)
// [7,6,5,4,3,2,1]
// → [5,6,7,4,3,2,1]
// Step 3: Reverse remaining elements (3 to 6)
// [5,6,7,4,3,2,1]
// → [5,6,7,1,2,3,4]
// ✅ Final Output
// [5,6,7,1,2,3,4]

// Reverse whole array
// Reverse first k elements
// Reverse remaining elements
