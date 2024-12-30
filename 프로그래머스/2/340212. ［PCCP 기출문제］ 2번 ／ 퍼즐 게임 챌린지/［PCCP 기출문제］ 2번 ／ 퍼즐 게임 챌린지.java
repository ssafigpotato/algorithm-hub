import java.util.*; 

class Solution {
    // 특정 숙련도로 제한 시간 내 퍼즐 해결 가능한지 확인
    public boolean check (int[]diffs, int[]times, long limit, int skill ){
       
        // limit이 long이므로 sum도 long!
        long sum = 0; // 총 시간 
        
        for(int i = 0; i < diffs.length; i++){
            if(diffs[i] <= skill){
                sum += times[i];
            }else {
                 
                int c = diffs[i] - skill;
                
                if (i == 0) {
                    // 첫 번째 퍼즐은 이전 퍼즐의 시간이 없음
                    sum += (long) c * times[i] + times[i];
                } else {
                    // 이후 퍼즐은 이전 퍼즐 시간 포함
                    sum += (long) c * (times[i - 1] + times[i]) + times[i];
                }
               
                // 이것만 하면 첫번째 퍼즐일 때 예외 놓침!!
                // sum += (long)((times[i-1]+times[i]) * c) + times[i];
            }
            
            // 연산 중간에라도 sum이 limit을 초과하면 바로 false 
            if(sum > limit) return false;
        }
        
        return true; 
    }
  
    // 최소 숙련도 찾기 
    public int solution(int[] diffs, int[] times, long limit) {
       
        // 1. diffs 오름차순으로 정렬  <-- 이거 할 필요 없음. 왜냐? diffs내에서 숙련도 찾는것이 아니니까!!!
        // int[]d_clone = diffs.clone();
        // Arrays.sort(d_clone);
        
        // 2. 최대/ 최소 숙련도
        // 1<= diffs <= 100000 이므로 
        // 숙련도도 그 사이!
        int left = 1;  // 최소 
        int right = 100000; // 최대 --> Arrays.sort(d_clone)을 굳이 한다면 d_clone[d_clone.length-1] 해도 되긴하겠다. 
        int answer = right; 
        
        // 3. 이분탐색
        while(left <= right){
            int mid = (left+right)/2;
            
            if(check(diffs, times, limit, mid)){
                // 가능하다면 더 낮은 숙련도 중에서 탐색 
                answer = mid;
                // right = mid; // 이렇게 하면 무한루프에 빠지는듯
                right = mid -1;
            }else {
                // 불가능하면 더 높은 숙련도 중에서 탐색 
                left = mid+1; 
            }
        }
        
        // answer = right; 
        
        
        
        return answer;
    }
}