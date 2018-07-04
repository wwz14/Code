package vp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
    
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> Parentheses = new HashMap<>();
        Parentheses.put(')','(');
        Parentheses.put(']','[');
        Parentheses.put('}','{');
        for(char c:s.toCharArray()) {
            if(c == '(' ||c == '['||c=='{'){
                stack.push(c);
            }else if(c==')'||c == ']'||c=='}') {
                if(stack.isEmpty() || !stack.peek().equals(Parentheses.get(c))){
                    return false;
                }else {
                    stack.pop();
                }
            }
        }
        
        return stack.isEmpty();
    }
}
