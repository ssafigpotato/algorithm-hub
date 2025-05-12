import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int a = 0; 
        int b = 0;
        
        for(int i = 0; i < sizes.length; i++){
            // 가로 세로 중 큰 것과 작은 것을 구별 
            int l = Math.max(sizes[i][0], sizes[i][1]);
            int s = Math.min(sizes[i][0], sizes[i][1]);
       
            // 그 중에서 가장 큰 값으로 각각 갱신 
            a = Math.max(a, l);
            b = Math.max(b, s); 
        
        }
        
        int answer = a*b;
        
        return answer;
    }
}