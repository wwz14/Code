
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0'?0:1;
        
        for(int i = 2;i<=s.length();i++) {
            int first = Integer.parseInt(s.substring(i-1,i));
            int second = Integer.parseInt(s.substring(i-2,i));
            if(1<=first && 9>=first) {
                dp[i] +=dp[i-1];
            }
            if(10<=second && 26>=second) {
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];
    }
}