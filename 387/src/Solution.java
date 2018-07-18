
public class Solution {
    public int firstUniqChar(String s) {
        int[] frequency = new int[26];
       for(char c:s.toCharArray()) {
           frequency[c-'a']++;
       }
       
       for(int i = 0 ;i<s.length();i++) {
           char c = s.charAt(i);
           if(frequency[c-'a'] == 1)
               return i;
       }
       return -1;
   }
}
