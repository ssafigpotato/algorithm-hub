

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static double[]probability = new double[4]; // 동서남북으로 이동할 확률
    static boolean[][]visited; // 방문 좌표 체크
    static int[] dr = {0, 0, 1, -1}; // 동서남북
    static int[] dc = {1, -1, 0, 0};

    static double dfs(int depth, int r, int c, double prob){
        if(depth == N){ // N번 이동햇으면 현재경로 확률반환
            return prob;
        }
        double total = 0; // 초기화가 아닌 지역변수 역할
        for(int d = 0; d < 4; d++){ // 동이 끝나면 서,남,북으로 시작하는 경로의 prob합을 계속 total에 더함
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 방문했던 곳이면 continue
            if(visited[nr][nc]) continue;
            if(probability[d] == 0) continue; // 동서남북 중 방문가능성이 0이어도 continue

            visited[nr][nc] = true;
            // 동시에 일어날 확률은 곱하기 예) 동동서 확률 p*p*p니까 곱하기로 나타내기
            // 단순할 확률을 가진 경로가 여러개 있을텐데 그 사건들은 모두 동시에 일어날 수 없으니까 더하기로 나타내기
            total += dfs(depth+1, nr, nc, prob * probability[d]); // 동에서 시작하는 경로의 prob합을 total로 반환
            visited[nr][nc] = false;
        }
        return total; // 최종적으로 동시작 prob합 + 서시작 prob합 +... + 북시작 prob합 반환

    }
    public static void main(String[] args) throws IOException {
        // 로봇이 같은 곳을 한 번보다 많이 이동하지 않을 때, 로봇의 이동 경로가 단순
        // 중복순열 -> 모든 경우 , 순열 -> 단순 경로 -> 아 이게 아니고
        // 같은 곳을 다시 방문하지 않는 다는 뜻이군 -> 그럼 그냥 dfs
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        visited = new boolean[29][29]; // N이 최대 14이므로 중앙에서 시작한다고 가정했을 때 29, 29

        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i <4; i++){
            probability[i] = Double.parseDouble(st.nextToken()) / 100; // 동서남북
        }

        visited[14][14] = true;
        System.out.println(dfs(0, 14, 14, 1.0 )); // 시작지점을 중간으로

       //  System.out.println(Arrays.toString(probability));

    }
}
