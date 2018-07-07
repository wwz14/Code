package no47;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if(nums == null || nums.length == 0)
            return new ArrayList<>(result);

        doPermute(nums, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    private void doPermute(int[] nums, int index, List<Integer> temp, Set<List<Integer>> result){
        if(index == nums.length) {
            result.add(temp);
            return;
        }

        for(int i = index; i < nums.length; i++){
            List<Integer> copy = new ArrayList<>(temp);

            if(i == index){
//                if(i == 0 || nums[i] != nums[i-1]) {
                    copy.add(nums[i]);
                    doPermute(nums, index + 1, copy, result);
//                }
            }else {
                int[] numsCopy = new int[nums.length];
                System.arraycopy(nums, 0, numsCopy, 0, nums.length);
                copy.add(nums[i]);
                swap(numsCopy, i, index);
                doPermute(numsCopy, index + 1, copy, result);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

  
}