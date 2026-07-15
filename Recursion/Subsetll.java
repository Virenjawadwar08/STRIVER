package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsetll {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);  // Step 1: Sort
        
        backtrack(result, new ArrayList<>(), nums, 0);
        
        return result;
    }
    
    private void backtrack(List<List<Integer>> result,
                           List<Integer> current,
                           int[] nums,
                           int index) {
        
        // Add current subset
        result.add(new ArrayList<>(current));
        
        for (int i = index; i < nums.length; i++) {
            
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            
            current.add(nums[i]);
            
            backtrack(result, current, nums, i + 1);
            
            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}


/*
========================================
CALL STACK TRACE
nums = [1,2,2]
========================================

Initial:
backtrack([], index=0)
→ add []

----------------------------------------
Level 0 (index=0)

i=0 → nums[0]=1
----------------------------------------
Level 1:
current = [1]
→ add [1]

    i=1 → nums[1]=2
    --------------------------------
    Level 2:
    current = [1,2]
    → add [1,2]

        i=2 → nums[2]=2
        --------------------------------
        Level 3:
        current = [1,2,2]
        → add [1,2,2]
        ← backtrack

    ← backtrack

    i=2 → nums[2]=2
    nums[2] == nums[1] AND i>index
    → SKIP (prevents duplicate [1,2])

← backtrack

----------------------------------------
i=1 → nums[1]=2
----------------------------------------
Level 1:
current = [2]
→ add [2]

    i=2 → nums[2]=2
    --------------------------------
    Level 2:
    current = [2,2]
    → add [2,2]
    ← backtrack

← backtrack

----------------------------------------
i=2 → nums[2]=2
nums[2] == nums[1] AND i>index
→ SKIP (prevents duplicate [2])

========================================
FINAL OUTPUT:
[]
[1]
[1,2]
[1,2,2]
[2]
[2,2]
========================================
*/

// Even though loop starts with i = index, it increments, and once i becomes greater than index, the duplicate check becomes active.