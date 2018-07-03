package parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        gender(res,"",0,0,n);
        return res;
        
    }
    
    public void gender(List<String> res,String str, int open,int close,int n) {
        if(str.length() == 2*n) {
            res.add(str);
            return;
        }
        
        if(open < n) {
            gender(res,str+"(",open+1,close,n);
        }
        
        if(close < open) {
            gender(res,str+")",open,close+1,n);
        }
            
    }
}
