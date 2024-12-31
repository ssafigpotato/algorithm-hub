import java.util.*;
class Solution {
    public static class location {
        int r; 
        int c; 
        location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static boolean check(int r, int c, char[][]map){
        if(r >= 0 && r< map.length && c >= 0 && c < map[0].length && map[r][c] != 'X' ) return true;
        return false; 
    }
    public int[] solution(String[] park, String[] routes) {
        char[][]map = new char[park.length][park[0].length()];
        // 1. map 배열에 담기 
        for(int i = 0; i < park.length; i++){
            String str = park[i];
            for(int j = 0; j <str.length(); j++){
                map[i][j] = str.charAt(j);
            }
        }
        // 확인 
        // for(int i = 0; i <map.length; i++){
        //     for(int j = 0; j <3; j++){
        //         System.out.print(map[i][j]+" ");
        //     }System.out.println();
        // }
        
        // 2. map 배열에서 S인 곳부터 시작
        // curr(현재 위치) = S인 곳 
        location curr = new location(0,0);
        flag: for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] == 'S'){
                    curr = new location(i,j); 
                    break flag;  // 찾고 전체 나가줘야 함!
                }
            }
        }
        // System.out.println("S위치 "+curr.r +", "+ curr.c);
        
        // 3. 델타배열 선언하기 
        int[]dr = {-1,0,1,0}; // 북, 동, 남, 서
        int[]dc = {0,1,0,-1};
        
        // 4. 시간 단축을 위해 map에 방향과 델타배열의 위치 넣어주기 
        HashMap<String, Integer> m = new HashMap<>();
        m.put("N", 0);
        m.put("E", 1);
        m.put("S", 2);
        m.put("W", 3);
        
        // 5. routes배열을 돌면서 
        for(int i = 0; i < routes.length; i++){
            // 5-1. 방향, 거리 분리하기 
            String[] arr = routes[i].split(" ");
            int len = Integer.parseInt(arr[1]);
            int dir = m.get(arr[0]); 
            
            // 5-2. nr, nc 초기화  (현 위치에서 시작)
            // flag 선언. nr,nc 탈출할 때 초기화 하고 나가거나 flag상태에 따라 하기 
            int nr = curr.r;
            int nc = curr.c;
            boolean flag = true; 
            
            // 5-3. 거리만큼 nr += 하기!
            // if dir.equals("N")이렇게 해도 되지만
            // 시간 단축을 위해 map사용 
            for(int j = 0; j < len; j++){
                nr += dr[dir];
                nc += dc[dir];
                
                if(!check(nr,nc,map)){
                    flag = false; 
                    // nr = curr.r;
                    // nc = curr.c;
                    break; // 조건에 맞지 않으면 다시 초기화 시켜주고 탈출 
                }
            }
            
            // 5-4. 현 위치 갱신
            if(flag){
                curr = new location(nr, nc);
            } // flag를 사용한다면 이렇게 해도 됨 
            // curr = new location(nr, nc);

            
            // System.out.println("routes "+i+"번쩨 "+curr.r+", "+curr.c);
        }
        
        int[] answer = {curr.r, curr.c};
        return answer;
    }
}