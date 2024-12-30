import java.util.*; 
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        // 1. 시간 초과 대비를 위해 Map사용 
        HashMap<String, Integer> map = new HashMap<>();
        int id = 0; 
        for(String p : players){
            map.put(p, id++); 
        }
        // 2. callings배열을 돌면서 순서 변경 
        for(String c : callings){
            // 불릴 때마다 자기 앞 순서인 사람과 자리를 바꿈 <-- 시간 초과 
            // for(int i = 0; i < players.length; i++){
            //     if(c.equals(players[i])){
            //         String curr = players[i];
            //         players[i] = players[i-1];
            //         players[i-1] = curr;
            //     }
            // }
            
            // 2-1. 불린 사람의 순서 찾기 
            int i = map.get(c); // 불린 사람 현 위치 
            int prev_i = i-1; // 앞 사람 위치 
            
            // 2-2. 배열에서 순서 바꾸기 
            String curr = players[i];
            players[i] = players[prev_i];
            players[prev_i] = curr;
            
            // System.out.println(players[prev_i]+" "+players[i]);
            
            // 2-3. Map 도 업데이트 해줘야함!!
            // 이미 poe -> kai 에서 kai -> poe로 바뀌었음!
            // 이미 players[i]가 자리에 이전 사람이 왓으므로, 
            // map에도 자기 순서를 넣어줘야함!
            // map.put(players[i], prev_i)가 아님!!!
            // 
            // 자리 교환이 이루어진 후, players[i]와 players[prev_i]는 이미 새 위치로 바뀌어 있습니다.
            // 따라서, map에서 갱신할 때:
            // players[i] → 현재 위치인 i.
            // players[prev_i] → 이전 위치인 prev_i.
            map.put(players[i], i);
            map.put(players[prev_i], prev_i);
        }
        return players;
    }
}