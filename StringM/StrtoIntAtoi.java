public class StrtoIntAtoi {
    public int myAtoi(String s) {
        if(s==null || s.length()==0) {
            return 0;
        }

        int i=0,n=s.length();
        int sign=1;
        long result=0;

        //1.skip leading whitespaces
        if(i<n && s.charAt(i)==' ') {
            i++;
        }

        //2. Check sign
        if(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-')) {
            sign=(s.charAt(i)=='-')?-1:1;
            i++;
        }

        //3.Convert Digts

        while(i<n && Character.isDigit(s.charAt(i))) {
            result=result*10+(s.charAt(i)-'0');

            //4. Clamp overflow
            if(sign*result>Integer.MAX_VALUE) return Integer.MAX_VALUE;

            if(sign*result<Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }
        return (int)(sign*result);
    }    
}

// Time: O(n)
// Space: O(1)

// Input
// "   -042"

// Step-by-step
// Skip spaces
// i moves from 0 → 3

// Detect sign
// s[3] = '-'
// sign = -1
// i = 4

// Convert digits
// s[4] = '0' → result = 0
// s[5] = '4' → result = 4
// s[6] = '2' → result = 42

// Stop (next char is end)
// Apply sign
// -1 × 42 = -42

// ✅ Final Output
// -42


// 🔹 2️⃣ Why (int) casting?

// In the recursive solution, we usually store result as:

// long result = 0;

// Why long?

// 👉 To safely detect overflow before it exceeds int range.

// Remember:

// int range → -2^31 to 2^31 - 1

// long has a much bigger range