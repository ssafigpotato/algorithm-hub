import java.util.*;
class Solution {
    // 슬라이딩 윈도우로 하면 될듯
    public int solution(int n, int m, int[] section) {
        // 1. n칸 중에 칠해야할 칸에 1표시 
        int[] arr = new int[n+1];
        for(int i = 0; i <section.length; i++){
            arr[section[i]] = 1;
        }
        
        // System.out.println(Arrays.toString(arr));
        
        // 2. 
        int answer = 0;
         
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == 1){
                for(int j = i; j < m+i && j <= n; j++){
                    arr[j] = 0; 
                }
                 answer++;
            }
//             System.out.println(Arrays.toString(arr));
//             System.out.println(answer);         
        }
    
        return answer;
    }
}