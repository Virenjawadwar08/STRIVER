package ArraysEasy;
public class SortArray {
    public static boolean isSortedOptimal(int[] nums) {
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i]>nums[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 1, 4, 5};

          System.out.println("Optimal nums1: " + isSortedOptimal(nums1));
            System.out.println("Optimal nums1: " + isSortedOptimal(nums2));
    }
}