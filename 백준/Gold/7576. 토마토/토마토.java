

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int M,N;
    static int[][]map;
    static boolean[][]visited;
    static int[]dr = {-1,0,1,0};
    static int[]dc = {0,1,0,-1};
    static int[][] days; // 각 위치에서 토마토가 익은데 걸린 날짜
    static int max = 0;

    static class Location{
        int r,c;
        Location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static Queue<Location> que;
    static void bfs(){

        while(!que.isEmpty()){
            Location curr = que.poll();

            // curr 주위 4방향 탐색
            for(int d = 0; d<4; d++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                // 범위 내의 토마토에 한해서
                // 방문한적이 없고 map[nr][nc] = 0 이면
                // 토마토 익힘!
                if(nr>=0 && nr <N && nc>=0 && nc<M){
                    if(!visited[nr][nc] && map[nr][nc] == 0){
                        que.offer(new Location(nr,nc));
                        map[nr][nc] = 1; // 익음 처리
                        days[nr][nc] = days[curr.r][curr.c] + 1;
                    }
                }
            }
        }
    }
    static boolean check(){ // map에 0이 있는지 체크 및 days의 맥스값 확인
        for(int i = 0; i <N; i++){
            for(int j = 0; j <M; j++){
                max = Math.max(max, days[i][j]);
                if(map[i][j] == 0){ // 0이 하나라도 있으면 false
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // 가로 칸 수 (열)
        N = sc.nextInt(); // 세로 칸 수 (행)
        map = new int[N][M];
        visited = new boolean[N][M];
        days = new int[N][M];

        for(int i = 0; i <N; i++){
            for(int j = 0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        // map을 돌면서 방문하지 않았으면서 1(익은토마토)면 bfs
        // 최소 날짜니까
        // <-- 이렇게 하면 순차적으로 돌게됨 한 번에 큐에 넣어주고 시작해야함
        // 한번에 큐에 넣어줘야 큐에 넣은 순서대로 (이미 주어진 익은 토마토부터 bfs돌게 되니까!)
        que = new LinkedList<>(); // 여기서 선언
        for(int i = 0; i <N; i++){
            for(int j = 0; j <M; j++){
//                if(map[i][j] == 1 && !visited[i][j]){ // <-- 여기서는 큐에 넣기만 하니까 방문 체크도 안 해줘도 되겠다!
                if(map[i][j] == 1){
                    que.offer(new Location(i,j));
                    visited[i][j] = true; // 여기서 방문체크
                }
            }
        }

        // 넣고 나서 이제 bfs돌리기
        bfs();

        // 확인용
//        for(int i = 0; i <N; i++){
//            for(int j= 0; j <M; j++){
//                System.out.print(days[i][j]+" ");
//            }System.out.println();
//        }
        // 이미 처음부터 다 익은 상태: days의 최댓값이 0인 상태
        // 다 익지는 못하는 상태 map에 0이 남아있는 상태
        if(check()){
            System.out.println(max);
        }else {
            System.out.println(-1);
        }

    }
}
