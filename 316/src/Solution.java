
public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s.length() == 0)
            return "";
        int[] frequency = new int[26];
        for(char c:s.toCharArray()) {
            frequency[c-'a']++;
        }
        
        int pos = 0;
        for(int i = 0;i<s.length();i++) {
            if(s.charAt(i) < s.charAt(pos))
                pos = i;
            
            if(--frequency[s.charAt(i)-'a'] == 0)
                break;
        }
        
        return s.charAt(pos)+removeDuplicateLetters(s.substring(pos+1,s.length()).replaceAll(s.charAt(pos)+"",""));
        
    }
}
