package greedyAlgo;

public class JumpGame2 {
    public int jump(int[] nums) {
        int jumps=0;
        int end=0;
        int farthest=0;

        for(int i=0;i<nums.length-1;i++) {
            farthest=Math.max(farthest,i+nums[i]);

            if(i==end) {
                jumps++;
                end=farthest;
            }
        }
        return jumps;
    }
}

// Dry Run (Copyable)
// Example:
// nums = [2,3,1,1,4]
// Initial:
// jumps = 0
// end = 0
// farthest = 0
// Step 1: i = 0
// farthest = max(0, 0+2) = 2

// i == end → 0 == 0 ✔
// → take jump

// jumps = 1
// end = 2
// Step 2: i = 1
// farthest = max(2, 1+3) = 4
// i != end → continue
// Step 3: i = 2
// farthest = max(4, 2+1) = 4

// i == end → 2 == 2 ✔
// → take jump

// jumps = 2
// end = 4
// Loop ends → return 2 