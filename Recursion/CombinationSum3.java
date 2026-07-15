package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
      public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result,
    List<Integer> current,int k,int target,int start) {
        
        // If combination size == k and target == 0 → valid
        if (current.size() == k && target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Stop if invalid
        if (current.size() > k || target < 0) {
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            
            current.add(i);
            
            // Move to next number (i+1) since no reuse allowed
            backtrack(result, current, k, target - i, i + 1);
            
            current.remove(current.size() - 1);  // backtrack
        }
    }
}


/*
========================================
DRY RUN
Combination Sum III
k = 3, target = 7
Numbers allowed: 1 to 9
========================================

Initial Call:
backtrack([], k=3, target=7, start=1)

----------------------------------------
Level 0: current = [], target=7

i = 1 → pick 1
----------------------------------------
Level 1: current = [1], target=6, start=2

    i = 2 → pick 2
    --------------------------------
    Level 2: current = [1,2], target=4, start=3

        i = 3 → pick 3
            current = [1,2,3]
            target = 1
            size=3 but target!=0 → return

        i = 4 → pick 4
            current = [1,2,4]
            target = 0
            size=3 AND target=0 ✔
            → add [1,2,4]

        i = 5 → pick 5
            target becomes negative → stop

    ← backtrack to Level 1

    i = 3 → pick 3
        current = [1,3]
        target = 3

        i = 4 → pick 4
            target negative → stop

    i = 4 → pick 4
        current = [1,4]
        target = 2
        no valid 3rd number → stop

----------------------------------------
Back to Level 0

i = 2 → pick 2
    current = [2]
    target = 5

    i = 3 → pick 3
        current = [2,3]
        target = 2
        no valid third number → stop

    i = 4 → pick 4
        current = [2,4]
        target = 1
        no valid third number → stop

----------------------------------------

i = 3 → pick 3
    current = [3]
    target = 4
    no valid size-3 combination → stop

i = 4 → pick 4
    target becomes too small → stop

Remaining numbers > target → stop

========================================
FINAL RESULT:
[1,2,4]
========================================
*/