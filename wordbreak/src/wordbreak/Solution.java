package wordbreak;

import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int i = 1;i<s.length()+1;i++) {
            for(String str:wordDict) {
                if(i>=str.length()) {
                    if(res[i-str.length()]&&str.equals(s.substring(i-str.length(),i))){
                        res[i] = true;
                    }
                }
            }
        }
        return res[s.length()];
    }
}
