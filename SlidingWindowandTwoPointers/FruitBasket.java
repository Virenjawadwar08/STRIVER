package SlidingWindowandTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class FruitBasket {
     public int totalFruits(int[] fruits) {
        int left=0;
        int maxLen=0;

        Map<Integer,Integer> map=new HashMap<>();
        for(int right=0;right<fruits.length;right++) {
            map.put(fruits[right],map.getOrDefault(fruits[right], 0)+1);

            while(map.size()>2) {
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left])==0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
     }
}


// 🔥 Example for Dry Run
// fruits = [1,2,1,2,3,2,2]
// 🔹 Initial State
// left = 0
// maxLen = 0
// map = {}
// 🔹 Step-by-Step Dry Run
// 👉 right = 0 → fruits[0] = 1
// map = {1:1}
// size = 1 ✅
// window = [1]
// maxLen = 1
// 👉 right = 1 → fruits[1] = 2
// map = {1:1, 2:1}
// size = 2 ✅
// window = [1,2]
// maxLen = 2
// 👉 right = 2 → fruits[2] = 1
// map = {1:2, 2:1}
// size = 2 ✅
// window = [1,2,1]
// maxLen = 3
// 👉 right = 3 → fruits[3] = 2
// map = {1:2, 2:2}
// size = 2 ✅
// window = [1,2,1,2]
// maxLen = 4
// 👉 right = 4 → fruits[4] = 3
// map = {1:2, 2:2, 3:1}
// size = 3 ❌ (more than 2 types)
// ⚠️ Shrink window:
// left = 0 → fruit = 1
// map = {1:1, 2:2, 3:1}
// size still 3 → continue
// left = 1 → fruit = 2
// map = {1:1, 2:1, 3:1}
// size still 3 → continue
// left = 2 → fruit = 1
// map = {1:0, 2:1, 3:1}
// remove 1 → map = {2:1, 3:1}
// size = 2 ✅

// 👉 Now:

// left = 3
// window = [2,3]
// maxLen still = 4
// 👉 right = 5 → fruits[5] = 2
// map = {2:2, 3:1}
// size = 2 ✅
// window = [2,3,2]
// maxLen = 4
// 👉 right = 6 → fruits[6] = 2
// map = {2:3, 3:1}
// window = [2,3,2,2]
// maxLen = 4
// ✅ Final Answer
// maxLen = 4