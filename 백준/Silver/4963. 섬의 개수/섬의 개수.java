

import java.util.Scanner;

public class Main {
    static int[]dr = {-1,-1,-1,0,1,1,1,0};
    static int[]dc = {-1,0,1,1,1,0,-1,-1};
    static boolean[][]visited;
    static int[][]map;
    static int h,w;
    static int ans;
    static void dfs(int r, int c){
        visited[r][c] = true; // 현재 방문한 곳 방문처리

        // 8방탐색으로 연결된 곳으로 가기
        for(int d = 0; d <8; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            // 1) map 범위를 벗어났으면 넘기기
            if(nr>= h || nr < 0 || nc >= w || nc < 0) continue;
            // 2) 1이 아니면 넘기기
            if(map[nr][nc] == 0) continue;
            // 3) 방문하지 않았으면 방문
            if(!visited[nr][nc]) {
                dfs(nr, nc);
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            w = sc.nextInt();
            h = sc.nextInt();
            if(w == 0 && h == 0) break;

            map = new int[h][w]; // 테캐 마다 초기화
            visited = new boolean[h][w];

            for(int i = 0; i <h; i++){
                for(int j = 0; j<w; j++){
                    map[i][j] = sc.nextInt();
                }
            }// 입력 끝

            // 확인
//            for(int i = 0; i <h; i++){
//                for(int j = 0; j <w; j++){
//                    System.out.print(map[i][j]+" ");
//                }System.out.println();
//            }

            ans = 0; // 각 테캐마다 초기화
            // map에서 1이면 dfs 탐색 시작
            // 이어져있으면 하나의 섬 (가로, 세로, 대각선)
            // 탐색하는 횟수가 섬의 개수
            for(int i =0; i <h; i++){
                for(int j = 0; j <w; j++){
                    if(map[i][j] == 1 && !visited[i][j]){ // 값이 1이고, 방문하지 않았으면 dfs 시작
                        ans++;
                        dfs(i,j);
                    }
                }
            }

            System.out.println(ans);

        }
    }
}
