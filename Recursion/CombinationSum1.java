package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
     public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private static void backtrack(List<List<Integer>> result,
                           List<Integer> current,
                           int[] candidates,
                           int target,
                           int index) {
        
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (index == candidates.length || target < 0) {
            return;
        }
        
        // PICK (stay at same index)
        current.add(candidates[index]);
        backtrack(result, current, candidates, target - candidates[index], index);
        current.remove(current.size() - 1);
        
        // NOT PICK (move to next index)
        backtrack(result, current, candidates, target, index + 1);
    }

    public static void main(String[] args) {
      int[] candidates={2,3,6,7};
      System.out.println(combinationSum(candidates, 7));
    }
}



/*
========================================
CALL STACK TRACE
candidates = [2,3,6,7]
target = 7
========================================

backtrack([], target=7, index=0)

→ pick 2
   backtrack([2], target=5, index=0)

   → pick 2
      backtrack([2,2], target=3, index=0)

      → pick 2
         backtrack([2,2,2], target=1, index=0)

         → pick 2
            backtrack([2,2,2,2], target=-1) ❌ return

         → not pick 2 → try 3
            backtrack([2,2,2], target=1, index=1)

            → pick 3
               backtrack([2,2,2,3], target=-2) ❌

            → not pick 3 → try 6
               backtrack(... target=1, index=2) ❌

      ← backtrack

      → not pick 2 → try 3
         backtrack([2,2], target=3, index=1)

         → pick 3
            backtrack([2,2,3], target=0) ✔ add

→ not pick 2 → try 3
   backtrack([], target=7, index=1)

   → pick 3
      backtrack([3], target=4, index=1)
      ...

   → not pick 3 → try 6
      backtrack([], target=7, index=2)

      → pick 6
         backtrack([6], target=1) ❌

      → not pick 6 → try 7
         backtrack([], target=7, index=3)

         → pick 7
            backtrack([7], target=0) ✔ add

========================================
VALID COMBINATIONS:
[2,2,3]
[7]
========================================
*/