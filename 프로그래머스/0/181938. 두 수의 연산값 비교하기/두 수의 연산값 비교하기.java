import java.util.*; 

class Solution {
    public int solution(int a, int b) {
    
        int answer = 0;
        
        String a_str = "" + a;
        String b_str = "" + b;
        
        int sum = Integer.parseInt(a_str + b_str);
        int mul = 2*a*b;
        
        answer = Math.max(sum, mul);
        
        return answer;
    }
}