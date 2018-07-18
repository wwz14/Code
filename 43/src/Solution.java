
public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m+n];
      
        for(int i = m-1;i>=0;i--) {
            for(int j = n-1;j>=0;j--) {
                int sum = (num1.charAt(i)-'0')*(num2.charAt(j)-'0') + pos[i+j+1];
                pos[i+j] += sum/10;
                pos[i+j+1] = sum%10;    
            }
        }
        String res = "";
        for(int i : pos) {
            if(!(i==0&&res.length() == 0))
                res += i+"";
        }
        
        return res.length() == 0?"0":res;
    }
}
