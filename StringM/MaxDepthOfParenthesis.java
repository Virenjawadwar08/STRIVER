public class MaxDepthOfParenthesis {
    public int maxDepth(String s) {
        int depth=0;
        int maxDepth=0;

        for(char ch:s.toCharArray()) {
            if(ch=='(') {
                depth++;
                maxDepth=Math.max(maxDepth,depth);
            }
            else if(ch==')') {
                depth--;
            }
        }
        return maxDepth;
    }
}

// Dry Run (Short & Clear)
// Example
// s = "(1+(2*3)+((8)/4))+1"

// Character	Action	depth	maxDepth
// '('	depth++	1	1
// '('	depth++	2	2
// '('	depth++	3	3
// ')'	depth--	2	3
// ')'	depth--	1	3
// ')'	depth--	0	3

// (Other characters like digits/operators are ignored)

// ✅ Output
// 3

// ⏱️ Complexity (Optimal)

// Time: O(n) (single pass)

// Space: O(1) (only counters)