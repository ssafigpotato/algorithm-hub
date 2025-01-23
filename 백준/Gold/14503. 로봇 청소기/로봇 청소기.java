

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int r,c;
    static int dir; // 현재 로청기 방향
    static int[][]map;
    static int[]dr = {-1, 0, 1, 0}; // 아 북 동 남 서로 하고 밑에서 반시계방향으로 돌려야하는군....
    static int[]dc = {0,1,0,-1};
    static class Location{
        int r;
        int c;
        int dir; // 방향
        Location(int r, int c, int dir){
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
    static boolean [][]visited;
    static int cnt; // 청소 횟수
    static void bfs(int r, int c, int dir){
        Queue<Location> que = new LinkedList<>();
        que.offer(new Location(r,c, dir));
        visited[r][c] = true;
        // 현재 칸 청소부터 시키기
        // 로봇 청소기가 있는 칸은 항상 빈 칸 이므로
         map[r][c] = 5;
        cnt = 1; // 청소 한 번

        while(!que.isEmpty()){
            Location curr = que.poll();
            boolean isClean = true; // 주변 4곳 모두 청소되어 있는지?
//            System.out.println("현재 칸: "+curr.r +", "+curr.c);
            // 주변 4칸 순회
            for(int d = 0; d <4; d++){
                int nd = (curr.dir + 3-d) % 4; // 주변 방향 (반시계로 돌아야함!!!!!!)
                int nr = dr[nd] + curr.r;
                int nc = dc[nd] + curr.c;

                if(nr>= 0 && nr < N && nc>= 0 && nc <M){
                    // 벽이면 넘기기
                    if(map[nr][nc] == 1) continue;
                    // 방문했던 곳이면 넘기기
                    if(visited[nr][nc]) continue;
                    // 청소가 안 되어 있으면
                    if(map[nr][nc] == 0){
                        // dir = nd; // 로청기 방향을 해당 방향으로 갱신하고, <-- 이게 더 헷갈림! 그리고 여기서 로직 꼬인듯 그냥 방향도 que에 한번에 넣어주기!
                        que.offer(new Location(nr, nc, nd)); // 그 방향으로 이동
//                        System.out.println("청소가 안 된 주변 칸 : "+nr +", "+nc);
                        visited[nr][nc] = true; // 방문 처리 해주고
                        isClean = false;
                        map[nr][nc] = 5; // 청소 표시 <-- 안 해줘도 될듯...?
//                        print();
                        cnt++; // 청소 횟수 ++
                        break; // <-- 왜 break로 탈출해야하는거지??
                    }
                }
            }
//            System.out.println("====================");
            if(isClean){ // 모두 청소되어 있다면
                int backDir = (curr.dir + 2) % 4; // 현재 방향의 반대 방향
                int nr = curr.r + dr[backDir];
                int nc = curr.c + dc[backDir];

                // nr, nc 범위 넘을 일은 없을 듯 가장 바깥쪽 줄들이 모두 1이라서 거기안갈듯
                // 벽이면 종료
                if(map[nr][nc] == 1) {
//                    System.out.println("벽이다: "+nr+", "+nc);
//                    print();
                    return;
                }else { // 벽이 아니면
                    // 방향 자체는 유지하고
                    que.offer(new Location(nr, nc, curr.dir)); // 후진한 칸으로 이동
                    // visited[nr][nc] = true;
                }
            }
        }

    }
    public static void print(){
        for(int i = 0; i <N; i++){
            for(int j = 0; j <M; j++){
                System.out.print(map[i][j]+" ");
            }System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 행
        M = sc.nextInt(); // 열
        map = new int[N][M];
        visited = new boolean[N][M];

        r = sc.nextInt(); // 로봇청소기 처음 위치
        c = sc.nextInt();
        dir = sc.nextInt(); // 방향
        for(int i = 0; i <N; i++){
            for(int j = 0; j <M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        cnt = 0;
        // 칸을 청소하면 -1로 갱신. 벽이 아니니까 후진은 할 수 있음
        // 현재칸에서 청소부터 시키고
        // 주변 4칸 중 청소되지 않은 칸이 있는지 확인
        // 있다면 -> 반시계 쭉쭉하다가 청소되어있지 않은 곳ㅇ으로 한칸 전진
        // 없다면 -> 방향 유지한 채로 반대쪽으로 후진
//        System.out.println("첫 위치: ("+r+","+c+")");
        bfs(r, c, dir);


        System.out.println(cnt);

    }
}
