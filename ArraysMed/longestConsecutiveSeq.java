package ArraysMed;
import java.util.*;
public class longestConsecutiveSeq {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;

        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++) {
            set.add(nums[i]);
        }
        int maxLen=0;
        for(Integer element:set) {
            int prevEl=element-1;
            if(!set.contains(prevEl)) {
                int len=1;
                int nextEl=element+1;

                while(set.contains(nextEl)) {
                    len++;
                    nextEl++;
                }
                maxLen=Math.max(maxLen,len);
            }
        }
        return maxLen;
    }
}

// Short & concise dry run

// Input:
// nums = [100, 4, 200, 1, 3, 2]

// Set:
// {1, 2, 3, 4, 100, 200}

// 100 → 99 not in set → start
// length = 1 → maxLen = 1

// 4 → 3 in set → skip

// 200 → 199 not in set → start
// length = 1 → maxLen = 1

// 1 → 0 not in set → start
// 1 → 2 → 3 → 4 (exists)
// length = 4 → maxLen = 4

// 3 → 2 in set → skip

// 2 → 1 in set → skip