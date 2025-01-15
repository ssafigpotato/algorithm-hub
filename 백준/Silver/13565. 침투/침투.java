

import java.util.Scanner;

public class Main {
    static int N, M;
    static char[][]map;
    static boolean[][]visited;
    static int[]dr = {-1,0,1,0};
    static int[]dc = {0,1,0,-1};
    static boolean success = false; // 안쪽까지 침투했는지 여부
    static void dfs(int r, int c){ // 안쪽까지 잘 전달되는지.. 그러니까 (M-1, ?) 까지 도달하는지 true/ false 반납
        if(success) return; //여기에 flag를 넣어서 싹 다 종료시켜주기

        visited[r][c] = true;

        // (M-1, ?)에 도달하면 성공 하고 바로 끝내야함!!!
        if(r == M-1) {
            success = true;
            return; // 여기서 return true 이렇게만 하면 해당 재귀만 종료하고 다시 계속 탐색하니까 결국 항상 false를 반환하게 되는거였음 .
            // -> 재귀 호출이 성공(true 반환)해도, 그 값이 상위 재귀로 제대로 전달되지 않았기 때문에 결국 모든 호출이 끝난 후 항상 false가 반환!
        } 

        for(int d = 0; d <4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr< 0 || nr >= M || nc < 0 || nc >= N) continue;
            if(map[nr][nc] == '1') continue;
            if(visited[nr][nc]) continue;
            // 방문하지 않았고, 전류가 흐를 수 있는 경로(0)일 경우
            dfs(nr, nc);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        map = new char[M][N];
        for(int i = 0; i <M; i++){
            String str = sc.next();
            for(int j = 0; j <N; j++){
                map[i][j] = str.charAt(j);
            }
        }// 입력 끝

        // 1. (0, ?)에서 dfs를 쭈루륵 했을 때 (M-1, ?)가 되면 YES 아니면 NO
        visited = new boolean[M][N];
       // for(int j = 0; j <M; j++){
            for(int i = 0; i <N; i++){
                // visited = new boolean[M][N]; 매번 해줄 필요 없겠구나 어차피 저번에 방문했다면 경로가 같ㅌ은 거니까
                if(!visited[0][i] && map[0][i] == '0'){ // 방문하지 않았고, 0인경우만 시작하면 되겠다!
                   dfs(0,i);
                   if(success) break; // 성공했으면 더이상 탐색 하지 않기!
                }
            }
        //}
        System.out.println(success ? "YES" : "NO");
        sc.close();
    }
}
