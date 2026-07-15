package Recursion;

import java.util.List;
import java.util.ArrayList;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        // List to store all valid combinations
        List<String> ans = new ArrayList<>();
        
        // Start recursion with:
        // current string = ""
        // open brackets used = 0
        // closed brackets used = 0
        solve("", 0, 0, n, ans);
        
        return ans;
    }

    // Recursive backtracking function
    private void solve(String curr, int open, int closed, int total, List<String> ans) {

        // Base case:
        // If the current string length becomes 2 * total,
        // we have used all parentheses correctly
        if (curr.length() == 2 * total) {
            ans.add(curr);     // Add valid combination to result
            return;
        }

        // If we can still add opening bracket
        // (i.e., used '(' is less than total allowed)
        if (open < total) {
            solve(curr + "(", open + 1, closed, total, ans);
        }

        // We can add closing bracket only if
        // number of ')' used is less than '(' used
        // This ensures the string remains valid
        if (closed < open) {
            solve(curr + ")", open, closed + 1, total, ans);
        }
    }
}

/*
========================================
CALL STACK DRY RUN
generateParenthesis(n = 2)
========================================

Initial Call:
solve("", 0, 0)

----------------------------------------
1) solve("",0,0)
   -> add "("
2) solve("(",1,0)
   -> add "("
3) solve("((",2,0)
   -> add ")"
4) solve("(()",2,1)
   -> add ")"
5) solve("(())",2,2)
   -> length == 4
   -> add "(())"
   -> return (stack pop)

----------------------------------------
Backtracking happens automatically
Return to solve("(",1,0)

Now try second option:
   -> add ")"
6) solve("()",1,1)
   -> add "("
7) solve("()(",2,1)
   -> add ")"
8) solve("()()",2,2)
   -> length == 4
   -> add "()()"
   -> return

----------------------------------------
FINAL RESULT:
["(())", "()()"]

----------------------------------------
CALL STACK BEHAVIOR:

Push when recursive call happens
Pop when function returns

Max recursion depth = 2*n
Time Complexity ≈ Catalan number growth
Space Complexity = O(n) (recursion stack)
========================================
*/