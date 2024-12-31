import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 1. HashMap에 name과 그리움점수 담기 
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i <name.length; i++){
            map.put(name[i], yearning[i]);
        }
        // 2. 그리움을 담을 배열 
        int[]total = new int[photo.length];
        
        // 3. photo 배열을 돌면서 
        for(int i = 0; i <photo.length; i++){
            // System.out.println(Arrays.toString(photo[i]));
            int s = 0; 
            for(int j = 0; j <photo[i].length; j++){
                if(map.containsKey(photo[i][j])){
                    s += map.get(photo[i][j]); 
                } // if 안해보고 그냥 getOrDefault해도 되겠다.
            }
            total[i] = s;
        }
    
        
        // int[] answer = {};
        return total;
    }
}