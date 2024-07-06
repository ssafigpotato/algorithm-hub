import java.util.*; 
class Solution {
    public int solution(int a, int b) {
        int ans = 0;
        // char ans = (char)(a+'0') + (char)(b+'0');
        String a_str = "" + a;
        String b_str = "" + b;
        
        int sum1 = Integer.parseInt(a_str + b_str);
        int sum2 = Integer.parseInt(b_str + a_str);
        
        if(sum1 > sum2) {
            ans = sum1;
        }else {
            ans = sum2;
        }
        
        return ans;
    }
}