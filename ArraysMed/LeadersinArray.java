package ArraysMed;

import java.util.*;

public class LeadersinArray {
    public static List<Integer> leaders(int[] nums) {
        List<Integer> result=new ArrayList<>();
        int maxFromRight=Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--) {
            if(nums[i]>maxFromRight) {
               result.add(nums[i]);
               maxFromRight=nums[i];
            }
        }
        Collections.reverse(result);
        return result;
    }
}

//tc-O(n)
// Dry Run (Example 2)

// nums = [-3, 4, 5, 1, -4, -5]

// Traverse from right:

// -5 → leader → max = -5

// -4 > -5 → leader → max = -4

// 1 > -4 → leader → max = 1

// 5 > 1 → leader → max = 5

// 4 < 5 → skip

// -3 < 5 → skip

// Collected (reverse order): [-5, -4, 1, 5]
// After reverse → [5, 1, -4, -5]

//brute force 

// public class LeadersinArray {
//     public static List<Integer> leaders(int[] nums) {
//         List<Integer> result=new ArrayList<>();
//         int n=nums.length;
//         for(int i=0;i<n;i++) {
//             boolean isLeader=true;
            
//             for(int j=i+1;j<n;j++) {
//                 if(nums[j]>=nums[i]) {
//                     isLeader=false;
//                     break;
//                 }
//             }
//             if(isLeader) {
//                 result.add(nums[i]);
//             }
//         }
//         return result;
//     }
// }

//tc-O(n^2)

// Dry Run (Example 1)

// nums = [1, 2, 5, 3, 1, 2]

// 1 → right side has bigger → ❌

// 2 → right side has bigger → ❌

// 5 → greater than all right → ✅

// 3 → greater than [1,2] → ✅

// 1 → right has bigger → ❌

// 2 → rightmost → ✅

// Output: [5, 3, 2]