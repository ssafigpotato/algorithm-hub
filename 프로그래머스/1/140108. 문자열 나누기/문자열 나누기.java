import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int idx = 0; // 각 구간의 첫번째 글자의 idx
       
        
        while(idx < s.length()){ // 각 구간 첫번째 글자가 s범위 내에 위치하는 동안
            answer++; // 구간 개수++

            char x = s.charAt(idx); // 각 구간의 제일 첫번째 글자 
            int same = 0; // 구간마다 same,diff는 초기화 
            int diff = 0;
            boolean flag = false; // 무한루프에 빠지지 않기 위한 장치 
            
            for(int j = idx; j < s.length(); j++){ // 각 구간 첫 글자부터 끝까지 순회하면서 
                if(s.charAt(j) == x){
                    same++;
                }else {
                    diff++;
                }    

                if(same == diff){ // 숫자가 같아지면 바로 탈출하고, 구간 끊기 
                    idx = j+1; // 다음 구간의 첫 글자 위치 
                    flag = true; // same == diff가 있을 경우 flag가 true 
                    break;
                }
            }
            
            // 중요!!!!) same == diff로 탈출한 것이 아닌, 
            // 그저 끝까지 다 돌았기 때문에 for를 탈출한 경우:
            // 즉, 나머지 문자들이 남아 있을 경우 
            if(!flag) {
                break;
            }
            
        }
        
        return answer;
    }
}