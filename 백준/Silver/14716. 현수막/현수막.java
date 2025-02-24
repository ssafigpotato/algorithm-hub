

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int M,N;
    static int[][]map;
    static int[]dr = {-1,-1,0,1,1,1,0,-1};
    static int[]dc = {0,1,1,1,0,-1,-1,-1};
    static boolean[][]visited;
    static class location{
        int r,c;
        location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static void bfs(int r, int c){
        Queue<location> que = new LinkedList<>();
        que.offer(new location(r,c));
        visited[r][c] = true;

        while(!que.isEmpty()){
            location curr = que.poll();
            for(int d = 0; d <8; d++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(nr<0 || nr>=M || nc<0 || nc>=N) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 0) continue;

                que.offer(new location(nr,nc));
                visited[nr][nc] = true;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // r
        N = sc.nextInt(); // c

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i <M; i++){
            for(int j = 0; j <N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int ans =0;
        for(int i = 0; i <M; i++){
            for(int j = 0; j <N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    bfs(i,j);
                    ans++;
                }
            }
        }

        System.out.println(ans);


    }
}
