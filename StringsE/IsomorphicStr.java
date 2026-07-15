package StringsE;

public class IsomorphicStr {

    // Function to check whether two strings are isomorphic
    public boolean isIsomorphic(String s, String t) {

        // If lengths are different, they cannot be isomorphic
        if (s.length() != t.length()) return false;

        // mapST maps characters from string s to string t
        // mapTS maps characters from string t to string s
        // Size 256 is used to cover all ASCII characters
        int[] mapST = new int[256];
        int[] mapTS = new int[256];

        // Traverse both strings character by character
        for (int i = 0; i < s.length(); i++) {

            // Current characters from both strings
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // If neither character has been mapped yet
            if (mapST[c1] == 0 && mapTS[c2] == 0) {

                // Create a two-way mapping
                mapST[c1] = c2;
                mapTS[c2] = c1;

            } else {
                // If mapping already exists, check consistency
                // If mapping does not match, strings are not isomorphic
                if (mapST[c1] != c2 || mapTS[c2] != c1) {
                    return false;
                }
            }
        }

        // All characters matched consistently
        return true;
    }
}



// Dry Run — s = "egg", t = "add"

// Initial

// mapST = {}
// mapTS = {}

// i = 0
// s[0] = 'e', t[0] = 'a'


// Neither mapped → map them

// mapST: e → a
// mapTS: a → e

// i = 1
// s[1] = 'g', t[1] = 'd'


// Neither mapped → map them

// mapST: g → d
// mapTS: d → g

// i = 2
// s[2] = 'g', t[2] = 'd'


// Already mapped

// Mapping matches → continue

// End

// ✔ All mappings consistent

// ✅ Output
// true


//another approach-

// public class IsomorphicStr {
//     public boolean isIsomorphic(String s, String t) {
//         return helper(s).equals(helper(t));
//     }

//     private String helper(String str) {
//         Map<Character, Integer> map=new HashMap<>();

//         StringBuilder sb=new StringBuilder();

//         for(int i=0;i<str.length();i++) {
//             char ch=str.charAt(i);
//             if(!map.containsKey(ch)) {
//                 map.put(ch,i);
//             }
//             sb.append(Integer.toString(map.get(ch)));
//             sb.append("-");
//         }
//         return sb.toString();
//     }
// }