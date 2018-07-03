package targetsum;

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(Integer i:nums) {
            sum+=i;
        }
        if(S>sum || S<-sum||((S+sum)%2 !=0)) 
            return 0;
        int target = (S+sum)/2;
        int[] res = new int[target+1];
        res[0] = 1;
        for(Integer i : nums) {
            for(int j = target;j>=i;j--) {
                res[j] += res[j-i];
            }
        }
        return res[target];
    }
}
