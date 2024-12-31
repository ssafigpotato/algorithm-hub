import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        // 1. map에 wallpaper입력
        char[][]map = new char[wallpaper.length][wallpaper[0].length()];
        for(int i = 0; i < wallpaper.length; i++){
            String str = wallpaper[i];
            for(int j = 0; j < str.length(); j++){
                map[i][j] = str.charAt(j);
            }
        }
        
        // 2. 가장 위, 가장 아래, 가장 동, 가장 서에 위치한 파일 찾기
        int top = 50; // 더 작은 값 갱신필요
        int bottom = 0; // 더 큰 값 갱신필요 
        int west = 50;
        int east = 0;
        
        for(int i = 0; i <map.length; i++){
            for(int j = 0; j <map[0].length; j++){
                if(map[i][j] == '#'){
                    int r = i;
                    int c = j;
                    
                    top = Math.min(top, r); // 왼쪽 위 점이므로 그대로 하면 됨
                    bottom = Math.max(bottom, r+1); // 오른쪽 아래 점이므로 +1
                    west = Math.min(west, c); 
                    east = Math.max(east, c+1); 
                    
                }
            }
        }
        
        int[] answer = {top, west, bottom, east};
        return answer;
    }
}