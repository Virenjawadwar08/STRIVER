package ArraysEasy;
public class SortedandRotated {
    public boolean check(int[] nums) {
        int len=nums.length;
        int deviations=0;
        for(int i=0;i<len;i++) {
            if(i<len-1 && nums[i]>nums[i+1]) {
                deviations++;
            }
            else if(i==len-1 && nums[len-1]>nums[0]) {
                deviations++;
            }
        }
        return (deviations>1) ? false:true;
    }
}

// A sorted array rotates at one pivot point only

// Two breaks mean the order is messed up in two locations → not logically possible from a single rotation

// Example 1: nums = [3,4,5,1,2]
// Initial:
// len = 5
// deviations = 0

// Loop:

// i = 0 → 3 ≤ 4 → no deviation

// i = 1 → 4 ≤ 5 → no deviation

// i = 2 → 5 > 1 → deviation = 1

// i = 3 → 1 ≤ 2 → no deviation

// i = 4 (last) → 2 > 3 ? NO → no deviation

// Result:
// deviations = 1 → valid → return true