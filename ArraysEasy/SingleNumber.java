package ArraysEasy;
import java.util.*;
public class SingleNumber {
    public int singleNum(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            }
            else {
                map.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if(entry.getValue()==1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}

//other method is

// public class SingleNumber {
//     public int singleN(int[] nums) {
//         int result=0;
//         for(int i=0;i<nums.length;i++) {
//             result=result^nums[i];
//         }
//         return result;
//     }
// }

