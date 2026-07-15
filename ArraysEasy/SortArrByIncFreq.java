package ArraysEasy;

import java.util.Arrays;
import java.util.HashMap;

public class SortArrByIncFreq {
    public int[] frequencySort(int[] nums) {
        // Step 1: count frequency

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int num:nums) {
        map.put(num,map.getOrDefault(num, 0)+1);
        }

         // Step 2: convert to Integer[]
         Integer[] temp=new Integer[nums.length];
         for(int i=0;i<nums.length;i++) {
            temp[i]=nums[i];
         }

         // Step 3: sort
         Arrays.sort(temp,(a,b)-> {
            if(!map.get(a).equals(map.get(b))) {
                return map.get(a)-map.get(b);// lower freq first
            } else {
                return b-a;//higher value first
            }
         });

         // Step 4: convert back
         int[] result=new int[nums.length];
         for(int i=0;i<nums.length;i++) {
            result[i]=temp[i];
         }

         return result;
    }
}

// Input:
// nums = [1,1,2,2,2,3]

// Step 1: Frequency Map
// 1 → 2
// 2 → 3
// 3 → 1

// Step 2: Sorting rule
// - Lower freq first
// - If equal → larger number first

// Sorted:
// [3,1,1,2,2,2]

// Integer[] temp = new Integer[nums.length];

// 👉 Create wrapper array (needed for custom sorting)

// for (int i = 0; i < nums.length; i++) {
//     temp[i] = nums[i];
// }

// 👉 Copy elements into Integer[]

// Arrays.sort(temp, (a, b) -> {

// 👉 Custom sorting starts

// if (!map.get(a).equals(map.get(b))) {
//     return map.get(a) - map.get(b);
// }

// 👉 If frequencies are different:

// Sort by frequency (ascending)

// Example:

// freq(3)=1 comes before freq(1)=2
// else {
//     return b - a;
// }

// 👉 If frequencies are same:

// Sort by value (descending)

// Example:

// 3 comes before 1