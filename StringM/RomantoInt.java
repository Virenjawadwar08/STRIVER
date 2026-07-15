import java.util.*;

public class RomantoInt {
   public int romanToInt(String s) {
    Map<Character,Integer> map=new HashMap<>();
    map.put('I',1);
    map.put('V',5);
    map.put('X',10);
    map.put('L',50);
    map.put('C',100);
    map.put('D',500);
    map.put('M',1000);

    char chars[]=s.toCharArray();
    int result=0;
    int i,j;

    for(i=0,j=1;j<chars.length;i++,j++) {
        if(map.get(chars[i])>=map.get(chars[j])) {
            result+=map.get(chars[i]);
        }
        else {
            result-=map.get(chars[i]);
        }
    }
    result +=map.get(chars[i]);
    return result;
   }
}

// DRY RUN (STEP-BY-STEP)
// Example Input
// s = "MCMIV"

// Character array
// chars = ['M','C','M','I','V']


// | i | j | chars[i] | chars[j] | Comparison | Action | result |
// | - | - | -------- | -------- | ---------- | ------ | ------ |
// | 0 | 1 | M(1000)  | C(100)   | 1000 ≥ 100 | +1000  | 1000   |
// | 1 | 2 | C(100)   | M(1000)  | 100 < 1000 | −100   | 900    |
// | 2 | 3 | M(1000)  | I(1)     | 1000 ≥ 1   | +1000  | 1900   |
// | 3 | 4 | I(1)     | V(5)     | 1 < 5      | −1     | 1899   |


// After loop ends
// result += map.get(chars[i]); // i = 4 → 'V'

// result = 1899 + 5 = 1904

// ✅ Final Output
// 1904

// Time: O(n)
// Space: O(1)


//optimal approach

class Solution {
    public int romanToInt(String s) {
        int result=0;
        for(int i=0;i<s.length();i++) {
            int curr=value(s.charAt(i));

            if(i+1<s.length() && curr<value(s.charAt(i+1))) {
                result-=curr;
            } else {
                result+=curr;
            }
        }
        return result;
    }

    private int value(char c) {
        switch(c) {
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;

        }
        return 0;
    }
}