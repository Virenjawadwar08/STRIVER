package SlidingWindowandTwoPointers;

public class BinarySubArraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal)-helper(nums, goal-1);
    }

    public int helper(int[] nums,int goal) {
        if(goal<0) {
            return 0;
        }

        int count=0,sum=0;
        int start=0,end=0;

        while(start<nums.length) {
            sum+=nums[start];
            while(end<nums.length && sum>goal) {
                sum-=nums[end];
                end++;
            }
            count+=start-end+1;
            start++;
        }
        return count;
    }
}


// Dry Run
// nums = [1,0,1,0,1], goal = 2

// exactly(goal) = atMost(2) - atMost(1)

// -----------------------------------
// helper(nums, 2)

// start=0, end=0, sum=0, count=0

// start=0 → add 1 → sum=1
// count += (0-0+1)=1 → count=1

// start=1 → add 0 → sum=1
// count += (1-0+1)=2 → count=3

// start=2 → add 1 → sum=2
// count += (2-0+1)=3 → count=6

// start=3 → add 0 → sum=2
// count += (3-0+1)=4 → count=10

// start=4 → add 1 → sum=3 (>2)

// shrink:
// end=0 → remove 1 → sum=2, end=1

// count += (4-1+1)=4 → count=14

// atMost(2) = 14

// -----------------------------------
// helper(nums, 1)

// start=0, end=0, sum=0, count=0

// start=0 → add 1 → sum=1
// count +=1 → count=1

// start=1 → add 0 → sum=1
// count +=2 → count=3

// start=2 → add 1 → sum=2 (>1)

// shrink:
// end=0 → remove 1 → sum=1, end=1

// count += (2-1+1)=2 → count=5

// start=3 → add 0 → sum=1
// count += (3-1+1)=3 → count=8

// start=4 → add 1 → sum=2 (>1)

// shrink:
// end=1 → remove 0 → sum=2, end=2
// end=2 → remove 1 → sum=1, end=3

// count += (4-3+1)=2 → count=10

// atMost(1) = 10

// -----------------------------------
// Final Answer:

// exactly(2) = 14 - 10 = 4