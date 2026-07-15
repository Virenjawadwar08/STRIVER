package ArraysEasy;
public class MoveZeroes {
    public void zeros(int[] nums) {
        int index=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0) {
                nums[index++]=nums[i];
            }
        }
        for(int i=index;i<nums.length;i++) {
            nums[i]=0;
        }
    }
}
//tc-O(n) and sc-O(1)