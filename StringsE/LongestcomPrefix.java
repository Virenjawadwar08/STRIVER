package StringsE;

public class LongestcomPrefix {

    public String longestCommonPrefix(String[] strs) {

        // If the array is null or empty, there is no common prefix
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Loop through each character index of the first string
        for (int i = 0; i < strs[0].length(); i++) {

            // Take the current character from the first string as reference
            char ch = strs[0].charAt(i);

            // Compare this character with the same index of all other strings
            for (int j = 1; j < strs.length; j++) {

                // If:
                // 1) We reached the end of any string, OR
                // 2) Characters at index i do not match
                // then the common prefix ends here
                if (i == strs[j].length() || strs[j].charAt(i) != ch) {

                    // Return prefix from start up to (but not including) index i
                    return strs[0].substring(0, i);
                }
            }
        }

        // If all characters of the first string matched,
        // then the entire first string is the common prefix
        return strs[0];
    }
}



// Input
// strs = ["flower","flow","flight"]

// Iteration: i = 2
// ch = strs[0].charAt(2) → 'o'


// Now compare with other strings:

// j = 1
// strs[1] = "flow"
// strs[1].charAt(2) → 'o'


// ✅ Matches

// j = 2
// strs[2] = "flight"
// strs[2].charAt(2) → 'i'


// Now check:

// 'i' != 'o'  → true


// ❌ Mismatch found
// ➡ Prefix cannot continue beyond index 2

// So code executes:

// return strs[0].substring(0, 2); // "fl"
