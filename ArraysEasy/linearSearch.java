package ArraysEasy;
public class linearSearch {
    public static int Ls(int[] nums,int target) {
        int n=nums.length;

        for(int i=0;i<n;i++) {
            if(nums[i]==target) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums={2,3,4,5,3};
        int target=3;
        System.out.println(Ls(nums, target));
    }
}


// Find All Indices of Target
// public class LinearSearchAll {
//     public static List<Integer> findAll(int[] nums, int target) {
//         List<Integer> result = new ArrayList<>();

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == target) {
//                 result.add(i);
//             }
//         }

//         return result;   // returns empty list if not found
//     }

//     public static void main(String[] args) {
//         int[] nums = {2, 3, 4, 5, 3};
//         int target = 3;

 //         List<Integer> indices = findAll(nums, target);
//         System.out.println(indices);   // Output: [1, 4]
//     }
// }


