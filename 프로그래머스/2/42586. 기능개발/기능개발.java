import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[]days = new int[progresses.length];
        
        for(int i = 0; i < progresses.length; i++){
            days[i] = (int) Math.ceil((double) (100-progresses[i]) / speeds[i]);
        }
        System.out.println(Arrays.toString(days));
        
        TreeMap<Integer, Integer> map = new TreeMap<>(); // 키 기준 오름차순
        int curr = days[0];
        for(int i = 0; i < days.length; i++){
            if(curr >= days[i]){
                map.put(curr, map.getOrDefault(curr, 0)+1);
                // map.put(days[i], map.getOrDefault(days[i], 0)+1);
                // curr = days[i]; // 더 큰 값으로 갱신 
            }else{
                map.put(days[i], map.getOrDefault(days[i], 0)+1);
                curr = days[i];
                //map.put(curr, map.getOrDefault(curr, 0)+1);
            }
        }
        List<Integer>list = new ArrayList<>();
        int[] answer = new int[map.size()];
        for(int key : map.keySet()){
            // System.out.println(key+" "+map.get(key));
            list.add(map.get(key));
        }
        for(int i= 0; i <list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}