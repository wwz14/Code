import java.util.*;
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Map<Integer,Integer> index = new HashMap<Integer,Integer>();
        
        for(int i = 0;i<nums.length;i++) {
            if(index.containsKey(nums[i])) {
                int diff = i-index.get(nums[i]);
                if(diff <= k)
                    return true;
                else {
                    index.put(nums[i],i);
                }
            }else {
                index.put(nums[i],i);
            }
        }
        return false;
    }
}
