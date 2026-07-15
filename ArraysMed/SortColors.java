package ArraysMed;

public class SortColors {
     public void sortColors(int[] nums) {
        int start=0;
        int mid=0;
        int end=nums.length-1;

        while(mid<=end) {
            switch(nums[mid]) {
                case 0:
                //swap with start index
                swap(nums,start,mid);
                mid++;
                start++;
                break;

                case 1:
                mid++;
                break;

                case 2:
                    //swap with end index
                swap(nums,mid,end);
                end--;
                break;
            }
        }
    }
    private void swap(int[] arr,int pos1,int pos2) {
        int temp=arr[pos1];
        arr[pos1]=arr[pos2];
        arr[pos2]=temp;
    }
}

//another method

// public class SortColors {
//      public void sortColors(int[] nums) {
//         int zero=0,one=0,two=0;

//         for(int i=0;i<nums.length;i++) {
//             if(nums[i]==0) zero++;
//             if(nums[i]==1) one++;
//             if(nums[i]==2) two++;
//         }
//         for(int i=0;i<zero;i++) nums[i]=0;
//         for(int i=zero;i<one+zero;i++) nums[i]=1;

//         for(int i=one+zero;i<nums.length;i++) nums[i]=2;
//      }
// }