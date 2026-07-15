package StringsE;

//optimal-

public class ReverseWords {
    public String reverseWords(String s) {
        String[] words=s.trim().split("\\s+");
        StringBuilder sb=new StringBuilder();

        for(int i=words.length-1;i>=0;i--) {
            sb.append(words[i]);
            if(i!=0) sb.append(" ");
        }
        return sb.toString();
    }
}


//not optimal -
// public class ReverseWords {
//     public String reverseW(String s) {
//         if(s.equals(null) || s.equals("")) {
//             return s;
//         }
//         String ret="";
//         int i=0;
//         while(i<s.length()) {
//             while(i<s.length() && s.charAt(i)==' ') {
//                 i++;
//             }
//             String w="";
//             while(i<s.length() && s.charAt(i)!=' ') {
//                 w+=s.charAt(i);
//                 i++;
//             }
//             if(!w.equals("")) {
//                 ret=w+" "+ret;
//             }
//         }
//         if(ret.isEmpty()) {
//             return "";
//         }
//         return ret.substring(0,ret.length()-1);
//     }
// }


// 1️⃣ s.trim()

// trim() removes extra spaces at the beginning and end of the string.

// Example:

// String s = "   hello world   ";

// After trim():

// "hello world"

// Leading and trailing spaces are removed.

// 2️⃣ .split()

// split() divides a string into parts and returns an array of strings.

// Example:

// String s = "hello world";
// String[] words = s.split(" ");

// Result:

// ["hello", "world"]
// 3️⃣ "\\s+"

// This is a regular expression.

// Meaning:

// \s  → whitespace character
// +   → one or more times

// So:

// "\\s+" → one or more spaces

// Examples it matches:

// " "
// "   "
// "\t"
// "\n"