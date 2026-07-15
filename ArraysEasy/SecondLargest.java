package ArraysEasy;
import java.util.Arrays;

public class SecondLargest {

    // ---------- Brute Force (Sorting) ----------
    public static int secondLargestBrute(int[] nums) {
        int n=nums.length;
        if(n<2) return -1;
        Arrays.sort(nums);
        int largest=nums[n-1];

        for(int i=2;i>=0;i--) {
            if(nums[i]!=largest) {
                return nums[i];
            }
        }
        return -1;

    }

    // ---------- Optimal (O(n)) ----------
    public static int secondLargestOptimal(int[] nums) {
       int max=Integer.MIN_VALUE;
       int second=Integer.MIN_VALUE;

       for(int n:nums) {
        if(n>max) {
            second=max;
            max=n;
        }
        else if(n>second && n<max) {
            second=n;
        }
       }
       return (second==Integer.MIN_VALUE) ? -1:second;
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        int[] nums = {8, 8, 7, 6, 5};

        System.out.println("Brute Force Output: " + secondLargestBrute(nums));
        System.out.println("Optimal Output: " + secondLargestOptimal(nums));
    }
}


// Approach	       Time	    Space	How it works
// Brute Force	O(n log n)	O(1)	Sort array, then find first smaller than max
// Optimal	        O(n)	O(1)	Track max and second in one pass

