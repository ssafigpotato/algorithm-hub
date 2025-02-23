

import java.util.*;

public class Main {
    static int M,N,K;
    static int[][] map;
    static boolean[][]visited;
    static int[]dr = {-1,0,1,0};
    static int[]dc = {0,1,0,-1};
    static class location{
        int r,c;
        location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int bfs(int r, int c){
        Queue<location> que = new LinkedList<>();
        que.offer(new location(r,c));
        visited[r][c] = true;
        int cnt = 1;

        while(!que.isEmpty()){
            location curr = que.poll();
            // curr주위의 이웃에게 방문
            for(int d = 0; d <4; d++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(nr<0 || nr >=M || nc <0 || nc >=N) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 1) continue;

                que.offer(new location(nr,nc));
                visited[nr][nc] = true;
                cnt++;
            }
        }
        return cnt;
    }
    static void print(){
        for(int i = 0; i <M; i++){
            for(int j = 0; j <N; j++){
                System.out.print(map[i][j]+" ");
            }System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // 세로
        N = sc.nextInt(); // 가로
        K = sc.nextInt(); // 직사각형 개수
        // x2-x1 만큼, y2-y1만큼 1로 표시
        // x는 가로!!! y는 세로1!!
        // 문제에서는 왼쪽 아래를 0,0이라고 했지만 넓이를 구하는 것이므로 왼위를 0,0으로 뒤집어서 봐도 무방할듯
        map = new int[M][N]; // 경계값도 될 수 있으므로 -> 경계값을 뺐으니까 그대로 M,N
        visited = new boolean[M][N];

        for(int i = 0; i <K; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int j = y1; j < y2; j++){ // 그리고 y2, x2는 빼야함!
                for(int k = x1; k < x2; k++){
                     //System.out.println(j+", "+k);
                    map[j][k] = 1;
                }
            }
            // print();
            // System.out.println("=========");
        }// 직사각형 부분 map에 그려주기

        // print();
        // 돌면서 0인 부분에서 bfs로 넓이 구해주기
        List<Integer> list = new ArrayList<>();
        int cnt = 0; // 영역의 개수
        for(int i = 0; i <M; i++){
            for(int j = 0; j <N; j++){
                // 0이면서 방문한적이 없을 떄
                if(map[i][j] == 0 && !visited[i][j]){
                    list.add(bfs(i,j));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(list);
        for(int i =0; i <list.size(); i++){
            System.out.print(list.get(i)+" ");
        }

    }
}
