import java.util.*;
class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    public String solution(String[] participant, String[] completion) {
        // map에 참가자 집어넣기 
        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0)+1);
        }
        
        for(String c : completion){
            if(map.containsKey(c)){ // map에 완주한 사람이 포함되어 있으면 
                map.put(c, map.get(c)-1); // 한 명 빼주기 
            }
        }
        
        
        // 문제 조건에 따르면 완주하지 못한 사람은 한명임! 
        String answer = "";
        for(String p : map.keySet()){
            if(map.get(p) >0){
                answer = p;
                // System.out.println(p);
            }
        }
        
        
        
        return answer;
    }
}