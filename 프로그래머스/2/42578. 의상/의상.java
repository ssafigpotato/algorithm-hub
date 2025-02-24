// import java.util.*;
// class Solution {
//     // <의상종류, 의상이름리스트> 
//     static HashMap<String, List<String>> map = new HashMap<>(); 
//     public int solution(String[][] clothes) {
//         for(int i = 0; i < clothes.length; i++){
//             map.putIfAbsent(clothes[i][1], new ArrayList<>());
//             map.get(clothes[i][1]).add(clothes[i][0]);
//         }
        
//         int answer = 0;
//         return answer;
//     }
// }
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>(); 
        
        // 1. 의상 종류별 개수 저장
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        
        // 2. 조합의 개수 계산
        // 수학에서 모자가 2개 있을 때 이 모자를 선택하는 경우는 2+1(선택하지 않는 경우 ) 총 3개
        // 모자, 상의, 하의... 이것들은 다 독립적이므로 곱하기로 경우의 수를 구함 
        int answer = 1; // 곱셈을 위해 초기값 1
        for (int count : map.values()) {
            answer *= (count + 1); // (해당 종류의 개수 + 1(선택안하는경우)) 곱하기 
        }
        
        return answer - 1; // 모든 의상을 착용하지 않는 경우(공집합) 제외
    }
}
