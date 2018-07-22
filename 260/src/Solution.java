
public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        
        int diff = 0;
        
        for(int i:nums) {
            diff^=i;
        }
        
        diff&=-diff;
        
        for(int i : nums) {
            if((i&diff) == 0) 
                res[0]^=i;
            else
                res[1]^=i;
        }
        return res;
    }
}
