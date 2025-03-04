

import java.util.Scanner;

public class Main {
    static int R,C;
    static int K;
    static char[][]map;
    static boolean[][]visited;
    static class location{
        int r,c;
        location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int cnt = 0;
    static void dfs(int depth, int r, int c){
        if(depth == K){ // <- 이렇게 하면 잘 안 나올수도 잇음
            if(r == 0 && c == C-1){ // 도달했을 때만 cnt++;
                cnt++;
            }
            return;
        }
//        if(r == 0 && c == C-1){ // 도착했을 때의 거리를 탐색!
//            if(depth == K) cnt++;
//            return;
//        }

        for(int d = 0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr>= 0 && nr < R && nc >= 0 && nc < C){
                if(map[nr][nc] != 'T' && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    dfs(depth+1, nr, nc);
                    visited[nr][nc] = false;
                }
            }
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt(); // 행
        C = sc.nextInt(); // 열

        K = sc.nextInt(); // 거리
        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i = 0; i <R; i++){
            String str = sc.next();
            for(int j = 0; j <C; j++){
                map[i][j] = str.charAt(j);
            }
        } // 입력 끝

        visited[R-1][0] = true;  // 출발지도 방문 처리!
        dfs(1,R-1, 0); // <- 첫 시작부터 거리 1임!
        System.out.println(cnt);




    }
}
