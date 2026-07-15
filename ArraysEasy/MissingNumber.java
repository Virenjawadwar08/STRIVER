package ArraysEasy;
public class MissingNumber {
    public int missingNum(int[] nums) {
        int n=nums.length;
        int sum=0;

        for(int i=0;i<n;i++) {
            sum=sum+nums[i];
        }

        int actualSum=(n*(n-1))/2;

        return actualSum-sum;
    }
}
