
public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<>();
        if(digits == null || digits.length() == 0)
            return queue;
        String[] map = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        queue.add("");
        while(queue.peek().length() != digits.length()) {
            String remove = queue.remove();
            String chars = map[digits.charAt(remove.length())-'0'];
            for(char c:chars.toCharArray()) {
                queue.addLast(remove+c);
            }
        }
        
        return queue;
    }
}
