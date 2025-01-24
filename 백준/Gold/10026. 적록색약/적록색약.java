

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static char [][]map;
    static boolean [][]visited;
    static int[]dr = {-1,0,1,0};
    static int[]dc = {0,1,0,-1};
    static class Location{
        int r,c;
        Location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static void bfs(int r, int c){
        Queue<Location> que = new LinkedList<>();
        visited[r][c] = true;
        que.offer(new Location(r,c));

        while(!que.isEmpty()){
            Location curr = que.poll();

            for(int d = 0; d <4; d++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(nr>= 0 && nr <N && nc>= 0 && nc <N){
                    // 방문한적이 없고, 현재 값과 같은 값이라면 이동!
                    if(!visited[nr][nc] && map[curr.r][curr.c] == map[nr][nc]){
                        que.offer(new Location(nr,nc));
                        visited[nr][nc] = true;
                    }
                }
            }
        }





    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i <N; i++){
            String str = sc.next();
            for(int j = 0; j <N; j++){
                map[i][j] = str.charAt(j);
            }
        }

        int n1 = 0;
        int n2 = 0;
        // 적록색약 아닌 사람
        for(int i = 0; i <N; i++){
            for(int j = 0; j <N; j++){
                if(!visited[i][j]){ // 방문한 적 없는 곳은 모두 bfs1
                    bfs(i,j);
                    n1++; // bfs1 한 수 만큼 구역있음
                }
            }
        }

        // 적록색약인 사람
        for(int i = 0; i <N; i++){
            for(int j = 0; j <N; j++){
                if(map[i][j] == 'G'){
                    map[i][j] = 'R';
                }
            }
        }

        visited = new boolean[N][N]; // 초기화
        for(int i = 0; i <N; i++){
            for(int j = 0; j <N; j++){
                if(!visited[i][j]){ // 방문한 적 없는 곳은 모두 bfs1
                    bfs(i,j);
                    n2++; // bfs1 한 수 만큼 구역있음
                }
            }
        }
        System.out.println(n1+" "+n2);

    }
}
