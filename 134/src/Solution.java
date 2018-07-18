
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        for(int i = 0;i<gas.length;i++) {
            // possible start point
            if(gas[i] >= cost[i]) {
                int left = 0;
                boolean ispos = true;
                for(int j = i;j<i+gas.length;j++) {
                     left += gas[j%gas.length] - cost[j%gas.length];
                     if(left < 0){
                         ispos = false;
                           break;
                     }     
                }
                if(ispos) {
                    return i;
                }
                
            }
        }
        
        return -1;
    }
}