
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int[][]map;
    static boolean[][]visited;
    static int[]dr = {-1,-1,0,1,1,1,0,-1}; // 팔방탐색
    static int[]dc = {0,1,1,1,0,-1,-1,-1};
    static class location{
        int r,c;
        location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static void bfs(int r, int c){
        visited = new boolean[N][M]; // 각 상어마다 다시 방문체크하기 안그러면 더 최소 거리로 갱신이 안됨
        Queue<location> que = new LinkedList<>();
        que.offer(new location(r,c));
        visited[r][c] = true;

        while(!que.isEmpty()){
            location curr = que.poll();
            for(int d =0; d <8; d++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(nr<0 || nr >=N || nc<0 || nc >=M ) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 0) continue; // 다른 아기상어가 있는 곳은 continue;

                que.offer(new location(nr,nc));
                visited[nr][nc] = true;
                // 현재거리보다 1 커짐
                // 근데 다른 상어에서 잰 거리가 더 가까울 수 있으므로 둘 중 최솟값으로 갱신
                map[nr][nc] = Math.min(map[curr.r][curr.c] + 1, map[nr][nc]);
            }
        }
    }
    static int max(){
        int max = Integer.MIN_VALUE;
        for(int i =0; i <N; i++){
            for(int j = 0; j <M; j++){
                if(max < map[i][j]){
                    max = map[i][j];
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 세로 r
        M = sc.nextInt(); // 가로 c
        map = new int[N][M];
        visited = new boolean[N][M];
        // bfs하고 최소거리로 업데이트 시키기

        for(int i = 0; i < N; i++){
            for(int j = 0; j <M; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 0){
                    map[i][j] = Integer.MAX_VALUE; // 아기 상어가 없는 곳은 최댓값으로 바꿔!
                }
                if(map[i][j] == 1){
                    map[i][j] = 0; // 아기상어가 있는 곳은 0으로
                }
            }
        }

        // 돌면서 아기상어가 있는 곳부터 bfs시작
        for(int i = 0; i <N; i++){
            for(int j= 0; j <M; j++){
                if(map[i][j] == 0 ){
                    bfs(i,j);
                }
            }
        }
        System.out.println(max());
    }
}
