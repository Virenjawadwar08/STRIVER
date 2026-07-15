// import java.util.*;
// public class MajorityElement {
//     public int majority(int[] nums) {
//         Map<Integer,Integer> map=new HashMap<>();
//         for(int i=0;i<nums.length;i++) {
//             if(map.containsKey(nums[i])) {
//                 map.put(nums[i],map.get(nums[i])+1);
//             }
//             else {
//                 map.put(nums[i],1);
//             }
//         }
//         int majority=(nums.length)/2;
//         int result=0;
//         for(Map.Entry<Integer,Integer> e:map.entrySet()) {
//             if(e.getValue()>majority) {
//                 result=e.getKey();
//             }
//         }
//         return result;
//     }
// }
package ArraysEasy;
public class MajorityElement {
    public int majority(int[] nums) {
        int candidate=0;
        int count=0;

        for(int i=0;i<nums.length;i++) {
            int num=nums[i];

            if(count==0) {
                candidate=num;
            }
            if(num==candidate) {
                count++;
            }
            else {
                count--;
            }
        }
        return candidate;
    }
}