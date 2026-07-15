package SlidingWindowandTwoPointers;

public class CountNumberOfNiceSubArr {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmostK(nums, k)-atmostK(nums, k-1);
    }

    private int atmostK(int[] nums,int k) {
        int count=0,ans=0;
        int start=0;

        for(int end=0;end<nums.length;end++) {
            if(nums[end]%2!=0) count+=1;
            while(start<nums.length && count>k) {
                if(nums[start]%2!=0) count--;
                start++;
            }
            ans+=(end-start+1);
        }
        return ans;
    }
}

// Dry Run
// nums = [1,1,2,1,1], k = 3

// -----------------------------------
// atMost(3)

// start=0, count=0, ans=0

// end=0 → 1 (odd) → count=1
// ans +=1 → 1

// end=1 → 1 (odd) → count=2
// ans +=2 → 3

// end=2 → 2 (even) → count=2
// ans +=3 → 6

// end=3 → 1 (odd) → count=3
// ans +=4 → 10

// end=4 → 1 (odd) → count=4 (>3)

// shrink:
// start=0 → remove 1 → count=3, start=1

// ans += (4-1+1)=4 → ans=14

// atMost(3) = 14

// -----------------------------------
// atMost(2)

// start=0, count=0, ans=0

// end=0 → 1 → count=1
// ans +=1 → 1

// end=1 → 1 → count=2
// ans +=2 → 3

// end=2 → 2 → count=2
// ans +=3 → 6

// end=3 → 1 → count=3 (>2)

// shrink:
// start=0 → remove 1 → count=2, start=1

// ans += (3-1+1)=3 → ans=9

// end=4 → 1 → count=3 (>2)

// shrink:
// start=1 → remove 1 → count=2, start=2

// ans += (4-2+1)=3 → ans=12

// atMost(2) = 12

// -----------------------------------
// Final Answer:

// exactly(3) = 14 - 12 = 2

//tc-O(n) ,sc-O(1)