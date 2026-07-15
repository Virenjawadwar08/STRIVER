package greedyAlgo;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach=0;

        for(int i=0;i<nums.length;i++) {
            if(i>maxReach) return false;
            maxReach=Math.max(maxReach,i+nums[i]);
        }
        return true;
    }
}

// Example:
// nums = [2,3,1,1,4]
// Initial:
// maxReach = 0
// Step 1: i = 0
// i <= maxReach → 0 <= 0 ✔
// maxReach = max(0, 0 + 2) = 2
// Step 2: i = 1
// 1 <= 2 ✔
// maxReach = max(2, 1 + 3) = 4
// Step 3: i = 2
// 2 <= 4 ✔
// maxReach = max(4, 2 + 1) = 4
// Step 4: i = 3
// 3 <= 4 ✔
// maxReach = max(4, 3 + 1) = 4
// Step 5: i = 4
// 4 <= 4 ✔
// maxReach = max(4, 4 + 4) = 8
// Loop ends → return true 

// tc-O(n), sc-O(1)