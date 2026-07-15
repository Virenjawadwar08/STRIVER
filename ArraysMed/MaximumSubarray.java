package ArraysMed;

public class MaximumSubarray {
    public int maxSub(int[] nums) {
        int cs=0;
        int ms=Integer.MIN_VALUE;
        boolean allNegative=true;
        int maxElement=nums[0];

        for(int i=0;i<nums.length;i++) {
            cs=cs+nums[i];

            if(nums[i]>0) {
                allNegative=false;
            }
            maxElement=Math.max(maxElement,nums[i]);

            if(cs<0) {
                cs=0;
            }
            ms=Math.max(ms,cs);
        }
        if(allNegative) {
            return maxElement;
        }
        else {
            return ms;
        }
    }
}
