package StringsE;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        return (s+s).contains(goal);
    }
}

//tc- O(n)
//sc- O(n)

// INTERVIEW ONE-LINER

// “If goal is a rotation of s, it must appear as a substring of s + s, since all rotations are contained within that.”

// 🧪 Dry Run
// Input
// s = "abcde"
// goal = "cdeab"

// Step 1: Length check
// s.length == goal.length → 5 == 5 → OK

// Step 2: Concatenate
// s + s = "abcdeabcde"

// Step 3: Substring check
// "abcdeabcde".contains("cdeab") → true

// ✅ Output
// true
