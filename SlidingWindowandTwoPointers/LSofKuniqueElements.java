package SlidingWindowandTwoPointers;

// https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

public class LSofKuniqueElements {
     public int longestKSubstr(String s, int k) {
        int n=s.length();
        int windowStart=0;
        int maxLen=Integer.MIN_VALUE;
        int freqHash[]=new int[26];
        int uniqueCharCount=0;

        for(int windowEnd=0;windowEnd<n;windowEnd++) {
            int index=s.charAt(windowEnd)-'a';

            if(freqHash[index]==0) {
                uniqueCharCount++;
            }
                freqHash[index]++;

            while(uniqueCharCount>k) {
                index=s.charAt(windowStart)-'a';

                freqHash[index]--;

                if(freqHash[index]==0) {
                    uniqueCharCount--;
                }
                windowStart++;
            }
            if(uniqueCharCount==k) {
                maxLen=Math.max(maxLen,windowEnd-windowStart+1);
            }
        }
        if(maxLen==Integer.MIN_VALUE) {
            return -1;
        } else {
            return maxLen;
        }
    }
 }


//  s = "aabacbebebe"
// k = 3

// Initial:

// windowStart = 0
// maxLen = -∞
// uniqueCharCount = 0
// windowEnd = 0 → 'a'
// window = [a]
// unique = 1
// maxLen not updated
// windowEnd = 1 → 'a'
// window = [aa]
// unique = 1
// windowEnd = 2 → 'b'
// window = [aab]
// unique = 2
// windowEnd = 3 → 'a'
// window = [aaba]
// unique = 2
// windowEnd = 4 → 'c'
// window = [aabac]
// unique = 3
// length = 5
// maxLen = 5
// windowEnd = 5 → 'b'
// window = [aabacb]
// unique = 3
// length = 6
// maxLen = 6
// windowEnd = 6 → 'e'

// Now unique becomes 4, which is greater than k.

// Shrink window.

// remove 'a'
// remove 'a'
// remove 'b'
// remove 'a'

// Window becomes:

// window = [cbe]
// unique = 3
// windowEnd = 7 → 'b'
// window = [cbeb]
// length = 4
// windowEnd = 8 → 'e'
// window = [cbebe]
// length = 5
// windowEnd = 9 → 'b'
// window = [cbebeb]
// length = 6
// windowEnd = 10 → 'e'
// window = [cbebebe]
// length = 7
// maxLen = 7
// 3️⃣ Final Result
// Longest substring length = 7
// Substring = "cbebebe"