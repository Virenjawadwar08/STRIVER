public class SumOfBeauty {
    public int beautySum(String s) {
        int n=s.length();
        int ans=0;

        for(int i=0;i<n;i++) {
            int freq[]=new int[26];

            for(int j=i;j<n;j++) {
                freq[s.charAt(j)-'a']++;

                int max=0;
                int min=Integer.MIN_VALUE;

                for(int k=0;k<26;k++) {
                    if(freq[k]>0) {
                        max=Math.max(max,freq[k]);

                        min=Math.min(min,freq[k]);
                    }
                }
                ans+=max-min;
            }
        }
        return ans;
    }
}

// Dry Run
// Input: s = "aabcb"

// Beauty = max frequency − min frequency

// i = 0
// j=0 → "a"     freq: a=1       max=1 min=1 beauty=0  ans=0
// j=1 → "aa"    freq: a=2       max=2 min=2 beauty=0  ans=0
// j=2 → "aab"   freq: a=2 b=1   max=2 min=1 beauty=1  ans=1
// j=3 → "aabc"  freq: a=2 b=1 c=1 max=2 min=1 beauty=1 ans=2
// j=4 → "aabcb" freq: a=2 b=2 c=1 max=2 min=1 beauty=1 ans=3

// i = 1
// j=1 → "a"     freq: a=1       max=1 min=1 beauty=0  ans=3
// j=2 → "ab"    freq: a=1 b=1   max=1 min=1 beauty=0  ans=3
// j=3 → "abc"   freq: a=1 b=1 c=1 max=1 min=1 beauty=0 ans=3
// j=4 → "abcb"  freq: a=1 b=2 c=1 max=2 min=1 beauty=1 ans=4

// i = 2
// j=2 → "b"     freq: b=1       beauty=0 ans=4
// j=3 → "bc"    freq: b=1 c=1   beauty=0 ans=4
// j=4 → "bcb"   freq: b=2 c=1   max=2 min=1 beauty=1 ans=5

// i = 3
// j=3 → "c"     beauty=0 ans=5
// j=4 → "cb"    beauty=0 ans=5

// i = 4
// j=4 → "b"     beauty=0 ans=5

// Final Output = 5