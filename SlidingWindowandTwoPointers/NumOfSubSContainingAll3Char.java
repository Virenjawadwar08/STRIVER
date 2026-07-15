package SlidingWindowandTwoPointers;

public class NumOfSubSContainingAll3Char {
  public int numberOfSubstrings(String s) {
     int[] freq=new int[3];
     int start=0,ans=0;
     for(int end=0;end<s.length();end++) {
        freq[s.charAt(end)-'a']++;
        while(freq[0]>=1 && freq[1]>=1 && freq[2]>=1) {
            ans+=(s.length()-end);
            freq[s.charAt(start)-'a']--;
            start++;
        }
     } 
     return ans;  
    } 
}


// Dry Run
// s = "abcabc"

// start=0, ans=0, freq=[0,0,0]

// end=0 → 'a'
// freq=[1,0,0] → not valid

// end=1 → 'b'
// freq=[1,1,0] → not valid

// end=2 → 'c'
// freq=[1,1,1] → valid

// ans += (6-2)=4 → ans=4

// shrink:
// remove 'a' → freq=[0,1,1], start=1

// --------------------------------

// end=3 → 'a'
// freq=[1,1,1] → valid

// ans += (6-3)=3 → ans=7

// shrink:
// remove 'b' → freq=[1,0,1], start=2

// --------------------------------

// end=4 → 'b'
// freq=[1,1,1] → valid

// ans += (6-4)=2 → ans=9

// shrink:
// remove 'c' → freq=[1,1,0], start=3

// --------------------------------

// end=5 → 'c'
// freq=[1,1,1] → valid

// ans += (6-5)=1 → ans=10

// shrink:
// remove 'a' → freq=[0,1,1], start=4

// --------------------------------

// Final Answer = 10

//tc-O(n) , sc-O(n)