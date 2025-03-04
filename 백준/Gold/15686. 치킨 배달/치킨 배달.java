

import java.util.*;

public class Main {
    static int N,M; // N*N크기의 맵, 뽑아야하는 치킨집 개수
    static int[][]map; // 지도
    static List<location> chicken = new ArrayList<>(); // 치킨집 전체 저장
    static List<location> house = new ArrayList<>(); // 집 전체 저장
    static class location{
        int r,c;
        location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static location[] pick; // 뽑은 치킨집 조합을 저장
    static int[]dr = {-1,0,1,0}; // 델타배열
    static int[]dc = {0,1,0,-1};
    static int min = Integer.MAX_VALUE; // 최종적으로 구해야할 치킨거리의 최솟값
    // 1. list.size()개의 치킨집 중에 M개를 뽑아서 -> 조합
    // 도시의 치킨거리를 구하기
    static void combination( int at, int depth){
        if(depth == M){ // M개의 치킨집을 선택했으면
            bfs(); // bfs를 돌려서 각 조합의 치킨거리 중 최솟값 구하기
            return;
        }

        for(int i = at; i < chicken.size(); i++){
            pick[depth] = chicken.get(i);
            combination(i+1, depth+1);
        }
    }
    static void bfs(){
        Queue<location> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int[][] distance = new int[N][N]; // 치킨집으로부터 각 집의 거리 저장
        int total = 0; // 해당 조합에서의 치킨 거리 합

        // 고른 치킨집을 모두 큐에 넣기
        for(location c : pick){
            que.offer(c);
            visited[c.r][c.c] = true;
            distance[c.r][c.c] = 0;
        }

        // 큐에 넣어서 한 번에 돌리므로 각 치킨집으로부터 각 가정집까지 최솟값이 저장됨 -> 3차원 토마토 풀이 참고!
        // 큐에 들어간 치킨집들부터 우선적으로 계산되기 때문에 더 큰값이 distance에 저장되지 않으려나 하는 우려는 ㄴㄴ
        // (큐에 들어간 순서가 영향이 없음! 그냥 한번에 배달 시작한다고 생각하면됨)
        while(!que.isEmpty()){
            location curr = que.poll();

            for(int d = 0; d<4; d++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(nr>= 0 && nr <N && nc>= 0 && nc <N){
//                    if(!visited[nr][nc] && map[nr][nc] != 2){ // 방문하지 않았고, 치킨집이 아니면
//                    <-- map[nr][nc] != 2 이 조건때문에 예제 4의 경우 4번째열은 계산되지 않았음!
                    if(!visited[nr][nc]){
                        que.offer(new location(nr, nc));
                        visited[nr][nc] = true;
                        distance[nr][nc] = distance[curr.r][curr.c] +1;

                    }
                }
            }
        }

        for(location h : house){  // 각 집에 저장된 거리를 모두 더하면 해당 조합에서 얻은 치킨 거리가 나옴!
            total += distance[h.r][h.c];
        }
        min = Math.min(min, total); // 위에서 계산된 조합들 중 bfs를 돌때마다 가장 최솟값으로 갱신

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //N*N
        M = sc.nextInt(); // 골라야할 치킨집 개수
        map = new int[N][N];
        pick = new location[M]; // 고른 치킨집 저장

        for(int i = 0; i <N; i++){
            for(int j = 0; j <N; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 2){
                    chicken.add(new location(i,j)); // 치킨집 전체 저장
                }else if(map[i][j] == 1){
                    house.add(new location(i,j));
                }
            }
        }// 입력 끝

        // 0. 치킨집을 고르는 로직 -> combination
        // 1. 1일 때 bfs를 돌리기
        // 2. 각 치킨집 조합에 대해 그 때의 치킨거리를 구하기 -> 최솟값 갱신

        combination( 0,0);
        System.out.println(min);

    }
}
