

import java.util.Scanner;

public class Main {
    static int N, M, K;
    static int [][]map;
    static boolean [][]visited;
    static int[]dr = {-1,0,1,0};
    static int[]dc = {0,1,0,-1};
    static int cnt; // 음식물 쓰레기 크기
    static void dfs(int r, int c){
        visited[r][c] = true;
        cnt++; // 재귀 돌 때 마다 쓰레기 크기 1씩 커짐

        // 인접한 상하좌우에 대해서
        for(int d = 0; d <4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 위 조건을 먼저 해줘야 map이나 visited에서 nr,nc할 때 범위 벗어나는 예시에 카운트 안해줌!!
            if(nr <0 || nr >= N || nc <0 || nc >= M) continue;
            if(visited[nr][nc]) continue;
            if(map[nr][nc] == 0) continue;

            visited[nr][nc] = true;
            dfs(nr, nc);

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 세로
        M = sc.nextInt(); // 가로
        K = sc.nextInt(); // 음식물 쓰레기 개수

        visited = new boolean [N][M];
        map = new int[N][M];
        for(int i = 0; i <K; i++){
            int r = sc.nextInt();
            int c = sc.nextInt();

            map[r-1][c-1] = 1;
        }// 입력 끝

        int max = 0;
        for(int i = 0; i <N; i++){
            for(int j = 0; j <M; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    cnt = 0; // dfs 할 때마다 음식 물 쓰레기 크기 초기화
                    dfs(i,j);

                    max = Math.max(cnt, max);
                }
            }
        }

        System.out.println(max);

        sc.close();
    }
}
