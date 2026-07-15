package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);   // Sort to handle duplicates
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result,
List<Integer> current,int[] candidates,int target,int index) {
        
        // If target becomes 0 → valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            
            // Skip duplicates at same recursion level
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            // If current number exceeds target → stop (since sorted)
            if (candidates[i] > target) {
                break;
            }
            
            // Choose element (use only once → move to i+1)
            current.add(candidates[i]);
            
            backtrack(result, current, candidates, target - candidates[i], i + 1);
            
            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}

/*
========================================
CALL STACK TRACE
Sorted candidates = [1,1,2,5,6,7,10]
Target = 8
========================================

backtrack([], target=8, index=0)

i=0 → pick 1
----------------------------------------
backtrack([1], target=7, index=1)

    i=1 → pick 1
    --------------------------------
    backtrack([1,1], target=6, index=2)

        i=2 → pick 2
        backtrack([1,1,2], target=4) ❌

        i=3 → pick 5
        backtrack([1,1,5], target=1) ❌

        i=4 → pick 6
        backtrack([1,1,6], target=0) ✔ add

    ← backtrack

    i=2 → pick 2
    --------------------------------
    backtrack([1,2], target=5, index=3)

        i=3 → pick 5
        backtrack([1,2,5], target=0) ✔ add

    ← backtrack

    i=3 → pick 5
    backtrack([1,5], target=2) ❌

    i=4 → pick 6
    backtrack([1,6], target=1) ❌

    i=5 → pick 7
    backtrack([1,7], target=0) ✔ add

← backtrack

i=1 → SKIP (duplicate 1 at same level)

i=2 → pick 2
----------------------------------------
backtrack([2], target=6, index=3)

    i=3 → pick 5
    backtrack([2,5], target=1) ❌

    i=4 → pick 6
    backtrack([2,6], target=0) ✔ add

← backtrack

i=3 → pick 5 → no valid combination
i=4 → pick 6 → no valid combination
i=5 → pick 7 → no valid combination
i=6 → pick 10 → break (greater than target)

========================================
VALID COMBINATIONS:
[1,1,6]
[1,2,5]
[1,7]
[2,6]
========================================
*/