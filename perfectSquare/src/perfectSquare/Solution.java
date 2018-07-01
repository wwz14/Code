package perfectSquare;

import java.util.Arrays;

public class Solution {
    public int numSquares(int n) {
        
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        for(int i = 2;i<n+1;i++) {
            res[i] = Integer.MAX_VALUE;
            for(int j = 1;i-j*j>=0;j++){
                res[i] = Math.min(res[i],res[i-j*j]+1);
            }
        }
        
        return res[n];
        
    }
}
