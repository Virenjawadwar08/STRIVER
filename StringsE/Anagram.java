package StringsE;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) {
            return false;
        }

        int count[]=new int[26];
        for(int i=0;i<s.length();i++) {
           char ch=s.charAt(i);
           count[ch-'a']++; 
        }
        for(int i=0;i<t.length();i++) {
            char ch=t.charAt(i);
            count[ch-'a']--;
        }
        for(int i=0;i<count.length;i++) {
            if(count[i]!=0) {
                return false;
            }
        }
        return true;
    }
}




//tc-O(n) , sc-O(1)

// 🧪 Dry Run
// Input
// s = "anagram"
// t = "nagaram"

// Step 1: Count characters from s
// a n a g r a m


// After first loop (count[ch-'a']++):

// a → 3
// n → 1
// g → 1
// r → 1
// m → 1
// (all others → 0)

// Step 2: Subtract characters using t
// n a g a r a m


// After second loop (count[ch-'a']--):

// n → 0
// a → 0
// g → 0
// r → 0
// m → 0
// (all others → 0)

// Step 3: Final check
// for (count[i] != 0)


// All values are 0

// No mismatch found

// ✅ Output
// true

// String
// s = "abbc"

// Iterations
// Character	Index (ch-'a')	count[] change
// 'a'	0	count[0] = 1
// 'b'	1	count[1] = 1
// 'b'	1	count[1] = 2
// 'c'	2	count[2] = 1

// Final count:

// [a=1, b=2, c=1, others=0]
