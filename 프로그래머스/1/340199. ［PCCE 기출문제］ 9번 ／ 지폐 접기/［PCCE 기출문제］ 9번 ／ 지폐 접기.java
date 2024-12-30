import java.util.*;
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        // 1. 오름차순으로 정렬 
        // Arrays.sort(bill);
        Arrays.sort(wallet);
        
        while(true){
            // 2-1. bill[0], bill[1] 중에 크고 작은 것 구별
            int small_b = Math.min(bill[0], bill[1]);
            int big_b = Math.max(bill[0], bill[1]);
            
            // 2-2. 작은 것 <= wallet[0] 이고, 큰것 <= wallet[1] 이면 종료
            // wallet은 오름차순으로 정렬해놨으므로 항상 wallet[0] <= wallet[1]
            if(small_b <= wallet[0] && big_b <= wallet[1]) break;
       
            // 2-3. 그렇지 않으면 둘 중 큰 것을 반으로 접기 
            if(bill[0] >= bill[1] ){
                bill[0] /=2;
            }else {
                bill[1] /=2;
            }
            
            // 2-4. 접은 횟수++
            answer++;
        }
        
        return answer;
    }
}