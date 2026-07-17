package BinarySearch;

public class FloorAndCeil {
    public int[] getFloorAndCeil(int[] nums, int x) {
        int floor=-1;
        int ceil=-1;
        int low=0;
        int high=nums.length-1;

        while(low<=high) {
            int mid=low+(high-low)/2;

            if(nums[mid]<=x) {
                floor=nums[mid];
                low=mid+1;
            } else {
                high=mid-1;
            }
        }

        low=0;
        high=nums.length-1;

        while(low<=high) {
            int mid=low+(high-low)/2;
            if(nums[mid]>=x) {
                ceil=nums[mid];
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return new int[] {floor,ceil};
    }
}
