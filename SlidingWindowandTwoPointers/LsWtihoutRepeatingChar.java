package SlidingWindowandTwoPointers;

public class LsWtihoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        int lastIndex[]=new int[128];
        int left=0;
        int maxLen=0;

        for(int right=0;right<s.length();right++) {
            char c=s.charAt(right);

            left=Math.max(left,lastIndex[c]);
            maxLen=Math.max(maxLen,right-left+1);

            lastIndex[c]=right+1;
        }
        return maxLen;
    }
}

//tc-O(n)

// 4️⃣ Step-by-Step Explanation
// right = 0
// c = 'a'
// left = max(0,0) = 0
// length = 1
// maxLen = 1
// lastIndex['a'] = 1

// Window:

// [a]
// right = 1
// c = 'b'
// left = max(0,0) = 0
// length = 2
// maxLen = 2
// lastIndex['b'] = 2

// Window:

// [ab]
// right = 2
// c = 'c'
// left = max(0,0) = 0
// length = 3
// maxLen = 3
// lastIndex['c'] = 3

// Window:

// [abc]
// right = 3
// c = 'a'
// lastIndex['a'] = 1
// left = max(0,1) = 1

// Window becomes:

// [bca]

// length = 3

// right = 4
// c = 'b'
// lastIndex['b'] = 2
// left = max(1,2) = 2

// Window:

// [cab]

// length = 3

// right = 5
// c = 'c'
// lastIndex['c'] = 3
// left = max(2,3) = 3

// Window:

// [abc]
// right = 6
// c = 'b'
// lastIndex['b'] = 5
// left = max(3,5) = 5

// Window:

// [cb]
// right = 7
// c = 'b'
// lastIndex['b'] = 7
// left = max(5,7) = 7

// Window:

// [b]
// 5️⃣ Final Result
// maxLen = 3