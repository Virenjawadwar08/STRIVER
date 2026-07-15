package SlidingWindowandTwoPointers;

public class LRepeatingCharReplac {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;

        for(int right = 0; right < s.length(); right++) {

            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            while((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return maxWindow;
    }
}


// Dry Run
// s = "AABABBA", k = 1

// freq[26], left=0, maxFreq=0, maxWindow=0

// right=0 → 'A'
// freq[A]=1 → maxFreq=1
// window=1 → valid (1-1=0 ≤1)
// maxWindow=1

// right=1 → 'A'
// freq[A]=2 → maxFreq=2
// window=2 → valid (2-2=0 ≤1)
// maxWindow=2

// right=2 → 'B'
// freq[B]=1 → maxFreq=2
// window=3 → valid (3-2=1 ≤1)
// maxWindow=3

// right=3 → 'A'
// freq[A]=3 → maxFreq=3
// window=4 → valid (4-3=1 ≤1)
// maxWindow=4

// right=4 → 'B'
// freq[B]=2 → maxFreq=3
// window=5 → invalid (5-3=2 >1)

// shrink:
// remove 'A' → freq[A]=2, left=1

// window=4 → valid
// maxWindow=4

// right=5 → 'B'
// freq[B]=3 → maxFreq=3
// window=5 → invalid (5-3=2 >1)

// shrink:
// remove 'A' → freq[A]=1, left=2

// window=4 → valid
// maxWindow=4

// right=6 → 'A'
// freq[A]=2 → maxFreq=3
// window=5 → invalid (5-3=2 >1)

// shrink:
// remove 'B' → freq[B]=2, left=3

// window=4 → valid
// maxWindow=4

// Final Answer = 4

//tc-O(n), sc-O(1)