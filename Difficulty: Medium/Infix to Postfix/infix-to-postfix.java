import java.util.*;

class Solution {
    public static int precedence(char c){
        if(c == '+' || c == '-') return 1;
        if(c == '*' || c == '/') return 2;
        if(c == '^') return 3;
        return -1;
    }
    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
            else if(c == '('){
                st.push(c);
            }
            else if(c == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    sb.append(st.pop());
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && 
                      (precedence(st.peek()) > precedence(c) ||
                      (precedence(st.peek()) == precedence(c) && c != '^'))){
                    
                    sb.append(st.pop());
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }
}