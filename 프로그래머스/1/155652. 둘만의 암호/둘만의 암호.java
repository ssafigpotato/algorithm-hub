import java.util.*;
class Solution {
    // hashset으로 빠른 검색
    public String solution(String s, String skip, int index) {
        String answer = "";
        // 1. set에 skip 배열의 원소들 넣어주기 
        HashSet<Character> set = new HashSet<>(); 
        for(int i = 0; i < skip.length(); i++){
            set.add(skip.charAt(i));
        }
        
        // 소문자 a는 97 z는 122.
        // 123은 다시 a, 124는 b...
        // System.out.println((int) 'z');
        // 2. index만큼 curr를 이동시킴 
        for(char c : s.toCharArray()){
            char curr = c;
            int cnt = 0;
            
            // index만큼 curr를 이동시켜야함 (skip에 포함되면 cnt에 쳐 주지 않음!)
            while(cnt < index){
                curr++;
                // z범위를 넘으면 다시 a로 돌려주기 
                if(curr > 'z'){ // 하나씩 올라가니까 이렇게 하면 범위가 다시 a로 돌아감
                    curr = 'a';
                }
                // skip해야하는 set에 포함되어있지 않은 경우에만 cnt++ (기존에 했던거랑 반대로 생각하셈!!!)
                if(!set.contains(curr)){
                    cnt++;
                }
            }
            
            answer += curr;
            
        }
        
       
        return answer;
    }
}