package Recursion;

public class CountSubsequences {
     public int countSubsequenceWithTargetSum(int[] nums, int k) {
        return solve(nums,0,0,k);
     }

     private int solve(int[] nums,int index,int currSum,int target) {

        //base case
        if(index==nums.length) {
            return currSum==target?1:0;
        }

        //pick the element 
        int pick=solve(nums, index+1, currSum+nums[index], target);

        //do not pick the element
        int notPick=solve(nums, index+1, currSum, target);

        return pick+notPick;
     }
}


/*
========================================
CALL STACK TRACE
nums = [4,9,2,5,1], k = 10
Function: solve(index, currentSum)
========================================

solve(0,0)

→ pick 4
   solve(1,4)

   → pick 9
      solve(2,13)  ✘ (eventually no match)

   → not pick 9
      solve(2,4)

      → pick 2
         solve(3,6)

         → pick 5
            solve(4,11) ✘

         → not pick 5
            solve(4,6)

            → pick 1
               solve(5,7) ✘
            → not pick 1
               solve(5,6) ✘

      → not pick 2
         solve(3,4)

         → pick 5
            solve(4,9)

            → pick 1
               solve(5,10) ✔ (count = 1)  [4,5,1]

            → not pick 1
               solve(5,9) ✘

         → not pick 5
            solve(4,4)

            → pick 1
               solve(5,5) ✘
            → not pick 1
               solve(5,4) ✘

------------------------------------------------

→ not pick 4
   solve(1,0)

   → pick 9
      solve(2,9)

      → pick 2
         solve(3,11) ✘

      → not pick 2
         solve(3,9)

         → pick 5
            solve(4,14) ✘

         → not pick 5
            solve(4,9)

            → pick 1
               solve(5,10) ✔ (count = 1)  [9,1]

            → not pick 1
               solve(5,9) ✘

   → not pick 9
      solve(2,0)
      (No combination gives 10)

========================================
VALID SUBSEQUENCES:
[4,5,1]
[9,1]

TOTAL COUNT = 2
========================================
*/