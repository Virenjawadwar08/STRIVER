package SlidingWindowandTwoPointers;

public class MaxConsecutiveOne111 {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int maxLen=0;
        int zeroCount=0;

        for(int right=0;right<nums.length;right++) {
            if(nums[right]==0) {
                zeroCount++;
            }

            while(zeroCount>k) {
                if(nums[left]==0) {
                    zeroCount--;
                }
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}

// Dry Run
// nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2

// left=0, zeroCount=0, maxLen=0

// right=0 → 1 → window=[1] → maxLen=1
// right=1 → 1 → window=[1,1] → maxLen=2
// right=2 → 1 → window=[1,1,1] → maxLen=3

// right=3 → 0 → zeroCount=1 → maxLen=4
// right=4 → 0 → zeroCount=2 → maxLen=5

// right=5 → 0 → zeroCount=3 > k
//     shrink:
//     left=0→1 (skip)
//     left=1→1 (skip)
//     left=2→1 (skip)
//     left=3→0 → zeroCount=2
// window=[0,0,0] → valid again

// right=6 → 1 → window grows → maxLen=5
// right=7 → 1 → maxLen=6
// right=8 → 1 → maxLen=7
// right=9 → 1 → maxLen=8

// right=10 → 0 → zeroCount=3 > k
//     shrink left until zeroCount=2

// Final maxLen = 6