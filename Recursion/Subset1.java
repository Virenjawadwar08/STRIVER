package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset1 {
    public static List<Integer> subSet1(int[] nums) {
        List<Integer> result=new ArrayList<>();
        backtrack(result,nums,0,0);
        return result;
    }

    private static void backtrack(List<Integer> result,int[] nums,int sum,int index) {
        if(index==nums.length) {
            result.add(sum);
            return;
        }

        backtrack(result, nums, sum+nums[index], index+1);
        backtrack(result, nums, sum, index+1);
    }
    public static void main(String[] args) {
        int[] nums={2,3};
        System.out.println(subSet1(nums));
    }
}
