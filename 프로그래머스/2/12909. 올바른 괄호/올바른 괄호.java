import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack st = new Stack();
        boolean answer;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                st.add(c);
            }else if(c == ')' && !st.isEmpty()){
                st.pop(); 
            }else if(c == ')' && st.isEmpty()){
                st.add(c);
            }
        }
        
        if(st.isEmpty()){
            answer = true; 
        }else {
            answer = false;
        }
        
       

        return answer;
    }
}