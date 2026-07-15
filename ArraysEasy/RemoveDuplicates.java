package ArraysEasy;
public class RemoveDuplicates {
    public int removeDup(int[] nums) {
        int count=0;

        for(int i=0;i<nums.length;i++) {
            if(i<nums.length-1 && nums[i]==nums[i+1]) {
                continue;
            }
            else {
                nums[count]=nums[i];
                count++;
            }
        }
        return count;
    }
}

// For the input [1,1,2,2,3], 
// we start with count = 0. At i = 0, 1 == 1, so it is a duplicate and we skip.
//  At i = 1, 1 != 2, so we write nums[0] = 1 and increment count to 1. 
// At i = 2, 2 == 2, so we skip. 
// At i = 3, 2 != 3, so we write nums[1] = 2 and increase count to 2. 
// At i = 4 (last index), we always write, so nums[2] = 3 and count becomes 3. 
// Final result: count = 3, and the first three elements of the array become [1, 2, 3].

