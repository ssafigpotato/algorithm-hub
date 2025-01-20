

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int M,N,H;
    static int[][][] map;
    static boolean[][][] visited;
    static int [][][]days;
    static int[]dr = {-1, 0, 1, 0, 0, 0}; // 상 하 좌 우 위 아래
    static int[]dc = {0, 1, 0, -1, 0, 0};
    static int[]dh = {0, 0, 0, 0, -1, 1};
    static class Location{
        int h;
        int r;
        int c;
        Location(int h, int r, int c){
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }
    static void bfs(){
        Queue<Location> que = new LinkedList<>();

        // 초기에 익은 토마토를 모두 큐에 넣기
        for(int i =0; i <H; i++){
            for(int j = 0; j <N; j++){
                for(int k = 0; k <M; k++){
                    if (map[i][j][k] == 1) {
                        que.offer(new Location(i, j, k));
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        while(!que.isEmpty()){
            Location curr = que.poll();

            // curr의 인접행렬 = 상하좌우 위 아래
            for(int d = 0; d <6; d++){
                int nh = curr.h + dh[d];
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                // 범위를 벗어났으면 continue
                // nh는 0이 될 수 없음 <-- 아님!!!! h 자체는 1부터 지만, nh 또한 똑같이 0번쨰부터 카운트 하므로 0이 될 수 있음!!!
//                if(nr<0 || nr >= N || nc <0 || nc >= M || nh<1 || nh >= H) continue;
                if(nr<0 || nr >= N || nc <0 || nc >= M || nh<0 || nh >= H) continue;
                // -1이면 continue
                // 이미 1인곳도 넘겨줘야 저장될때부터 모든 토마토가 익었을 때를 고려해주지 않을까?
                if(map[nh][nr][nc] == -1 || map[nh][nr][nc] == 1) continue;
                // 방문했으면 continue
                if(visited[nh][nr][nc]) continue;

                que.offer(new Location(nh, nr, nc));
                visited[nh][nr][nc] = true;
                map[nh][nr][nc] = 1; // 익음 처리
                // 근데 여기는 특정위치에 도달할때 까지의 최소 일수가 아니라 전체가 1로 뒤덮힐 때까지의 최소 일수잖아.
                // 그렇다고 curr뽑아내는 코드 밑에 전체를 검사해서 1이면 return 이런 조건을 해버리면 토마토가 모두 익지는 못하는 상황일 때 무한 루프에 빠질 수도 있고...그건아닌가?
                // 무한루프는 아니지만 처리하기 곤란해지겠군
                // bfs를 모두 돌리고 난 후에 check 해줘야겠군
                days[nh][nr][nc] = days[curr.h][curr.r][curr.c] + 1;

            }
        }
    }
    static boolean check(){
        for(int i = 0; i <H; i++){
            for(int j = 0; j <N; j++){
                for(int k = 0; k <M; k++){
                  if(map[i][j][k] == 0){ // 익지 않은 토마토가 남아있으면
                      return false;
                  }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // 상자의 가로 칸수
        N = sc.nextInt(); // 상자의 세로 칸 수
        H = sc.nextInt(); // 상자의 높이

        map = new int[H][N][M]; // 이렇게 하는 것이 맞나...?
        visited = new boolean[H][N][M]; // 방문 여부 저장 배열
        days = new int[H][N][M]; // 특정 위치까지 도달하는데 걸리는 시간(일 수) 저장 배열
        // 전체 H개의 층. N행 M열
        for(int i = 0; i <H; i++){
            for(int j = 0; j <N; j++){
                for(int k = 0; k <M; k++){
                    map[i][j][k] = sc.nextInt();
                }
            }
        }


        // 바로 bfs 돌리기
        bfs();
        // 확인용
//        for(int i = 0; i <H; i++){
//            for(int j = 0; j <N; j++){
//                for(int k = 0; k <M; k++){
//                   System.out.print(map[i][j][k]+" ");
//                }
//                System.out.println();
//            }
//        }


        int max = 0;
        if(check()){
            for(int i = 0; i <H; i++){
                for(int j = 0; j <N; j++){
                    for(int k = 0; k <M; k++){
                       max = Math.max(max, days[i][j][k]);
                    }
                }
            }
        }else {
            max = -1;
        }

        System.out.println(max);
    }
}
