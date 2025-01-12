import java.util.*;
class Solution {
    // 처음에는 부분수열이라 생각했는데, 그게 아닌듯
    // 슬라이딩 윈도우를 써야할듯
    public int solution(String t, String p) {
        int answer = 0;
        int pLen = p.length();
        // 부분수열은 0으로 시작해도 되긴하지만 숫자로 변환했을 때 0이 된 자리는 빼고 변환
        
        
        for(int i = 0; i <= t.length()-pLen; i++) { // -pLen이라는 범위 넣어줘야 밑의 for j에서 outofIndex 에러 안 뜸!! 
            
            String curr = Character.toString(t.charAt(i));
            // System.out.println(curr);
            
            // substr로 추출해도 되겠다! 
            for(int j = i+1; j < i + pLen; j++){
                curr += t.charAt(j);    
            }
            
            // System.out.println(curr);  
            // 만약 cur이 0023이런거면 Integer.parseInt("0023") 했을 때 23으로 잘 변환됨! 
            // Long 해줘야함!!!! 
            if(Long.parseLong(curr) <= Long.parseLong(p)) answer++;
            
        }
        
        return answer;
        
    }
}