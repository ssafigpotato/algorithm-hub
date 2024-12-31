import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 1. HashMap에 문자열과 최소 횟수 저장
        HashMap <Character, Integer> map = new HashMap<>();
        // 2. keymap배열을 돌면서
        for(int i = 0; i < keymap.length; i++){
            // 먼저 등장하는 문자열의 값을 넣어주고, 
            // 이미 존재하면 새로운 값을 무시 하도록 
            // putIfAbsent사용 <-- 이렇게 하면 다음 keymap의 더 작은 값을 갱신하지 못함!!
            String str = keymap[i];
            for(int j = 0; j <str.length(); j++){
                char v = str.charAt(j);
                // 처음넣는거면 그대로 넣기 
                if(!map.containsKey(v)){
                    map.put(v, j+1);
                }else { 
                    // 이미 넣은 적이 있으면 더 작은 값을 넣기 
                    map.put(v, Math.min(map.get(v), j+1));
                }
            }
        }
        
        int[] answer = new int[targets.length];
        
        // 3. targets배열을 돌면서 
        for(int i = 0; i <targets.length; i++){
            String str = targets[i];
            
            for(int j = 0; j <str.length(); j++){
                char v = str.charAt(j);
                // System.out.println(map.get(v)); <-- 없는 것이 있음
                if(map.containsKey(v)){
                    answer[i] += map.get(v);
                }else {
                    answer[i] = -1; 
                    break;
                }
            }
            
        }
        
        // int[] answer = {};
        return answer;
    }
}