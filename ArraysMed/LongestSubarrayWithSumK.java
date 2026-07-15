package ArraysMed;

public class LongestSubarrayWithSumK {
    //brute force approach
    public static int longestSubarrayBrute(int[] nums, int k) {
        int maxLen=0;

        for(int i=0;i<nums.length;i++) {
            int sum=0;

            for(int j=i;j<nums.length;j++) {
                sum+=nums[j];

                if(sum==k) {
                    maxLen=Math.max(maxLen,j-i+1);
                }
            }
        }
        return maxLen;
    }}

    // public static int longestSubarrayOptimal(int[] nums, int k) {
    //     HashMap<Integer,Integer> map=new HashMap<>();

    //     int sum=0;
    //     int maxLen=0;

    //     for(int i=0;i<nums.length;i++) {
    //         sum+=nums[i];

    //         if(sum==k) {
    //             maxLen=i+1;
    //         }

    //         if(map.containsKey(sum-k)) {
    //             maxLen=Math.max(maxLen,i-map.get(sum-k));
    //         }

    //         if(!map.containsKey(sum)) {
    //             map.put(sum,i);
    //         }
    //     }
    //     return maxLen;
    // }

//     public static void longestSubarrayOptimal(int[] nums, int k) {
//         HashMap<Integer,Integer> map=new HashMap<>();
//         int sum=0;
//         int maxLen=0;
//         int start=-1;
//         int end=-1;

//         for(int i=0;i<nums.length;i++) {
//             sum+=nums[i];

//             // Case 1: subarray from 0 to i

//             if(sum==k) {
//                 maxLen=i+1;
//                 start=0;
//                 end=i;
//             }

//              // Case 2: subarray from (prevIndex+1) to i
//              if(map.containsKey(sum-k)) {
//                 int prevIndex=map.get(sum-k);
//                 int len=i-prevIndex;

//                 if(len>maxLen) {
//                 maxLen=len;
//                 start=prevIndex+1;
//                 end=i;
//              }
//              }
//               // store first occurrence only
//               if(!map.containsKey(sum)) {
//                 map.put(sum,i);
//               }
//         }
//          if (start == -1) {
//         System.out.println("No subarray found");
//     } else {
//         System.out.print("Subarray:");
//         for(int i=start;i<=end;i++) {
//             System.out.println(nums[i]+" ");
//         }
//     }

//     //for this dry run is given
// //     🧠 Dry Run Example
// // nums = [10, 5, 2, 7, 1, 9]
// // k = 15


// // At index 4:

// // sum = 25
// // sum - k = 10
// // 10 exists at index 0


// // So:

// // start = 0 + 1 = 1
// // end = 4


// // Subarray:

// // [5, 2, 7, 1]

// // ✅ Output
// // Subarray: 5 2 7 1

// // If currentSum - k exists at index X,
// // then subarray is from X+1 to current index.

//     }
// }
