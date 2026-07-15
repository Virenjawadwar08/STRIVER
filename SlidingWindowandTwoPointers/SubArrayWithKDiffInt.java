package SlidingWindowandTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDiffInt {
   public int subarraysWithKDistinct(int[] nums, int k) {
    return findAtMostK(nums, k)-findAtMostK(nums, k-1);
   }

   private int findAtMostK(int[] nums,int k) {
    Map<Integer,Integer> map=new HashMap<>();
    int count=0;
    int left=0;

    for(int right=0;right<nums.length;right++) {
        map.put(nums[right],map.getOrDefault(nums[right],0)+1);

        while(map.size()>k) {
            map.put(nums[left],map.get(nums[left])-1);

            if(map.get(nums[left])==0) {
                map.remove(nums[left]);
            }
            left++;
        }
        count+=(right-left+1);
    }
    return count;
   }
}


// Dry Run
// nums = [1,2,1,2,3], k = 2

// We compute:
// exactly(k) = atMost(2) - atMost(1)

// -----------------------------------
// findAtMostK(nums, 2)

// left=0, count=0, map={}

// right=0 → 1
// map={1:1}
// count +=1 → 1

// right=1 → 2
// map={1:1,2:1}
// count +=2 → 3

// right=2 → 1
// map={1:2,2:1}
// count +=3 → 6

// right=3 → 2
// map={1:2,2:2}
// count +=4 → 10

// right=4 → 3
// map={1:2,2:2,3:1} → size=3 > 2

// shrink:
// left=0 → reduce 1 → map={1:1,2:2,3:1}
// left=1 → reduce 2 → map={1:1,2:1,3:1}
// left=2 → reduce 1 → map={2:1,3:1}

// count +=2 → 12

// atMost(2) = 12

// -----------------------------------
// findAtMostK(nums, 1)

// left=0, count=0, map={}

// right=0 → 1
// map={1:1}
// count +=1 → 1

// right=1 → 2
// map={1:1,2:1} → size=2 > 1

// shrink:
// left=0 → remove 1 → map={2:1}

// count +=1 → 2

// right=2 → 1
// map={2:1,1:1} → size=2 > 1

// shrink:
// left=1 → remove 2 → map={1:1}

// count +=1 → 3

// right=3 → 2
// map={1:1,2:1} → size=2 > 1

// shrink:
// left=2 → remove 1 → map={2:1}

// count +=1 → 4

// right=4 → 3
// map={2:1,3:1} → size=2 > 1

// shrink:
// left=3 → remove 2 → map={3:1}

// count +=1 → 5

// atMost(1) = 5

// -----------------------------------
// Final Answer:

// exactly(2) = 12 - 5 = 7