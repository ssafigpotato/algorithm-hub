import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 둘 다 해시맵에 각각 넣어서 검색하기 -> 검색 효율 좋음
        HashMap<String, Integer> map1 = new HashMap<>();
        for(int i = 0; i < cards1.length; i++){
            map1.put(cards1[i], i+1);
        }
        HashMap<String,Integer> map2 = new HashMap<>();
        for(int i = 0; i < cards2.length; i++){
            map2.put(cards2[i], i+1);
        }
        
        // 2. goal을 돌면서 map1 / map2에서 해당단어를 가지고 있는지 검색
        int cnt1 = 0; // 순서를 지키기위한 flag
        int cnt2 = 0;
        for(int i = 0; i < goal.length; i++){
            // 예외) map1,2 둘 다 가지고 있지 않을 때 
            if(!map1.containsKey(goal[i]) && !map2.containsKey(goal[i])){
                return "No";
            }
           
            
            if(map1.containsKey(goal[i])){
                // 예외처리) 단순 <가 아니라 
                // 사용하지 않고 넘어가는 것도 No임 
                if(cnt1 + 1 ==  map1.get(goal[i])){ // cnt1이 현재의 goal[i]보다 작아야 순서가 지켜진 것임
                    cnt1 = map1.get(goal[i]);
                    // System.out.println("현재 cnt1: "+cnt1+"값: "+goal[i]);
                }else {
                    return "No";
                }
               
            }else if (map2.containsKey(goal[i])){
                if(cnt2 + 1 ==  map2.get(goal[i])){
                    cnt2 = map2.get(goal[i]);
                    // System.out.println("현재 cnt2: "+cnt2+"값: "+goal[i]);
                }else {
                    return "No";
                }  
            } 
        }
        
        String answer = "Yes";
        return answer;
    }
}