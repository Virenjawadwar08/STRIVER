package Recursion;

import java.util.List;
import java.util.ArrayList;

public class PowerSet {
     public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(result,new ArrayList<>(),nums,0);
        return result;
    }

     private void backtrack(List<List<Integer>> result,List<Integer> current,int[] nums,int index) {
        result.add(new ArrayList<>(current));

        for(int i=index;i<nums.length;i++) {
            current.add(nums[i]);

            backtrack(result, current, nums, i+1);

            current.remove(current.size()-1);
        }
    }
}


/*
========================================
CALL STACK TRACE
Power Set of [1,2,3]
========================================

Initial Call:
backtrack([], index=0)

----------------------------------------
Level 0:
current = []
→ add []

i=0 → include 1
----------------------------------------
Level 1:
current = [1]
→ add [1]

    i=1 → include 2
    --------------------------------
    Level 2:
    current = [1,2]
    → add [1,2]

        i=2 → include 3
        ----------------------------
        Level 3:
        current = [1,2,3]
        → add [1,2,3]
        ← backtrack (remove 3)

    ← backtrack (remove 2)

    i=2 → include 3
    --------------------------------
    Level 2:
    current = [1,3]
    → add [1,3]
    ← backtrack (remove 3)

← backtrack (remove 1)

----------------------------------------
i=1 → include 2
----------------------------------------
Level 1:
current = [2]
→ add [2]

    i=2 → include 3
    --------------------------------
    Level 2:
    current = [2,3]
    → add [2,3]
    ← backtrack (remove 3)

← backtrack (remove 2)

----------------------------------------
i=2 → include 3
----------------------------------------
Level 1:
current = [3]
→ add [3]
← backtrack

========================================
FINAL RESULT:
[]
[1]
[1,2]
[1,2,3]
[1,3]
[2]
[2,3]
[3]

----------------------------------------
CALL STACK RULE:
Push on recursive call
Pop after backtracking
Max depth = n
Time Complexity = O(2^n)
========================================
*/