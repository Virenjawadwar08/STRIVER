package SlidingWindowandTwoPointers;
// https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
public class MaxSumSubarrayofSizeK {
     public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int n=arr.length;
        
        int windowSum=0;
        int maxSum=0;
        
        //first window
        for(int i=0;i<k;i++) {
            windowSum+=arr[i];
        }
        maxSum=windowSum;
        
        //slide the window
        for(int i=1;i<n-k+1;i++) {
            windowSum=windowSum-arr[i-1]+arr[i+k-1];
            maxSum=Math.max(maxSum,windowSum);
        }
        return maxSum;
}
}