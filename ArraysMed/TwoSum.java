package ArraysMed;
import java.util.*;
public class TwoSum {
    public int[] twoSum(int[] nums,int target) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            int complement=target-nums[i];

            if(map.containsKey(complement)) {
                return new int[] {map.get(complement),i};
            }
            else {
                map.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("No match");
    }
}


// For every element:

// Check if its complement exists

// Complement = target - currentNumber

// If found → return their indices.

// 🔹 Example Dry Run
// nums = [2, 7, 11, 15]
// target = 9

// Initial State
// map = {}


// Map stores:

// number → index

// 🔹 i = 0
// nums[0] = 2
// complement = 9 - 2 = 7


// Check:

// map.containsKey(7) → NO


// So store:

// map.put(2, 0)


// Map:

// {2 → 0}

// 🔹 i = 1
// nums[1] = 7
// complement = 9 - 7 = 2


// Check:

// map.containsKey(2) → YES


// We found it!

// Return:

// { map.get(2), 1 }


// Which is:

// {0, 1}

// ✅ Final Answer
// [0, 1]