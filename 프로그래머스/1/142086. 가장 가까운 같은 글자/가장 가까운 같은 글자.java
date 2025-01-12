import java.util.*;
class Solution {
    // HashMap 사용
    // Character와 위치로 저장
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap <Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            // map에 포함되어 잇지 않으면 -1을 return 하고
            // s.charAt(i)와 위치 i를 맵에 넣기 
            if(!map.containsKey(s.charAt(i))){
                answer[i] = -1;
                map.put(s.charAt(i), i); 
            }else {// 포함되어 있으면
                // 위치의 차이를 계산하고 (얼마만큼 앞에 있는지 계산 )
                int idx = i - map.get(s.charAt(i));
                answer[i] = idx;
                map.put(s.charAt(i), i); // 위치 갱신 
            }
        }
        
        return answer;
    }
}