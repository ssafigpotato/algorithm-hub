import java.util.*; 

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        
        // String [] arr = my_string.split("");
        // String [] over_arr = overwrite_string.split("");
        
        // for(int i = s; i < over_arr.length; i++){
        //     arr[i] = over_arr[i];
        // }
        // String.join("",arr);
        int len = overwrite_string.length();
        String answer =  my_string.substring(0, s) + overwrite_string + my_string.substring(s+len);
     
        return answer;
    }
}
