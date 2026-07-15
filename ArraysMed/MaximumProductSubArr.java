package ArraysMed;

public class MaximumProductSubArr {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE ;
        int temp = 1 ;
        int n = nums.length ;
        for(int i = 0;i<n;i++)
        {
            temp *= nums[i] ;
            max = Math.max(max,temp) ;
            if(nums[i] == 0) temp = 1;
        }
        temp = 1 ;
        for(int i =n-1;i>=0;i--)
        {
            temp*=nums[i] ;
            max = Math.max(max,temp) ;
            if(nums[i] == 0) temp =1 ;
        }
        return max ;
    }
}


// 📊 Example Dry Run
// Input:
// nums = [2, 3, -2, 4]
// Left Pass:
// temp = 1
// i=0 → temp=2 → max=2
// i=1 → temp=6 → max=6
// i=2 → temp=-12 → max=6
// i=3 → temp=-48 → max=6
// Right Pass:
// temp=1
// i=3 → temp=4 → max=6
// i=2 → temp=-8 → max=6
// i=1 → temp=-24 → max=6
// i=0 → temp=-48 → max=6

// 👉 Final Answer = 6

// ⏱️ Time & Space Complexity
// Time Complexity: O(n)
// (Two linear passes → 2n ≈ n)
// Space Complexity: O(1)
// (No extra space used)